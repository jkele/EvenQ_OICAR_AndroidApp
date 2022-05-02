package hr.algebra.evenq.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.util.Base64
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.common.util.Base64Utils
import com.google.android.gms.common.util.Hex
import hr.algebra.evenq.EventActivity
import hr.algebra.evenq.R
import hr.algebra.evenq.databinding.EventItemViewBinding
import hr.algebra.evenq.network.model.Event
import java.math.BigInteger
import java.nio.ByteBuffer
import java.time.LocalDateTime

val EXTRA_EVENT = "hr.algebra.evenq.extraEvent"

class EventItemRecyclerAdapter(
    private val context: Context,
    private val eventsList: ArrayList<Event>
): RecyclerView.Adapter<EventItemRecyclerAdapter.EventItemViewHolder>() {

    class EventItemViewHolder(view: View): RecyclerView.ViewHolder(view){
        val binding = EventItemViewBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EventItemViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.event_item_view, parent, false)
        return EventItemViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: EventItemViewHolder, position: Int) {
        val event = eventsList[position]

        holder.binding.tvEventTitle.text = event.title

        val date = LocalDateTime.parse(event.date)

        holder.binding.tvEventDate.text =
            date.dayOfWeek.toString() + ", " + date.dayOfMonth + "." + date.monthValue.toString() + "." +
                    " " + date.hour.toString() + ":00"

        if(event.description.isNotEmpty()){
            if (event.description.length > 58){
                holder.binding.tvEventDescription.text = event.description.take(58) + "..."
            } else {
                holder.binding.tvEventDescription.text = event.description + "..."
            }
        }

        if (event.posterImage != null){
            val bytes = Base64.decode(event.posterImage, Base64.DEFAULT)
            holder.binding.ivEventImage.setImageBitmap(BitmapFactory.decodeByteArray(bytes, 0, bytes.size))
        }

        holder.binding.root.setOnClickListener {
            val intent = Intent(context, EventActivity::class.java).apply {
                putExtra(EXTRA_EVENT, event)
            }
            context.startActivity(intent)
        }

    }


    override fun getItemCount(): Int {
        return eventsList.size
    }

}