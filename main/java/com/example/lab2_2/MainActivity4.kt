package com.example.lab2_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.random.Random

class MainActivity4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)
        val number1 = intent.getIntExtra("number",1)
        var number2: Int = Random.nextInt(9) + 1
        val button_otvetit: Button = findViewById(R.id.activity4_otvetit)
        val button_dalee: Button = findViewById(R.id.activity4_dalee)
        val text_rand=findViewById<TextView>(R.id.activity4_chisla)
        val result: EditText = findViewById(R.id.activity_4_vvod)
        var count: Int = 0
        var success: Int = 0
        val text_result = findViewById<TextView>(R.id.activity4_otvet)
        text_rand.text=number1.toString() + "*" + number2.toString()
        button_otvetit.setOnClickListener()
        {
            val input = result.text.toString()
            if (input.isEmpty())
                return@setOnClickListener

            if (input.toInt() == number1 * number2) {
                text_result.text = "Правильный ответ"
                success += 1
            } else
                text_result.text = "Неверный ответ"
            button_otvetit.setEnabled(false);
            button_dalee.setEnabled(true);
        }

        button_dalee.setOnClickListener()
        {
            count+=1
            if (count>3)
            {
                val percent: Float =success.toFloat() / count.toFloat() * 100
                val intent = Intent(this@MainActivity4, MainActivity3::class.java)
                intent.putExtra("count", count.toString())
                intent.putExtra("success", success.toString())
                intent.putExtra("percent", percent.toString())
                startActivity(intent)
                return@setOnClickListener
            }
            result.setText("")
            number2 = Random.nextInt(9)+1
            text_rand.text=number1.toString() + "*" + number2.toString()
            text_result.text=""
            button_otvetit.setEnabled(true);
            button_dalee.setEnabled(false)
        }

    }
}