package com.example.passwords

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.content.ContextCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class MainActivity2 : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    lateinit var toggle: ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        auth = FirebaseAuth.getInstance()

        val window : Window = this@MainActivity2.window
        window.statusBarColor = ContextCompat.getColor(this@MainActivity2,R.color.black)
        window.navigationBarColor = ContextCompat.getColor(this@MainActivity2,R.color.backgroundMA)



        val drawerLayout: DrawerLayout = findViewById(R.id.drawerlayout)
        val nav_view: NavigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        nav_view.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.home -> Toast.makeText(applicationContext, "Clicked Home", Toast.LENGTH_SHORT)
                    .show()
                R.id.ExitfromApp -> Toast.makeText(
                    applicationContext,
                    "Clicked Exit",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.loginoutpic ->
                    logout()
                R.id.RATEPIC -> Toast.makeText(
                    applicationContext,
                    "Clicked Rate us",
                    Toast.LENGTH_SHORT
                ).show()
                R.id.SHARE -> share()
            }
            true
        }
    }



    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
            return super.onOptionsItemSelected(item)
        }


    private fun logout() {
        auth.signOut()
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        Toast.makeText(this, "You are successfully logged out", Toast.LENGTH_SHORT).show()
    }


    private fun share(){

    }
}

