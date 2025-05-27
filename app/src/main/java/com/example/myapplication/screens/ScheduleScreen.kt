package com.example.myapplication.screens

import android.widget.Toast
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.myapplication.viewmodel.ScheduleViewModel
import java.time.LocalDate
import java.time.LocalTime
import java.time.format.DateTimeFormatter

@Composable
fun ScheduleScreen(viewModel: ScheduleViewModel, onConfirmAppointment: (String, String, String) -> Unit, onBackClick: () -> Unit) {
    val selectedDate = viewModel.selectedDate.collectAsState()
    val selectedTime = viewModel.selectedTime.collectAsState()
    var selectedService: String by remember { mutableStateOf("Corte") }

    val availableTimes = listOf(
        LocalTime.of(9, 0), LocalTime.of(10, 0), LocalTime.of(11, 0),
        LocalTime.of(13, 0), LocalTime.of(14, 0), LocalTime.of(15, 0)
    )

    val context = LocalContext.current

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(text = "Selecione uma data:", modifier = Modifier.padding(bottom = 8.dp))

        LazyRow(modifier = Modifier.fillMaxWidth()) {
            items(7) { offset ->
                val date = LocalDate.now().plusDays(offset.toLong())
                Button(
                    onClick = { viewModel.onDateSelected(date) },
                    modifier = Modifier
                        .padding(4.dp)
                        .border(
                            width = if (selectedDate.value == date) 2.dp else 0.dp,
                            color = if (selectedDate.value == date) Color.Blue else Color.Transparent
                        )
                ) {
                    Text(text = date.format(DateTimeFormatter.ofPattern("dd MMM")))
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Selecione um horário:", modifier = Modifier.padding(bottom = 8.dp))

        LazyRow(modifier = Modifier.fillMaxWidth()) {
            items(availableTimes.size) { index ->
                val time = availableTimes[index]
                Button(
                    onClick = { viewModel.onTimeSelected(time) },
                    modifier = Modifier
                        .padding(4.dp)
                        .border(
                            width = if (selectedTime.value == time) 2.dp else 0.dp,
                            color = if (selectedTime.value == time) Color.Blue else Color.Transparent
                        )
                ) {
                    Text(text = time.format(DateTimeFormatter.ofPattern("HH:mm")))
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(text = "Selecione um serviço:", modifier = Modifier.padding(bottom = 8.dp))

        LazyRow(modifier = Modifier.fillMaxWidth()) {
            items(3) { index ->
                val service = when (index) {
                    0 -> "Corte"
                    1 -> "Barba"
                    else -> "Corte e Barba"
                }
                val price = when (index) {
                    0 -> "R$20"
                    1 -> "R$20"
                    else -> "R$35"
                }
                Button(
                    onClick = { selectedService = service },
                    modifier = Modifier
                        .padding(4.dp)
                        .border(
                            width = if (selectedService == service) 2.dp else 0.dp,
                            color = if (selectedService == service) Color.Blue else Color.Transparent
                        )
                ) {
                    Text(text = "$service - $price")
                }
            }
        }

        Spacer(modifier = Modifier.height(32.dp))

        Button(onClick = {
            val date = selectedDate.value.format(DateTimeFormatter.ofPattern("dd MMM, yyyy"))
            val time = selectedTime.value?.format(DateTimeFormatter.ofPattern("HH:mm")) ?: ""

            if (time.isNotEmpty()) {
                Toast.makeText(
                    context,
                    "Agendamento confirmado: $date às $time - Serviço: $selectedService",
                    Toast.LENGTH_SHORT
                ).show()
                onConfirmAppointment(date, time, selectedService)
            } else {
                Toast.makeText(
                    context,
                    "Por favor, selecione um horário para o seu agendamento",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }) {
            Text(text = "Confirmar Agendamento")
        }

        Spacer(modifier = Modifier.height(16.dp))

        selectedDate.value.let {
            Text(text = "Data selecionada: ${it.format(DateTimeFormatter.ofPattern("dd MMM, yyyy"))}")
        }

        selectedTime.value?.let {
            Text(text = "Horário selecionado: ${it.format(DateTimeFormatter.ofPattern("HH:mm"))}")
        }

        Text(text = "Serviço selecionado: $selectedService")
    }
}