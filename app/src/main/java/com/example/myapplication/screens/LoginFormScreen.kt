package com.example.myapplication.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun LoginFormScreen(onLoginClick: () -> Unit) {
    val email = remember { mutableStateOf("") }
    val phone = remember { mutableStateOf("") }
    val username = remember { mutableStateOf("") }
    val password = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Email", modifier = Modifier.padding(bottom = 8.dp))
        BasicTextField(
            value = email.value,
            onValueChange = { email.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .border(1.dp, Color.Gray)
                .padding(8.dp),
            decorationBox = { innerTextField ->
                Box(modifier = Modifier.fillMaxWidth()) { innerTextField() }
            }
        )

        Text(text = "Telefone", modifier = Modifier.padding(bottom = 8.dp))
        BasicTextField(
            value = phone.value,
            onValueChange = { phone.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .border(1.dp, Color.Gray)
                .padding(8.dp),
            decorationBox = { innerTextField ->
                Box(modifier = Modifier.fillMaxWidth()) { innerTextField() }
            }
        )

        Text(text = "Usuário", modifier = Modifier.padding(bottom = 8.dp))
        BasicTextField(
            value = username.value,
            onValueChange = { username.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .border(1.dp, Color.Gray)
                .padding(8.dp),
            decorationBox = { innerTextField ->
                Box(modifier = Modifier.fillMaxWidth()) { innerTextField() }
            }
        )

        Text(text = "Senha", modifier = Modifier.padding(bottom = 8.dp))
        BasicTextField(
            value = password.value,
            onValueChange = { password.value = it },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
                .border(1.dp, Color.Gray)
                .padding(8.dp),
            visualTransformation = PasswordVisualTransformation(),
            decorationBox = { innerTextField ->
                Box(modifier = Modifier.fillMaxWidth()) { innerTextField() }
            }
        )

        Button(
            onClick = onLoginClick,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Login")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginFormScreenPreview() {
    LoginFormScreen(onLoginClick = {})
}