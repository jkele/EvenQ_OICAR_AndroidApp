package hr.algebra.evenq.network

import hr.algebra.evenq.network.model.Event
import hr.algebra.evenq.network.model.Location
import retrofit2.http.GET
import retrofit2.http.Path

interface EventService {

    @GET("Event/UpcomingEvents")
    suspend fun getUpcomingEvents(): ArrayList<Event>

    @GET("Location/{locationId}")
    suspend fun getLocationById(@Path("locationId")locationId: Int): Location

}