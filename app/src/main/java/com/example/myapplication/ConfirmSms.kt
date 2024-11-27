package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_confirm_sms.*


class ConfirmSms : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirm_sms)
        val n = intent.getStringExtra("tel")
        val m = intent.getStringExtra("txt")
        textView4.text = n
        editTextTextMultiLine2.setText(m)

        button2.setOnClickListener {
            val num = textView4.text.toString()
            val txt = textView4.text.toString()

            val uri = Uri.parse("smsto:$num?body=$txt")
            val i = Intent(Intent.ACTION_SENDTO,uri)
            startActivity(i)
        }
        button3.setOnClickListener {
            val i = Intent(this,WriteSMS::class.java)
        }
    }
}