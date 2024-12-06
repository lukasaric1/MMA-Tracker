package com.example.mma_application


data class TournamentSchedule(
    val id: Int,
    val name: String,
    val events: List<Event>
)

data class Event(
    val eventId: Int,
    val title: String,
    val date: String,
    val location: String,
    val name: String,
    val fightType: String,
    val tournament: Tournament
)

data class Tournament(
    val name: String,
)

