package com.example.infirmary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.infirmary.databinding.ActivitySignUpBinding
import com.example.infirmary.sections.MainSec
import com.example.infirmary.signup.AgreeAct
import com.google.firebase.auth.FirebaseAuth

class SignUp : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        binding.SignUpButton.setOnClickListener {
            val email = binding.Email.text.toString()
            val pass = binding.Password.text.toString()
            val con = binding.PassCon.text.toString()

            if (email.isNotEmpty() && pass.isNotEmpty() && con.isNotEmpty()){
                if (pass == con) {

                    firebaseAuth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener {
                        if (it.isSuccessful) {
                            val intent = Intent(this, MainSec::class.java)
                            startActivity(intent)
                        } else {
                            Toast.makeText(this, it.exception.toString(), Toast.LENGTH_SHORT).show()
                        }
                    }
                } else {
                    Toast.makeText(this, "Password Cannot be Empty", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Fields Cannot be Empty", Toast.LENGTH_SHORT).show()
            }
        }
        binding.SignInButton.setOnClickListener {
            val intent = Intent (this, AgreeAct::class.java)
            startActivity(intent)
        }

    }
}