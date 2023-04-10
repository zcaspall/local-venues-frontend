package com.example.local_venues_frontend.ui.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp


@Preview
@Composable
fun LoginScreen() {
    var value by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = { newText ->
                value = newText
            },
            label = { Text(text = "Username") },
            placeholder = { Text(text = "Enter your Username")}
        )
        OutlinedTextField(
            value = value,
            onValueChange = { newText ->
                value = newText
            },
            label = { Text(text = "Password") },
            placeholder = { Text(text = "Enter your Password")}
        )
        Button(onClick = {  }) {
            Text("Submit")
        }
        TextButton(onClick = { /*TODO*/ }) {
            
        }
    }
}