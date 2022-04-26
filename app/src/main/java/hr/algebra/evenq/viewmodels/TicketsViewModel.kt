package hr.algebra.evenq.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hr.algebra.evenq.network.Network
import hr.algebra.evenq.network.model.Ticket
import kotlinx.coroutines.launch

class TicketsViewModel: ViewModel() {

    val ticketsList = MutableLiveData<ArrayList<Ticket>>()

    fun getTicketsForMember(memberId: String){
        viewModelScope.launch {
            ticketsList.value = Network().getService().getTicketsByMemberId(memberId)
        }
    }

}