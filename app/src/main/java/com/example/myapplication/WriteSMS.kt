package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_write_sms.*


class WriteSMS : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_write_sms)

        button.setOnClickListener {
            val num = editTextPhone.text.toString()
            val txt = editTextTextMultiLine.text.toString()

            val i = Intent(this,ConfirmSms::class.java)
            i.putExtra("tel", "$num")
            i.putExtra("txt","$txt")
            startActivity(i)
        }
    }

}