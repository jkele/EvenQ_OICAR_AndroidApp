package hr.algebra.evenq.network.model

import hr.algebra.evenq.database.model.TicketDb

data class Ticket(
    val idTicket: String,
    val ticketQR: String,
    val member: Member,
    val memberId: String,
    val event: Event,
    val eventId: Int,
    val isValid: Boolean
) {

    fun convertToTicketDb(): TicketDb {
        return TicketDb(
            this.idTicket,
            this.ticketQR,
            this.member,
            this.memberId,
            this.event,
            this.eventId,
            this.isValid
        )
    }
}