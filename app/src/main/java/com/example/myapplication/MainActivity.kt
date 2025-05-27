package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapplication.navigation.Screen
import com.example.myapplication.screens.LoginFormScreen
import com.example.myapplication.screens.LoginScreen
import com.example.myapplication.screens.RegisterScreen
import com.example.myapplication.screens.ScheduleScreen
import com.example.myapplication.screens.MyAppointmentsScreen
import com.example.myapplication.ui.theme.MyApplicationTheme
import com.example.myapplication.viewmodel.ScheduleViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                NavigationHandler()
            }
        }
    }
}

@Composable
fun NavigationHandler() {
    var currentScreen by remember { mutableStateOf(Screen.Login) }
    var userType by remember { mutableStateOf("Cliente") } // Valor padrão para userType
    val scheduleViewModel: ScheduleViewModel = viewModel()

    // Mock data for appointments
    val appointments = remember { mutableStateListOf<Triple<String, String, String>>() }

    when (currentScreen) {
        Screen.Login -> LoginScreen(userType = userType, onRegisterClick = {
            userType = it
            currentScreen = Screen.Register
        }, onScheduleClick = {
            userType = it
            currentScreen = Screen.LoginForm
        })

        Screen.LoginForm -> LoginFormScreen(
            onLoginClick = {
                currentScreen = Screen.Schedule
            }
        )

        Screen.Register -> RegisterScreen(
            onLoginClick = {
                currentScreen = Screen.Login
            }
        )

        Screen.Schedule -> ScheduleScreen(
            viewModel = scheduleViewModel,
            onConfirmAppointment = { date, time, service ->
                appointments.add(Triple(date, time, service))
                currentScreen = Screen.MyAppointments
            },
            onBackClick = {
                currentScreen = Screen.LoginForm
            }
        )

        Screen.MyAppointments -> MyAppointmentsScreen()
    }
}