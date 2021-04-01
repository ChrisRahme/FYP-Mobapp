package com.example.fyp_mobapp

import android.os.Bundle
import android.telephony.SmsMessage
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.fyp_mobapp.databinding.ActivityMainBinding
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.Callback
import retrofit2.Response
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var mainActivity: ActivityMainBinding
    private lateinit var messageList:ArrayList<Message>
    private lateinit var adapter: MessageAdapter
    private val USER = 0
    private val BOT = 1

    private val ip   = "2c431b2b5fb2.ngrok.io" //"localhost:5005"
    private val url  = "https://$ip:/webhooks/rest/" // ⚠️MUST END WITH "/"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        messageList = ArrayList<Message>()
        mainActivity = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainActivity.root)

        adapter = MessageAdapter(this, messageList)
        adapter.setHasStableIds(true)
        mainActivity.messageList.adapter = adapter

        val linearLayoutManager = LinearLayoutManager(this)
        linearLayoutManager.orientation = LinearLayoutManager.VERTICAL
        mainActivity.messageList.layoutManager = linearLayoutManager

        mainActivity.sendButton.setOnClickListener {
            val msg = mainActivity.messageBox.text.toString()

            if (msg != "") {
                sendMessage(msg)
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
            adapter.notifyDataSetChanged()
        }

        val okHttpClient = OkHttpClient()
        val retrofit = Retrofit.Builder().baseUrl(url).client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).build()
        val messageSender = retrofit.create(MessageSender::class.java)
        val response = messageSender.sendMessage(userMessage)

        response.enqueue(object: Callback<ArrayList<BotResponse>> {
            override fun onResponse(call: Call<ArrayList<BotResponse>>, response: Response<ArrayList<BotResponse>>) {
                if (response.body() != null && response.body()!!.size != 0) {
                    val message = response.body()!![0]
                    messageList.add(Message(message.text, BOT))
                    adapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<ArrayList<BotResponse>>, t: Throwable) {
                val message = "Sorry, something went wrong:\n" + t.message
                messageList.add(Message(message, BOT))
                adapter.notifyDataSetChanged()
            }
        })
    }
}