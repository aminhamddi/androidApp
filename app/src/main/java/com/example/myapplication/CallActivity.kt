package com.example.myapplication

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_call.*

class CallActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_call)
        button4.setOnClickListener {
           val num = editTextPhone3.text.toString()
            val uri = Uri.parse("tel:$num")
            val i = Intent(Intent.ACTION_DIAL,uri)
            startActivity(i)
        }
    }
}