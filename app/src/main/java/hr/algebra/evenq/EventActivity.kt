package hr.algebra.evenq

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import hr.algebra.evenq.adapters.EXTRA_EVENT
import hr.algebra.evenq.databinding.ActivityEventBinding
import hr.algebra.evenq.network.model.Event
import java.time.LocalDateTime

class EventActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEventBinding

    private lateinit var selectedEvent: Event

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEventBinding.inflate(layoutInflater)
        setContentView(binding.root)

        selectedEvent = intent.getSerializableExtra(EXTRA_EVENT) as Event

        fillEventData()


    }

    @SuppressLint("SetTextI18n")
    private fun fillEventData() {
        binding.tvEventTitle.text = selectedEvent.title
        binding.tvEventDescription.text = selectedEvent.description

        val date = LocalDateTime.parse(selectedEvent.date)
        binding.tvEventDate.text =
            date.dayOfWeek.toString() + ", " + date.dayOfMonth + "." + date.monthValue.toString() + "." +
                    " " + date.hour.toString() + ":00"

        binding.tvEventTicketPrice.text = selectedEvent.ticketPrice.toString()

        binding.tvEventLocation.text = selectedEvent.location.street + ", " + selectedEvent.location.city
    }
}