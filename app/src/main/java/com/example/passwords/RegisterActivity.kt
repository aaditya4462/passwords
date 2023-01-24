package com.example.passwords

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Initialize Firebase Auth
        auth = Firebase.auth


        val loginText :TextView = findViewById(R.id.logintext)
        loginText.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        val sign_up: TextView = findViewById(R.id.sign_up)
        sign_up.setOnClickListener {
            performsignup()
        }

    }

    private fun performsignup() {
        val email = findViewById<EditText>(R.id.email)
        val password = findViewById<EditText>(R.id.password)
        val repassword  = findViewById<EditText>(R.id.repaswword)
        
        if(password.text.toString() != repassword.text.toString()){
            Toast.makeText(this, "Please type the correct password", Toast.LENGTH_SHORT).show()
        }
        
        if(email.text.isEmpty() || password.text.isEmpty()){
            Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show()
            return
        }

        val inputEmail = email.text.toString()
        val inputpassword =password.text.toString()

        auth.createUserWithEmailAndPassword(inputEmail, inputpassword)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, update UI with the signed-in user's information

                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)

                    Toast.makeText(baseContext, "Success",
                        Toast.LENGTH_SHORT).show()

                } else {
                    // If sign in fails, display a message to the user.
                    Toast.makeText(baseContext, "Authentication failed.",
                        Toast.LENGTH_SHORT).show()

                }
            }
            .addOnFailureListener {
                Toast.makeText(this, "Error Occured  ${it.localizedMessage}", Toast.LENGTH_SHORT).show()
            }
    }
}