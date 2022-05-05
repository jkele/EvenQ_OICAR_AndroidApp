package hr.algebra.evenq.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import hr.algebra.evenq.database.model.TicketDb

@Dao
interface TicketDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTicket(ticket: TicketDb)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllTickets(list: ArrayList<TicketDb>)

    @Query("SELECT * FROM userTickets")
    fun getTickets() : LiveData<List<TicketDb>>

}