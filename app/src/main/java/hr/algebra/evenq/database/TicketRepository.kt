package hr.algebra.evenq.database

import hr.algebra.evenq.database.model.TicketDb

class TicketRepository(private val ticketDao: TicketDao) {

    val readAllTickets = ticketDao.getTickets()

    suspend fun insertTicket(ticket: TicketDb){
        ticketDao.insertTicket(ticket)
    }

    suspend fun insertAllTickets(list: ArrayList<TicketDb>){
        ticketDao.insertAllTickets(list)
    }

}