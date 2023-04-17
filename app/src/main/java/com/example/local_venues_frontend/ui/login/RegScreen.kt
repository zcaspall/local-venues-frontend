package com.example.local_venues_frontend.ui.login

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Preview
@Composable
fun RegistrationPage() {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var username by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Registration", style = MaterialTheme.typography.h4)
        Spacer(modifier = Modifier.height(16.dp))

        OutlinedTextField(
            value = firstName,
            onValueChange = { firstName = it },
            label = { Text(text = "First Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = lastName,
            onValueChange = { lastName = it },
            label = { Text(text = "Last Name") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = username,
            onValueChange = { username = it },
            label = { Text(text = "Username") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = email,
            onValueChange = { email = it },
            label = { Text(text = "Email") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text(text = "Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))

        OutlinedTextField(
            value = confirmPassword,
            onValueChange = { confirmPassword = it },
            label = { Text(text = "Confirm Password") },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                // Validate form data
                if (firstName.isBlank() || lastName.isBlank() || username.isBlank() ||
                    email.isBlank() || password.isBlank() || confirmPassword.isBlank()
                ) {
                    // Show error message if any field is empty
                    // You can handle this based on your app's requirements
                    // For simplicity, just showing a Snackbar here
                    // You need to import the Snackbar library from Jetpack Compose
                    // implementation "com.google.android.material:material:<version>"
                    // And add the import statement: import androidx.compose.material.Snackbar
                    // You also need to remember to provide a Scaffold in your main activity
                    // to host the Snackbar, as it requires a Scaffold for proper display
                    // You can add Scaffold in your MainActivity.kt file, similar to how it's done for Compose navigation
                    // Scaffold: https://developer.android.com/reference/kotlin/androidx/compose/material/package-summary#scaffold
                    // Navigation with Compose: https://developer.android.com/guide/navigation/navigation-compose
                    // Example: Scaffold to host Snackbar
                    // remember to import androidx.compose.material.Scaffold
                    // Scaffold { ... }

                    // Show error Snackbar
                    // Remember to import androidx.compose.material.SnackbarDuration
                    // Snackbar { ... }
                    // You can customize the error message as per your app's requirements
                    // Here, showing a generic error message for simplicity
                    // This is just a basic error handling approach, you can customize it based on your app's requirements
                } else if (password != confirmPassword) {
                    // Show error message if password and confirm password do not match
                    // You can customize the error message as per your app's requirements
                    // Here, showing a generic error message for simplicity
                    // This is just a basic error handling approach, you can customize it based on your app's requirements
                } else {
                    // Form data is valid, send registration request

                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(text = "Register")
        }
    }
}