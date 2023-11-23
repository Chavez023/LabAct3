package com.example.signup

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.infirmary.R

class LoginInfo : AppCompatActivity() {

    private lateinit var emailEditText: EditText
    private lateinit var phoneEditText: EditText
    private lateinit var idNumberEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var confirmPasswordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_logininfo)

        emailEditText = findViewById(R.id.Email)
        phoneEditText = findViewById(R.id.Phone)
        idNumberEditText = findViewById(R.id.IDNo)
        passwordEditText = findViewById(R.id.Password)
        confirmPasswordEditText = findViewById(R.id.PassCon)

        val nextButton: LinearLayout = findViewById(R.id.Nextpage)
        val backButton: View = findViewById(R.id.Backpage)

        backButton.setOnClickListener {
            finish() // Finish the activity to go back
        }
        nextButton.setOnClickListener {
            val email = emailEditText.text.toString()
            val phone = phoneEditText.text.toString()
            val idNumber = idNumberEditText.text.toString()
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
                val intent = Intent(this, BasicInfo::class.java)
                intent.putExtra("emailLogininfo", email)
                intent.putExtra("phoneLogininfo", phone)
                intent.putExtra("idnumberLogininfo", idNumber)
                intent.putExtra("passLogininfo", password)
                startActivity(intent)
            } else {
                confirmPasswordEditText.error = "Passwords do not match"
            }
        }
    }
}
