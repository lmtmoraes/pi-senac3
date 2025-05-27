package com.example.myapplication.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class RegisterViewModel : ViewModel() {
    private val _email = MutableStateFlow("")
    private val _username = MutableStateFlow("")
    private val _password = MutableStateFlow("")

    val email: StateFlow<String> get() = _email
    val username: StateFlow<String> get() = _username
    val password: StateFlow<String> get() = _password

    fun onEmailChange(newEmail: String) {
        _email.value = newEmail
    }

    fun onUsernameChange(newUsername: String) {
        _username.value = newUsername
    }

    fun onPasswordChange(newPassword: String) {
        _password.value = newPassword
    }

    fun performRegister() {
        // TODO: Implement register logic
    }
}