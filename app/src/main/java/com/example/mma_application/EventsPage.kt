package com.example.mma_application

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import androidx.compose.runtime.*
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun EventsPage(
    modifier: Modifier = Modifier
) {
    val repository = remember { EventsRepository() }
    val viewModel: EventsViewModel = viewModel(factory = EventsViewModelFactory(repository))
    val events by viewModel.events.collectAsState() // Dohvaćanje stanja događaja
    val error by viewModel.error.collectAsState()

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF170202)),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        if (error != null) {
            Text(
                text = "Greška: $error",
                fontSize = 20.sp,
                color = Color.Red
            )
        } else if (events.isEmpty()) {
            Text(
                text = "Učitavam događaje...",
                fontSize = 20.sp,
                color = Color.White
            )
        } else {
            Column(
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                events.forEach { event ->
                    Text(
                        text = "Naziv: ${event.title}, Lokacija: ${event.location}",
                        fontSize = 18.sp,
                        color = Color.White
                    )
                }
            }
        }
    }
}
