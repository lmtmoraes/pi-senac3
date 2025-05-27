package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class LoginViewModel : ViewModel() {
    private val _username = MutableStateFlow("")
    private val _password = MutableStateFlow("")

    val username: StateFlow<String> get() = _username
    val password: StateFlow<String> get() = _password

    fun onUsernameChange(newUsername: String) {
        _username.value = newUsername
    }

    fun onPasswordChange(newPassword: String) {
        _password.value = newPassword
    }

    fun performLogin() {
        // TODO: Implement login logic
    }
}