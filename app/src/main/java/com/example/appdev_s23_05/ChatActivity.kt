package com.example.appdev_s23_05

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appdev_s23_05.Message
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ChatActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var chattingWithTextView: TextView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Find the TextView by its ID
        chattingWithTextView = findViewById(R.id.chattingWithTextView)

        // Set its text to the name of the person you are chatting with
        chattingWithTextView.text = "Anakin Code-Wrecker"

        val messages = arrayListOf(
            Message("Anakin", "12:00 AM", "Obi-Wan, I hate XML. It's coarse, rough, and irritating. And it gets everywhere, just like sand.", MessageType.INCOMING),
            Message("Obi-Wan", "12:05 PM", "Patience, my young Padawan. XML can be a powerful tool in the right hands.", MessageType.OUTGOING),
            Message("Anakin", "12:10 PM", "But it's so verbose and clunky! It takes forever to write even simple layouts.", MessageType.INCOMING),
            Message("Obi-Wan", "12:15 PM", "Ah, but you underestimate its power. With XML, you can create complex and beautiful user interfaces.", MessageType.OUTGOING),
            Message("Anakin", "12:20 PM", "I don't know, it just seems like a waste of time. I'd rather just write everything in code.", MessageType.INCOMING),
            Message("Obi-Wan", "12:25 PM", "Don't try it, Anakin! I have the higher ground!", MessageType.OUTGOING),
            Message("Anakin", "12:30 PM", "What does that have to do with XML?", MessageType.INCOMING),
            Message("Obi-Wan", "12:35 PM", "Nothing, I just always wanted to say that.", MessageType.OUTGOING),
            Message("Anakin", "12:40 PM", "Ugh, you and your XML. I'll never understand why you love it so much.", MessageType.INCOMING),
            Message("Obi-Wan", "12:45 PM", "It's all about structure, Anakin. XML helps us create order out of chaos.", MessageType.OUTGOING),
            Message("Anakin", "12:50 PM", "Well, I prefer a little chaos in my code.", MessageType.INCOMING),
            Message("Obi-Wan", "12:55 PM", "Then you are lost!", MessageType.OUTGOING),
        )
// Initialize and set the adapter to the recycler view
        val adapter = CustomAdapter(messages)
        recyclerView.adapter = adapter
    }

}
// Data class to represent a single chat message
data class Message(
    val senderName: String,
    val dateInfo: String,
    val messageText: String,
    val messageType: MessageType
)
// Enumeration to represent the type of message (incoming or outgoing)
enum class MessageType {
    INCOMING,
    OUTGOING
}
// Adapter class for the recycler view
class CustomAdapter(private val messageList: ArrayList<Message>) :
    RecyclerView.Adapter<CustomAdapter.CustomViewHolder>() {
    // View holder class to represent a single message item
    inner class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val senderTextView: TextView = itemView.findViewById(R.id.senderTextView)
        val timeTextView: TextView = itemView.findViewById(R.id.timeTextView)
        val messageTextView: TextView = itemView.findViewById(R.id.messageTextView)
    }
    // Creates and returns a new view holder object when needed
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return if (viewType == com.example.appdev_s23_05.MessageType.INCOMING.ordinal) {
            val view = inflater.inflate(R.layout.item_incoming_message, parent, false)
            CustomViewHolder(view)
        } else {
            val view = inflater.inflate(R.layout.item_outgoing_message, parent, false)
            CustomViewHolder(view)
        }
    }
    // Binds data to the view holder objects
    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        val currentItem = messageList[position]
        holder.senderTextView.text = currentItem.senderName
        holder.timeTextView.text = currentItem.dateInfo
        holder.messageTextView.text = currentItem.messageText
    }
    // Returns the number of messages in the list
    override fun getItemCount(): Int {
        return messageList.size
    }
    // Returns the view type of the message (incoming or outgoing)
    override fun getItemViewType(position: Int): Int {
        return messageList[position].messageType.ordinal
    }
}