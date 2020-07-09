package com.example.mankibaat

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.log

class MainActivity : AppCompatActivity() {
    private lateinit var docImage: ImageView
    private lateinit var loginButton: Button
    private lateinit var newUser: ImageButton
    private lateinit var facebook: ImageButton
    private lateinit var google: ImageButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initialization()
        clickListener()
    }

    private fun initialization() {
        docImage = findViewById(R.id.docImg)
        loginButton = findViewById(R.id.loginButton)
        newUser = findViewById(R.id.newUser)
        facebook = findViewById(R.id.facebookButtonLogin)
        google = findViewById(R.id.googleButtonLogin)
    }

    private fun clickListener(){
        //login button click listener
        loginButton.setOnClickListener {
                val intent = Intent(this,LoginActivity::class.java)
                startActivity(intent)
        }

        //new user click listener
        newUser.setOnClickListener {
            val intent = Intent(this,SignUpActivity::class.java)
            startActivity(intent)
        }
        //login with facebook listener
        facebook.setOnClickListener {

        }

        //login with google listener
        google.setOnClickListener {
            
        }
    }
}
