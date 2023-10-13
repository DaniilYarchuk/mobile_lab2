package com.example.lab2_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button: Button = findViewById(R.id.button)
        val button2: Button = findViewById(R.id.button2)
        val number: EditText = findViewById(R.id.editTextNumberDecimal)

        button.setOnClickListener()
        {
            val intent = Intent(this@MainActivity, MainActivity2::class.java)
            startActivity(intent)
            return@setOnClickListener
        }

        button2.setOnClickListener()
        {
            val num1=number.text.toString()

            if (num1.isEmpty())
            {
                val message = "Введите число!"
                val duration = Toast.LENGTH_SHORT

                val toast = Toast.makeText(applicationContext, message, duration)
                toast.show()
                return@setOnClickListener
            }
            if (num1.toInt()>9 || num1.toInt()<1)
            {
                val message = "Число должно быть больше 0 и меньше 10!"
                val duration = Toast.LENGTH_SHORT

                val toast = Toast.makeText(applicationContext, message, duration)
                toast.show()
                return@setOnClickListener
            }
            val intent = Intent(this@MainActivity, MainActivity4::class.java)
            intent.putExtra("number", num1.toInt())
            startActivity(intent)
        }
    }
}