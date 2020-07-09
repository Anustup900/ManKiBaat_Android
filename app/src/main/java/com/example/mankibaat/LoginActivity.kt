package com.example.mankibaat

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mankibaat.MyApplication.Staticated.task
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import io.realm.mongodb.Credentials

class LoginActivity : AppCompatActivity() {


    private lateinit var emailInputLayout: TextInputLayout
    private lateinit var passInputLayout: TextInputLayout

    private lateinit var emailInput: TextInputEditText
    private lateinit var passInput: TextInputEditText

    private lateinit var signUpButton: ImageButton
    private lateinit var forgotPass: ImageButton

    private lateinit var loginBtn: Button

    private lateinit var fbBtn: ImageButton
    private lateinit var googleBtn: ImageButton

    private lateinit var savePass: RadioButton
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        initialization()
        clickListener()
    }

    private fun clickListener() {
        signUpButton.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
        emailInput.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus)
                emailInput.setBackgroundResource(R.drawable.edit_text_clicked)
            else
                emailInput.setBackgroundResource(R.drawable.edittextbg)
        }

        passInput.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus)
                passInput.setBackgroundResource(R.drawable.edit_text_clicked)
            else
                passInput.setBackgroundResource(R.drawable.edittextbg)
        }

        loginBtn.setOnClickListener {
            val email = emailInput.text.toString().trim()
            val pass = passInput.text.toString().trim()
            if (pass == "") {
                passInputLayout.error
                Toast.makeText(this, "Please Enter Password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (email == "") {
                emailInputLayout.error
                Toast.makeText(this, "Please Enter Email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val cred = Credentials.emailPassword(email, pass)
            task.loginAsync(cred) {
                if (it.isSuccess) {
                    Toast.makeText(this, "User Logged IN", Toast.LENGTH_LONG).show()
                    val intent = Intent(this, Welcome_Activity::class.java)
                    startActivity(intent)
                } else
                    Toast.makeText(this, "Please try again later", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun initialization() {
        emailInputLayout = findViewById(R.id.emailInpLayout)
        passInputLayout = findViewById(R.id.passInpLayout)

        emailInput = findViewById(R.id.email)
        passInput = findViewById(R.id.password)

        fbBtn = findViewById(R.id.facebookButtonLogin)

        googleBtn = findViewById(R.id.googleButtonLogin)

        signUpButton = findViewById(R.id.signUpButton)
        signUpButton.background = null

        forgotPass = findViewById(R.id.forgotPassBtn)
        forgotPass.background = null

        loginBtn = findViewById(R.id.loginButton)

        savePass = findViewById(R.id.savePassBtn)
    }
}
