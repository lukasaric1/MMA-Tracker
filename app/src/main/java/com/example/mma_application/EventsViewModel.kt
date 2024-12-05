package com.example.mma_application

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class EventsViewModel : ViewModel() {
    private val _events = MutableStateFlow<List<Event>>(emptyList())
    val events: StateFlow<List<Event>> = _events

    private val _error = MutableStateFlow<String?>(null)
    val error: StateFlow<String?> = _error

    init {
        fetchEvents()
    }

    private fun fetchEvents() {
        viewModelScope.launch {
            try {
                val response = MMAorgAPI.api.getTournamentSchedule(19906, 15, 9, 2024)
                if (response.isSuccessful) {
                    _events.value = response.body()?.events ?: emptyList()
                } else {
                    _error.value = "Pogreška: ${response.code()}"
                }
            } catch (e: Exception) {
                _error.value = "Greška: ${e.message}"
            }
        }
    }
}
