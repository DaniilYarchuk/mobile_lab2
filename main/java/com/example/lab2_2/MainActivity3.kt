package com.example.lab2_2

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)
        val count = intent.getStringExtra("count")
        val success = intent.getStringExtra("success")
        val percent = intent.getStringExtra("percent")
        val result=findViewById<TextView>(R.id.textView5)
        val result_percent=findViewById<TextView>(R.id.textView6)
        result.text=success + " из " + count
        result_percent.text=percent+"%"
        val button5: Button = findViewById(R.id.button5)
        button5.setOnClickListener()
        {
            val intent = Intent(this@MainActivity3, MainActivity::class.java)
            startActivity(intent)
            return@setOnClickListener
        }
        }

    }
