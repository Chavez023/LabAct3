package com.example.signup


import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.LinearLayout
import android.widget.RadioButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.infirmary.R
import com.example.infirmary.databinding.SignupAgreementBinding

class Agreement : AppCompatActivity() {

    private lateinit var binding: SignupAgreementBinding
    private lateinit var confirmedAgreementRadioButton: RadioButton
    private lateinit var nextButton: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = SignupAgreementBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val recyclerView: RecyclerView = binding.agreementlist
        recyclerView.layoutManager = LinearLayoutManager(this)

        val data = listOf(
            CustomAdapterData("Purpose", "This app system is designed to provide students and staff with easy access to the school clinic services, such as booking appointments, viewing health records, requesting prescriptions, and receiving notifications."),
            CustomAdapterData("Comply", "By using this app system, you agree to comply with the school policies and regulations, as well as the applicable laws and ethical standards regarding health care and privacy."),
            CustomAdapterData("Responsibility", "You are responsible for keeping your login credentials secure and confidential. You must not share your account with other people or use someone else’s account without their permission."),
            CustomAdapterData("Information Accuracy", "You must provide accurate and complete information when using this app system. You must not submit any false, misleading, or fraudulent information or documents. You must update your information promptly if there are any changes."),
            CustomAdapterData("Rights and Dignity", "You must respect the rights and dignity of the school staff, students, and other users of this app system. You must not harass, abuse, threaten, or discriminate against anyone on the basis of their race, gender, age, disability, religion, sexual orientation, or any other protected characteristic."),
            CustomAdapterData("Intention", "You must not misuse this app system for any harmful or illegal purposes. Your intention should align with the legitimate use of the system."),
            CustomAdapterData("Reserves", "The school clinic reserves the right to monitor, review, modify, or delete any content or data that you submit or access through this app at any time. The school clinic also reserves the right to suspend or terminate your access to this app at any time and for any reason, without prior notice or liability."),
            CustomAdapterData("Endorsement", "The school clinic does not endorse, or assume responsibility for any content or data submitted or accessed through this app by users."),
            CustomAdapterData("Terms and Condition", "By using this app, you agree to comply with all applicable laws and regulations. You also agree not to use the app for any illegal or unauthorized purpose.")
        )

        val adapter = CustomAdapter(this, data)
        recyclerView.adapter = adapter

        val backButton: View = findViewById(R.id.Backpage)
        backButton.setOnClickListener {
            finish()
        }

        confirmedAgreementRadioButton = binding.confirmedAgreement
        nextButton = binding.Nextpage

        nextButton.setOnClickListener {
            if (confirmedAgreementRadioButton.isChecked) {
                val intent = Intent(this, LoginInfo::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Agree to the Terms and Conditions is required", Toast.LENGTH_SHORT).show()
            }
        }
    }
}