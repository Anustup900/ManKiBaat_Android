package com.example.mankibaat

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class SignUpActivity : AppCompatActivity() {

    private lateinit var genderGrp: RadioGroup
    private lateinit var male: RadioButton
    private lateinit var female: RadioButton

    private lateinit var nameInputLayout: TextInputLayout
    private lateinit var emailInputLayout: TextInputLayout

    private lateinit var nameInput: TextInputEditText
    private lateinit var emailInput: TextInputEditText

    private lateinit var loginButton: ImageButton
    private lateinit var forgotPass: ImageButton

    private lateinit var nextBtn: Button

    private lateinit var fbBtn: ImageButton
    private lateinit var googleBtn: ImageButton


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        initialization()
        clickListener()
    }

    private fun clickListener() {
        nextBtn.setOnClickListener {
            val intent = Intent(this, SignUpActivity2::class.java)

            val name = nameInput.text.toString().trim()
            if (name == "") {
                nameInputLayout.error
                Toast.makeText(this, "Please Enter Your Full Name", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val email = emailInput.text.toString().trim()
            if (email == "") {
                emailInputLayout.error
                Toast.makeText(this, "Please Enter Email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val gender = when {
                male.isChecked -> "Male"
                female.isChecked -> "Female"
                else -> {
                    Toast.makeText(this, "Please Select Gender", Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
            }
            intent.putExtra("details", arrayOf(name,email,gender))
            startActivity(intent)
        }
        nameInput.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus)
                nameInput.setBackgroundResource(R.drawable.edit_text_clicked)
            else
                nameInput.setBackgroundResource(R.drawable.edittextbg)
        }

        emailInput.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus)
                emailInput.setBackgroundResource(R.drawable.edit_text_clicked)
            else
                emailInput.setBackgroundResource(R.drawable.edittextbg)
        }
    }

    private fun initialization() {
        nameInputLayout = findViewById(R.id.fullNameInpLayout)
        emailInputLayout = findViewById(R.id.emailInpLayout)

        nameInput = findViewById(R.id.name)
        emailInput = findViewById(R.id.email)

        fbBtn = findViewById(R.id.facebookButtonLogin)

        googleBtn = findViewById(R.id.googleButtonLogin)

        nextBtn = findViewById(R.id.nextButton)

        forgotPass = findViewById(R.id.forgotPassBtn)
        forgotPass.background = null

        loginButton = findViewById(R.id.loginButton)
        loginButton.background = null

        genderGrp = findViewById(R.id.genderGroup)
        male = findViewById(R.id.male)
        female = findViewById(R.id.female)

    }
}
