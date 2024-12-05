package com.example.mma_application

class EventsRepository {
    suspend fun getEvents(): List<Event> {
        val response = MMAorgAPI.api.getTournamentSchedule(19906, 15, 9, 2024)
        if (response.isSuccessful) {
            return response.body()?.events ?: emptyList()
        } else {
            throw Exception("Pogreška: ${response.code()}")
        }
    }
}
