package com.example.mma_application

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class EventsViewModelFactory(private val repository: EventsRepository) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EventsViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return EventsViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}