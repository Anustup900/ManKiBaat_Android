package com.example.mankibaat

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.mankibaat.MyApplication.Staticated.task
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class SignUpActivity2 : AppCompatActivity() {

    private lateinit var phoneInputLayout: TextInputLayout
    private lateinit var passInputLayout: TextInputLayout

    private lateinit var phoneInput: TextInputEditText
    private lateinit var passInput: TextInputEditText

    private lateinit var loginButton: ImageButton
    private lateinit var forgotPass: ImageButton

    private lateinit var signUpBtn: Button

    private lateinit var fbBtn: ImageButton
    private lateinit var googleBtn: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up2)
        initialization()
        clickListener()
    }

    private fun clickListener() {
        signUpBtn.setOnClickListener {

            val phone = phoneInput.text.toString().trim()
            if (phone == "") {
                phoneInputLayout.error
                Toast.makeText(this, "Please Enter phone number", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val pass = passInput.text.toString().trim()
            if (pass == "") {
                passInputLayout.error
                Toast.makeText(this, "Please Enter Password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val details = intent.getStringArrayExtra("details")
            val name = details[0].toString().trim()
            val email = details[1].toString().trim()
            val gender = details[2].toString().trim()

            saveData(name, gender, email, phone, pass)

        }
        phoneInput.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus)
                phoneInput.setBackgroundResource(R.drawable.edit_text_clicked)
            else
                phoneInput.setBackgroundResource(R.drawable.edittextbg)
        }

        passInput.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus)
                passInput.setBackgroundResource(R.drawable.edit_text_clicked)
            else
                passInput.setBackgroundResource(R.drawable.edittextbg)
        }
    }

    private fun saveData(name: String, email: String, phone: String, pass: String, gender: String) {
        task.emailPasswordAuth.registerUserAsync(email, pass) {
            if (it.isSuccess) {
                //upload user data on mongodb
                Toast.makeText(this, "Successfully Signed Up", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, Welcome_Activity::class.java)
                startActivity(intent)
            } else
                Toast.makeText(this, "Please try again later", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initialization() {
        phoneInputLayout = findViewById(R.id.phoneInpLayout)
        passInputLayout = findViewById(R.id.passInpLayout)

        phoneInput = findViewById(R.id.phone)
        passInput = findViewById(R.id.password)

        fbBtn = findViewById(R.id.facebookButtonLogin)

        googleBtn = findViewById(R.id.googleButtonLogin)

        signUpBtn = findViewById(R.id.signUpButton)

        forgotPass = findViewById(R.id.forgotPassBtn)
        forgotPass.background = null

        loginButton = findViewById(R.id.loginButton)
        loginButton.background = null

    }
}

