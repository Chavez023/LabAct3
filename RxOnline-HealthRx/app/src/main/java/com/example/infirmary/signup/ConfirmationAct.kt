package com.example.infirmary.signup

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.infirmary.R
import com.example.infirmary.SignIn
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class ConfirmationAct : AppCompatActivity() {

    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_act_confirmation)

        // Initialize Firebase Database reference
        databaseReference =
            FirebaseDatabase.getInstance("https://infirmary-plus-default-rtdb.asia-southeast1.firebasedatabase.app").reference.child(
                "users"
            )

        // Retrieve data from the intent
        val email = intent.getStringExtra("email")
        val phone = intent.getStringExtra("phone")
        val idNumber = intent.getStringExtra("idnumber")
        val password = intent.getStringExtra("password")

        val lastname = intent.getStringExtra("lastname")
        val firstname = intent.getStringExtra("firstname")
        val middlename = intent.getStringExtra("middlename")
        val birthdate = intent.getStringExtra("birthdate")
        val gender = intent.getStringExtra("gender")
        val role = intent.getStringExtra("role")

        val fhAsthma = intent.getStringExtra("FH_ASTHMA_KEY")
        val fhCancer = intent.getStringExtra("FH_CANCER_KEY")
        val fhCardiovascular = intent.getStringExtra("FH_CARDIOVASCULAR_KEY")
        val fhDiabetes = intent.getStringExtra("FH_DIABETES_KEY")
        val fhHypertension = intent.getStringExtra("FH_HYPERTENSION_KEY")
        val fhKidney = intent.getStringExtra("FH_KIDNEY_KEY")
        val fhAllergy = intent.getStringExtra("FH_ALLERGY_KEY")
        val fhRemarks = intent.getStringExtra("FH_REMARKS_KEY")

        val pmSpecAllergy = intent.getStringExtra("PM_SPEC_ALLERGY_KEY")
        val pmSpecSurgicalOperations = intent.getStringExtra("PM_SPEC_SURGICAL_OPERATIONS_KEY")
        val pmSpecYellowishDiscoloration =
            intent.getStringExtra("PM_SPEC_YELLOWISH_DISCOLORATION_KEY")
        val pmSpecLastHospitalization = intent.getStringExtra("PM_SPEC_LAST_HOSPITALIZATION_KEY")
        val pmSpecOther = intent.getStringExtra("PM_SPEC_OTHER_KEY")

        val checkBoxPmHypertension = intent.getBooleanExtra("CHECKBOX_PM_HYPERTENSION", false)
        val checkBoxPmAsthma = intent.getBooleanExtra("CHECKBOX_PM_Asthma", false)
        val checkBoxPmDiabetes = intent.getBooleanExtra("CHECKBOX_PM_DIABETES", false)
        val checkBoxPmTuberculosis = intent.getBooleanExtra("CHECKBOX_PM_TUBERCULOSIS", false)

        // Now you can use these values to update your UI or perform any other actions
        val resultTextView: TextView = findViewById(R.id.resultTextView)

        // Example: Displaying some of the retrieved data in a TextView
        val displayText = """
            Email: $email
            Phone: $phone
            ID Number: $idNumber
            Password: $password

            Last Name: $lastname
            First Name: $firstname
            Middle Name: $middlename
            Birthdate: $birthdate
            Gender: $gender
            Role: $role

            Family History:
            Asthma: $fhAsthma
            Cancer: $fhCancer
            Cardiovascular Disease: $fhCardiovascular
            Diabetes Mellitus: $fhDiabetes
            Hypertension: $fhHypertension
            Kidney Disease: $fhKidney
            Allergy: $fhAllergy
            Remarks: $fhRemarks

            Past Medical History:
            Specific Allergy: $pmSpecAllergy
            Surgical Operations: $pmSpecSurgicalOperations
            Yellowish Discoloration: $pmSpecYellowishDiscoloration
            Last Hospitalization: $pmSpecLastHospitalization
            Other Remarks: $pmSpecOther

            Checkbox States:
            Hypertension: $checkBoxPmHypertension
            Asthma: $checkBoxPmAsthma
            Diabetes: $checkBoxPmDiabetes
            Tuberculosis: $checkBoxPmTuberculosis
        """.trimIndent()

        resultTextView.text = displayText

        val submitButton: Button = findViewById(R.id.Submit)
        submitButton.setOnClickListener {
            // Call a function to send data to Firebase
            sendDataToFirebase(
                email,
                phone,
                idNumber,
                password,
                lastname,
                firstname,
                middlename,
                birthdate,
                gender,
                role,
                fhAsthma,
                fhCancer,
                fhCardiovascular,
                fhDiabetes,
                fhHypertension,
                fhKidney,
                fhAllergy,
                fhRemarks,
                pmSpecAllergy,
                pmSpecSurgicalOperations,
                pmSpecYellowishDiscoloration,
                pmSpecLastHospitalization,
                pmSpecOther,
                checkBoxPmHypertension,
                checkBoxPmAsthma,
                checkBoxPmDiabetes,
                checkBoxPmTuberculosis
            )
        }
    }

    private fun sendDataToFirebase(
        email: String?,
        phone: String?,
        idNumber: String?,
        password: String?,
        lastname: String?,
        firstname: String?,
        middlename: String?,
        birthdate: String?,
        gender: String?,
        role: String?,
        fhAsthma: String?,
        fhCancer: String?,
        fhCardiovascular: String?,
        fhDiabetes: String?,
        fhHypertension: String?,
        fhKidney: String?,
        fhAllergy: String?,
        fhRemarks: String?,
        pmSpecAllergy: String?,
        pmSpecSurgicalOperations: String?,
        pmSpecYellowishDiscoloration: String?,
        pmSpecLastHospitalization: String?,
        pmSpecOther: String?,
        checkBoxPmHypertension: Boolean,
        checkBoxPmAsthma: Boolean,
        checkBoxPmDiabetes: Boolean,
        checkBoxPmTuberculosis: Boolean
    ) {
        // Create a User object with the collected data
        val user = User(
            email,
            phone,
            idNumber,
            password,
            lastname,
            firstname,
            middlename,
            birthdate,
            gender,
            role,
            fhAsthma,
            fhCancer,
            fhCardiovascular,
            fhDiabetes,
            fhHypertension,
            fhKidney,
            fhAllergy,
            fhRemarks,
            pmSpecAllergy,
            pmSpecSurgicalOperations,
            pmSpecYellowishDiscoloration,
            pmSpecLastHospitalization,
            pmSpecOther,
            checkBoxPmHypertension,
            checkBoxPmAsthma,
            checkBoxPmDiabetes,
            checkBoxPmTuberculosis
        )

        // Push the user data to Firebase under the "users" node
        val userKey = databaseReference.push().key
        databaseReference.child(userKey ?: "").setValue(user) { databaseError, _ ->
            if (databaseError != null) {
                // Error occurred
                Log.e("Firebase", "Data could not be saved: $databaseError")
                showToast("Data could not be saved. Please try again.")
            } else {
                // Data saved successfully
                Log.d("Firebase", "Data saved successfully.")
                showToast("Data saved successfully.")

                // Navigate to SignIn activity
                val intent = Intent(this@ConfirmationAct, SignIn::class.java)
                startActivity(intent)
                finish() // Close the current activity
            }
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this@ConfirmationAct, message, Toast.LENGTH_SHORT).show()
    }
}
