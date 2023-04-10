package com.example.local_venues_frontend.ui.search

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Icon
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun SearchScreen() {
    var value by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        OutlinedTextField(
            value = value,
            onValueChange = { newText ->
                value = newText
            },
            label = { Text(text = "Search") },
            placeholder = { Text(text = "Search by keyword") },
            leadingIcon = { Icon( imageVector = Icons.Default.Search, contentDescription = "Search Icon" ) }
        )
        Row() {
            TextButton(onClick = { /*TODO*/ }) {
                Text("Bands")
            }
            TextButton(onClick = { /*TODO*/ }) {
                Text("Venues")
            }
            TextButton(onClick = { /*TODO*/ }) {
                Text("Near Me")
            }
        }
    }
}