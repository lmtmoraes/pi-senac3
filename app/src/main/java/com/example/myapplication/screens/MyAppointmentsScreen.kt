package com.example.myapplication.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun MyAppointmentsScreen() {
    val context = LocalContext.current

    // Mock data for appointments
    val appointments = remember {
        mutableStateListOf(
            Triple("25/05/2025 às 10:00", "Corte", "R$20"),
            Triple("26/05/2025 às 14:00", "Barba", "R$20"),
            Triple("27/05/2025 às 16:00", "Corte e Barba", "R$35")
        )
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Meus Agendamentos", modifier = Modifier.padding(bottom = 16.dp))

        appointments.forEach { (appointment, service, price) ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(text = appointment)
                    Text(text = "$service - $price")
                }

                Button(onClick = {
                    appointments.remove(Triple(appointment, service, price))
                    Toast.makeText(context, "$appointment cancelado", Toast.LENGTH_SHORT).show()
                }) {
                    Text(text = "Cancelar")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MyAppointmentsScreenPreview() {
    MyAppointmentsScreen()
}