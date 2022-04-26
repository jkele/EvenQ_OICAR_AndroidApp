package hr.algebra.evenq.network

import hr.algebra.evenq.network.model.Event
import hr.algebra.evenq.network.model.Location
import hr.algebra.evenq.network.model.Ticket
import retrofit2.http.GET
import retrofit2.http.Path

interface EventService {

    @GET("Event/UpcomingEvents")
    suspend fun getUpcomingEvents(): ArrayList<Event>

    @GET("Ticket/{memberId}")
    suspend fun getTicketsByMemberId(@Path("memberId")memberId: String) : ArrayList<Ticket>

    @GET("Location/{locationId}")
    suspend fun getLocationById(@Path("locationId")locationId: Int): Location

}