package com.example.infirmary

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.infirmary.sections.MainSec
import com.example.infirmary.signup.AgreeAct
import com.google.firebase.database.*

class SignIn : AppCompatActivity() {

    private lateinit var emPhoIdEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        initializeViews()

        val loginButton: Button = findViewById(R.id.LoginButton)
        val signUpButton: Button = findViewById(R.id.SignUpButton)

        loginButton.setOnClickListener {
            val emPhoId = emPhoIdEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            if (validateInput(emPhoId, password)) {
                loginUser(emPhoId, password)
            }
        }

        signUpButton.setOnClickListener {
            startActivity(Intent(this@SignIn, AgreeAct::class.java))
        }
    }

    private fun initializeViews() {
        emPhoIdEditText = findViewById(R.id.EmPhoID)
        passwordEditText = findViewById(R.id.Password)
        databaseReference =
            FirebaseDatabase.getInstance("https://infirmary-plus-default-rtdb.asia-southeast1.firebasedatabase.app")
                .getReference("users")
    }

    private fun validateInput(emPhoId: String, password: String): Boolean {
        if (emPhoId.isEmpty()) {
            emPhoIdEditText.error = "Enter Email / Phone / ID number"
            return false
        }

        if (password.isEmpty()) {
            passwordEditText.error = "Enter Password"
            return false
        }

        return true
    }

    private fun loginUser(emPhoId: String, password: String) {
        databaseReference.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                var userFound = false

                for (userSnapshot in dataSnapshot.children) {
                    val storedEmail = userSnapshot.child("email").getValue(String::class.java)
                    val storedPhone = userSnapshot.child("phone").getValue(String::class.java)
                    val storedIdNumber = userSnapshot.child("idNumber").getValue(String::class.java)
                    val storedPassword = userSnapshot.child("password").getValue(String::class.java)

                    if ((storedEmail == emPhoId || storedPhone == emPhoId || storedIdNumber == emPhoId) && storedPassword == password) {
                        // Password matches, login successful
                        userFound = true
                        break
                    }
                }

                if (userFound) {
                    // Start the next activity after successful login
                    startActivity(Intent(this@SignIn, MainSec::class.java))
                    finish() // Optional: Close the login activity
                } else {
                    // User not found or incorrect password
                    emPhoIdEditText.error = "Invalid credentials"
                    passwordEditText.error = "Invalid credentials"
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {
                // Handle error
                emPhoIdEditText.error = "Database error: ${databaseError.message}"
                passwordEditText.error = "Database error: ${databaseError.message}"
            }
        })
    }
}
