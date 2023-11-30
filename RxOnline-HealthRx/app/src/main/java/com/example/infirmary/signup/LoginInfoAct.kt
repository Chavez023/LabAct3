package com.example.infirmary.signup

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.infirmary.R

class LoginInfoAct : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var phoneEditText: EditText
    private lateinit var idNumberEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var confirmPasswordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_act_logininfo)

        emailEditText = findViewById(R.id.Email)
        phoneEditText = findViewById(R.id.Phone)
        idNumberEditText = findViewById(R.id.IDNo)
        passwordEditText = findViewById(R.id.Password)
        confirmPasswordEditText = findViewById(R.id.PassCon)

        val nextButton: LinearLayout = findViewById(R.id.Nextpage)
        val backButton: View = findViewById(R.id.Backpage)

        backButton.setOnClickListener {
            finish()
        }

        nextButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val phone = phoneEditText.text.toString()
            val idNumber = idNumberEditText.text.toString().trim()
            val password = passwordEditText.text.toString()
            val confirmPassword = confirmPasswordEditText.text.toString()


            if (phone.isBlank() && email.isBlank()) {
                phoneEditText.error = "Phone or Email is required"
                emailEditText.error = "Phone or Email is required"
                return@setOnClickListener
            }

            if (idNumber.isBlank() || password.isBlank() || confirmPassword.isBlank()) {
                if (idNumber.isBlank()) {
                    idNumberEditText.error = "ID Number is required"
                }
                if (password.isBlank()) {
                    passwordEditText.error = "Password is required"
                }
                if (confirmPassword.isBlank()) {
                    confirmPasswordEditText.error = "Confirm Password is required"
                }
                return@setOnClickListener
            }

            if (password == confirmPassword) {
                val intent = Intent(this, BasicInfoAct::class.java)
                intent.putExtra("email", email)
                intent.putExtra("phone", phone)
                intent.putExtra("idnumber", idNumber)
                intent.putExtra("password", password)

                startActivity(intent)
            } else {
                confirmPasswordEditText.error = "Passwords do not match"
            }
        }
    }
}