package com.example.fyp_mobapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import com.example.fyp_mobapp.MainActivity
import java.lang.Exception

class MessageAdapter(var context: Context, var messageList: ArrayList<Message>): RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {
    private var USER_LAYOUT = 1234
    private var BOT_TXT_LAYOUT = 0
    private var BOT_IMG_LAYOUT = 1
    private var BOT_BUT_LAYOUT = 2

    class MessageViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val messageView  = view.findViewById<TextView>(R.id.message_tv)
        //val time_view    = view.findViewById<TextView>(R.id.time_tv)
        val image_view   = view.findViewById<ImageView>(R.id.image_tv)
        val button_view  = view.findViewById<RecyclerView>(R.id.button_list)
        //val button_view  = view.findViewById<RecyclerView>(R.id.message_list)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        var view: View

        if (viewType == BOT_TXT_LAYOUT || viewType == BOT_IMG_LAYOUT) {
            view = LayoutInflater.from(context).inflate(R.layout.bot_message_box, parent, false)
        } else if (viewType == BOT_BUT_LAYOUT) {
            //view = LayoutInflater.from(context).inflate(R.layout.bot_message_box, parent, false)
            view = LayoutInflater.from(context).inflate(R.layout.activity_main, parent, false)
        } else {
            view = LayoutInflater.from(context).inflate(R.layout.user_message_box, parent, false)
        }

        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val message = messageList[position]

        if (message.sender == BOT_TXT_LAYOUT.toString()){ // || message.sender == BOT_BUT_LAYOUT.toString()) {
            holder.messageView.text = message.message as String

            try {
                holder.image_view.visibility = View.GONE
                holder.button_view.visibility = View.GONE
                //holder.time_view.visibility = View.GONE
            } catch (e: Exception) { }

        } else if (message.sender == BOT_IMG_LAYOUT.toString()) {
            val image = holder.image_view as ImageView
            Glide.with(context).load(message.message).into(image)

            try {
                holder.messageView.visibility == View.GONE
                holder.button_view.visibility = View.GONE
                //holder.time_view.visibility = View.GONE
            } catch (e: Exception) { }

        } else if (message.sender == BOT_BUT_LAYOUT.toString()) {
            try {
                holder.messageView.visibility == View.GONE
                holder.image_view.visibility = View.GONE
                //holder.time_view.visibility = View.GONE
            } catch (e: Exception) { }

        } else { // USER_LAYOUT
            holder.messageView.text = message.message as String

            try {
                holder.image_view.visibility = View.GONE
                //holder.time_view.visibility = View.GONE
            } catch (e: Exception) { }
        }
    }

    override fun getItemCount(): Int {
        return messageList.size
    }

    override fun getItemViewType(position: Int): Int {
        super.getItemViewType(position)

        val view = messageList[position]

        if (view.sender == BOT_TXT_LAYOUT.toString()) {
            return BOT_TXT_LAYOUT
        } else if (view.sender == BOT_IMG_LAYOUT.toString()) {
            return BOT_IMG_LAYOUT
        } else if (view.sender == BOT_BUT_LAYOUT.toString()) {
            return BOT_BUT_LAYOUT
        } else { // USER_LAYOUT
            return USER_LAYOUT
        }
    }
}