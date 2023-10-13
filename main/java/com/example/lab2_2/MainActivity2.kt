package com.example.lab2_2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val result: EditText = findViewById(R.id.editTextNumberDecimal2)
        val text_rand=findViewById<TextView>(R.id.textView)
        val text_result=findViewById<TextView>(R.id.textView2)
        val button3: Button = findViewById(R.id.button3)
        val button4: Button = findViewById(R.id.button4)
        var rand1: Int = Random.nextInt(9)+1
        var rand2: Int = Random.nextInt(9)+1
        var count: Int = 0
        var success: Int = 0
        button4.setEnabled(false);
        text_rand.text=rand1.toString() + "*" + rand2.toString()
        button3.setOnClickListener()
        {
            val input=result.text.toString()
            if (input.isEmpty())
                return@setOnClickListener

            if (input.toInt()==rand1*rand2)
            {
                text_result.text="Правильный ответ"
                success+=1
            }
            else
                text_result.text="Неверный ответ"
            button3.setEnabled(false);
            button4.setEnabled(true);
        }
        button4.setOnClickListener()
        {
            count+=1
            if (count>3)
            {
                val percent: Float =success.toFloat() / count.toFloat() * 100
                val intent = Intent(this@MainActivity2, MainActivity3::class.java)
                intent.putExtra("count", count.toString())
                intent.putExtra("success", success.toString())
                intent.putExtra("percent", percent.toString())
                startActivity(intent)
                return@setOnClickListener
            }
            result.setText("")
            rand1 = Random.nextInt(9)+1
            rand2 = Random.nextInt(9)+1
            text_rand.text=rand1.toString() + "*" + rand2.toString()
            text_result.text=""
            button3.setEnabled(true);
            button4.setEnabled(false)
        }

    }
}