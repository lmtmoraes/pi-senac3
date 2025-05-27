package com.example.myapplication.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun BackButton(onBackClick: () -> Unit) {
    IconButton(
        onClick = onBackClick,
        modifier = Modifier.padding(8.dp)
    ) {
        Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Voltar")
    }
}