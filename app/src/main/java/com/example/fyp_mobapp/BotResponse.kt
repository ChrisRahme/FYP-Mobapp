package com.example.fyp_mobapp

class BotResponse(var recipient: String = "1234", var text: String = "", var image: String = "", var buttons: List<Buttons>) {
    inner class Buttons(var payload: String, var title: String = "Button")
}