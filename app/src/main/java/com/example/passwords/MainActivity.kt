package com.example.passwords

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val window : Window = this@MainActivity.window
        window.statusBarColor = ContextCompat.getColor(this@MainActivity,R.color.backgroundMA)
        window.navigationBarColor = ContextCompat.getColor(this@MainActivity,R.color.backgroundMA)


        // Initialize Firebase Auth
        auth = Firebase.auth

        val et_name: EditText = findViewById(R.id.et_name)
        val et_name2: EditText = findViewById(R.id.et_name2)
        val button: TextView = findViewById(R.id.button)
        val register:TextView = findViewById(R.id.register)
        val textview4:TextView = findViewById(R.id.textView4)

        register.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)

        }
        button.setOnClickListener {
            performLogin()
        }


        textview4.setOnClickListener {
            forgotpasswordperform()
        }
    }


    private fun forgotpasswordperform(){
        val intent = Intent(this,forgotpassword::class.java)
        startActivity(intent)
    }

    private fun performLogin() {
        val email:EditText = findViewById(R.id.et_name2)
        val password:EditText = findViewById(R.id.et_name)


        if(email.text.isEmpty() || password.text.isEmpty()){
            Toast.makeText(this, "Please fill all the fields", Toast.LENGTH_SHORT).show()
        }

        val emailInput = email.text.toString()
        val passwordInput = password.text.toString()

        auth.signInWithEmailAndPassword(emailInput, passwordInput)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    // Sign in success, navigate to Main Activity
                    val intent = Intent(this, MainActivity2::class.java)
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
                Toast.makeText(baseContext, "Authentication failed.  ${it.localizedMessage}",
                    Toast.LENGTH_SHORT).show()
            }
    }
}