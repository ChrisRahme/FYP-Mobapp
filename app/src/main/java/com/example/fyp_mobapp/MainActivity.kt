package com.example.fyp_mobapp

import android.os.Bundle
import android.telephony.SmsMessage
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fyp_mobapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainActivity: ActivityMainBinding
    private lateinit var messageList:ArrayList<Message>
    private val USER = 0
    private val BOT = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        messageList = ArrayList<Message>()
        mainActivity = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainActivity.root)

        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        mainActivity.messageList.layoutManager = linearLayoutManager

        val adapter = MessageAdapter(this, messageList)
        mainActivity.messageList.adapter = adapter

        mainActivity.sendButton.setOnClickListener {
            val msg = mainActivity.messageBox.text.toString()

            if (msg != "") {
                sendMessage(msg)
                adapter.notifyItemInserted(messageList.size - 1)
                Toast.makeText(this, "Message sent", Toast.LENGTH_SHORT).show()
                mainActivity.messageBox.setText("")
            } else {
                Toast.makeText(this, "Please enter a message.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun sendMessage(message: String) {
        var userMessage = Message()

        if (message.isEmpty()) {
            Toast.makeText(this, "Please enter a message.", Toast.LENGTH_SHORT).show()
        } else {
            userMessage = Message(message, USER)
            messageList.add(userMessage)
        }
    }
}