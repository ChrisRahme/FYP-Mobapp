package com.example.fyp_mobapp

import android.os.Bundle
import android.content.Context
import android.telephony.SmsMessage
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*

import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.example.fyp_mobapp.databinding.ActivityMainBinding

import com.google.android.material.button.MaterialButton
import com.google.android.material.floatingactionbutton.FloatingActionButton

import java.text.SimpleDateFormat
import java.util.*

import kotlin.collections.ArrayList

import okhttp3.OkHttpClient

import retrofit2.Call
import retrofit2.Callback
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import retrofit2.Response
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private lateinit var mainActivity: ActivityMainBinding
    private lateinit var messageList:ArrayList<Message>
    private lateinit var adapter: MessageAdapter
    private lateinit var editText: EditText
    private lateinit var sendBtn: FloatingActionButton
    private lateinit var button_view: RecyclerView

    private val ip   = "303e5a44931f.ngrok.io" //"194.126.17.114" //"xxx.ngrok.io" //"localhost:5005"
    private val url  = "http://$ip:/webhooks/rest/" // ⚠️MUST END WITH "/"

    private val USER = "M-" + UUID.randomUUID().toString()
    private val BOT_TXT = "0"
    private val BOT_IMG = "1"
    private val BOT_BUT = "2"

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
            val msg = mainActivity.messageBox.text.toString().trim()

            if (msg != "") {
                sendMessage(msg)
                mainActivity.messageBox.setText("")
            } else {
                Toast.makeText(this, "Please enter a message.", Toast.LENGTH_SHORT).show()
            }
        }

        sendMessage(message = "Hello", display = false)
    }

    fun sendMessage(message: String, alternative: String = "", display: Boolean = true) {
        val displayedMessage  = if (alternative.isNullOrEmpty()) message else alternative
        var userMessage       = Message(USER, message) // The message that will be sent to Rasa (payload in case of buttons)
        var userDisplayed     = Message(USER, displayedMessage) // The message that will be displayed on screen (title in case of buttons)

        if (display) {
            messageList.add(userDisplayed)
            adapter.notifyDataSetChanged()
        }

        //val date = Date(System.currentTimeMillis())
        val okHttpClient = OkHttpClient()
        val retrofit = Retrofit.Builder().baseUrl(url).client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).build()
        val messageSender = retrofit.create(MessageSender::class.java)
        val response = messageSender.sendMessage(userMessage)

        response.enqueue(object: Callback<ArrayList<BotResponse>> {
            override fun onResponse(call: Call<ArrayList<BotResponse>>, response: Response<ArrayList<BotResponse>>) {
                if (response.body() != null && response.body()!!.size != 0) {
                    for (i in 0 until response.body()!!.size) {
                        val message = response.body()!![i]

                        try {
                            if (message.text.isNotEmpty()) {
                                messageList.add(Message(BOT_TXT, message.text))
                            } else if (message.image.isNotEmpty()) {
                                messageList.add(Message(BOT_IMG, message.image))
                            }
                        } catch (e: Exception) { }

                        try {
                            if (message.buttons != null) {
                                val buttonRecyclerView = ButtonRecyclerView(this@MainActivity, message.buttons)
                                val layoutManager = LinearLayoutManager(this@MainActivity)

                                button_view = findViewById<RecyclerView>(R.id.button_list)
                                //button_view = findViewById<RecyclerView>(R.id.message_list)
                                button_view.adapter = buttonRecyclerView

                                layoutManager.orientation = LinearLayoutManager.HORIZONTAL
                                button_view.layoutManager = layoutManager
                                /*for (j in 0 until message.buttons.size) {
                                    messageList.add(Message(BOT_TXT, message.buttons[j].title))*/
                            }
                        } catch (e: Exception) { }

                        adapter.notifyDataSetChanged()
                    }
                } else {
                    val message = "Sorry, something went wrong:\nReceived empty response."
                    messageList.add(Message(BOT_TXT, message))
                    adapter.notifyDataSetChanged()
                }
            }

            override fun onFailure(call: Call<ArrayList<BotResponse>>, t: Throwable) {
                t.printStackTrace()
                val message = "Sorry, something went wrong:\n" + t.message
                messageList.add(Message(BOT_TXT, message))
                adapter.notifyDataSetChanged()
            }
        })
    }

    inner class ButtonRecyclerView(var context: Context, var buttons: List<BotResponse.Buttons>) : RecyclerView.Adapter<ButtonRecyclerView.ButtonViewHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ButtonViewHolder {
            return ButtonViewHolder(LayoutInflater.from(context).inflate(R.layout.button_list_item, parent, false))
        }

        override fun onBindViewHolder(holder: ButtonViewHolder, position: Int) {
            val button = buttons[position]
            holder.button.text = button.title
            holder.button.setOnClickListener {
                sendMessage(button.payload, button.title)
            }
        }

        override fun getItemCount(): Int {
            buttons.isEmpty() ?: return -1
            return buttons.size

        }

        inner class ButtonViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val button = view.findViewById<MaterialButton>(R.id.payload_button)
        }
    }
}