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
    class MessageViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val linear_layout = view.findViewById<LinearLayout>(R.id.linear_layout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.message_list_item, parent, false)
        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val message = messageList[position]
        if (message.sender == 0) {
            val v = getUserLayout()
            holder.linear_layout.addView(v)
            val message_tv = v?.findViewById<TextView>(R.id.message_tv_user)
            message_tv?.setText(message.message)
        } else {
            val v = getBotLayout()
            holder.linear_layout.addView(v)
            val message_tv = v?.findViewById<TextView>(R.id.message_tv_bot)
            message_tv?.setText(message.message)
        }

    }

    override fun getItemCount(): Int {
        return messageList.size
    }

    fun getUserLayout(): FrameLayout? {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        return inflater.inflate(R.layout.user_message_box, null) as FrameLayout?
    }

    fun getBotLayout(): FrameLayout? {
        val inflater: LayoutInflater = LayoutInflater.from(context)
        return inflater.inflate(R.layout.bot_message_box, null) as FrameLayout?
    }
}