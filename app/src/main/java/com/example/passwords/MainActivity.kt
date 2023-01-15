package com.example.passwords

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val et_name: EditText = findViewById(R.id.et_name)
        val et_name2: EditText = findViewById(R.id.et_name2)
        val button: TextView = findViewById(R.id.button)
        val register:TextView = findViewById(R.id.register)

        register.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)

        }
        button.setOnClickListener {
            if (et_name.text.isEmpty() || et_name2.text.isEmpty()) {
                Toast.makeText(
                    this,
                    "Please fill up your credentials username/password",
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                val username = et_name.text.toString()
                val password = et_name2.text.toString()
                val intent = Intent(this, MainActivity2::class.java).also {
                    it.putExtra("Username", username)
                    it.putExtra("Password", password)
                    startActivity(it)
                    finish()
                }
            }
        }
    }
}