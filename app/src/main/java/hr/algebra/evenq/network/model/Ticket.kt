package hr.algebra.evenq.network.model

class Ticket(
    val idTicket: String,
    val ticketQR: String,
    val member: Member,
    val memberId: String,
    val event: Event,
    val eventId: Int,
    val isValid: String
) {
}