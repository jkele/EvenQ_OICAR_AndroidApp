package hr.algebra.evenq.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import hr.algebra.evenq.network.Network
import hr.algebra.evenq.network.model.Location
import kotlinx.coroutines.launch

class LocationViewModel: ViewModel() {

    val location = MutableLiveData<Location>()

    fun getLocation(locationId: Int){
        viewModelScope.launch {
            location.value = Network().getService().getLocationById(locationId)
        }
    }

}