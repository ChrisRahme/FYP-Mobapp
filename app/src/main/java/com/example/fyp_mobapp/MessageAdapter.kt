package com.example.fyp_mobapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MessageAdapter(var context: Context, var messageList: ArrayList<Message>): RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {
    private var USER_LAYOUT = 1
    private var BOT_LAYOUT = 0

    class MessageViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val messageView = view.findViewById<TextView>(R.id.message_tv)
        val time_view = view.findViewById<TextView>(R.id.time_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        var view: View

        if (viewType == BOT_LAYOUT) {
            view = LayoutInflater.from(context).inflate(R.layout.bot_message_box, parent, false)
        } else {
            view = LayoutInflater.from(context).inflate(R.layout.user_message_box, parent, false)
        }

        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        holder.messageView.text = messageList[position].message
    }

    override fun getItemCount(): Int {
        return messageList.size
    }

    override fun getItemViewType(position: Int): Int {
        super.getItemViewType(position)

        val view = messageList[position]

        if (view.sender == BOT_LAYOUT) {
            return BOT_LAYOUT
        } else {
            return USER_LAYOUT
        }
    }
}