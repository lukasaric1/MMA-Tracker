package com.example.mma_application

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface OrganizationAPI {
    @GET("unique-tournament/{id}/schedules/{day}/{month}/{year}")
    suspend fun getTournamentSchedule(
        @Path("id") tournamentId: Int,
        @Path("day") day: Int,
        @Path("month") month: Int,
        @Path("year") year: Int
    ): Response<TournamentSchedule>
}