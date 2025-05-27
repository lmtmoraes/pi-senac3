package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.time.LocalDate
import java.time.LocalTime

class ScheduleViewModel : ViewModel() {
    private val _selectedDate = MutableStateFlow(LocalDate.now())
    private val _selectedTime = MutableStateFlow<LocalTime?>(null)

    val selectedDate: StateFlow<LocalDate> get() = _selectedDate
    val selectedTime: StateFlow<LocalTime?> get() = _selectedTime

    fun onDateSelected(newDate: LocalDate) {
        _selectedDate.value = newDate
    }

    fun onTimeSelected(newTime: LocalTime) {
        _selectedTime.value = newTime
    }
}