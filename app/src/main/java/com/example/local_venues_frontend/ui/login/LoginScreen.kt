package com.example.local_venues_frontend.ui.login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.local_venues_frontend.model.Auth
import com.example.local_venues_frontend.model.User
import com.example.local_venues_frontend.ui.login.RegScreen
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.local_venues_frontend.Registration


@Composable
fun LoginScreen(
    modifier: Modifier
) {
    val userViewModel: UserViewModel = viewModel(factory = UserViewModel.Factory)
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text(text = "Username") },
            placeholder = { Text(text = "Enter your Username")}
        )
        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation(),
            placeholder = { Text(text = "Enter your Password")}
        )
        Button(onClick = {
            val auth = Auth(username, password)
            userViewModel.loginUser(auth)
        }) {
            Text("Submit")
        }
        TextButton(onClick = { userViewModel.NavigateToRegistration() }) {
            Text("Register")
        }
    }
}