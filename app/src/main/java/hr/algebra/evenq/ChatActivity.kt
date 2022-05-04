package hr.algebra.evenq

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import hr.algebra.evenq.adapters.EXTRA_EVENT_DATE
import hr.algebra.evenq.adapters.EXTRA_EVENT_NAME
import hr.algebra.evenq.databinding.ActivityChatBinding

class ChatActivity: AppCompatActivity() {

    private lateinit var binding: ActivityChatBinding

    private lateinit var eventName: String
    private lateinit var eventDate: String

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        binding = ActivityChatBinding.inflate(layoutInflater)
        setContentView(binding.root)

        eventName = intent.getStringExtra(EXTRA_EVENT_NAME).toString()
        eventDate = intent.getStringExtra(EXTRA_EVENT_DATE).toString()
    }

}