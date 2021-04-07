package com.example.fyp_mobapp

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MessageAdapter(var context: Context, var messageList: ArrayList<Message>): RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {
    private var USER_LAYOUT = 1234
    private var BOT_TXT_LAYOUT = 0
    private var BOT_IMG_LAYOUT = 1

    class MessageViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val messageView = view.findViewById<TextView>(R.id.message_tv)
        val time_view   = view.findViewById<TextView>(R.id.time_tv)
        val image_view  = view.findViewById<ImageView>(R.id.image_tv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {
        var view: View

        if (viewType == BOT_TXT_LAYOUT || viewType == BOT_IMG_LAYOUT) {
            view = LayoutInflater.from(context).inflate(R.layout.bot_message_box, parent, false)
        } else {
            view = LayoutInflater.from(context).inflate(R.layout.user_message_box, parent, false)
        }

        return MessageViewHolder(view)
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
        val message = messageList[position]

        if (message.sender == BOT_TXT_LAYOUT.toString()) {
            holder.messageView.text = message.message

            holder.time_view.visibility = View.GONE
            holder.image_view.visibility = View.GONE

        } else if (message.sender == BOT_IMG_LAYOUT.toString()) {
            val image = holder.image_view as ImageView
            Glide.with(context).load(message.message).into(image)

            holder.messageView.visibility == View.GONE
            holder.time_view.visibility = View.GONE

        } else { // USER_LAYOUT
            holder.messageView.text = message.message

            holder.image_view.visibility = View.GONE
            holder.time_view.visibility = View.GONE
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
        } else { // USER_LAYOUT
            return USER_LAYOUT
        }
    }
}