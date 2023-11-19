package com.example.infirmary

import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class UpdateStep3 : AppCompatActivity() {

    private lateinit var hospitalNameTextView: TextView
    private lateinit var refNumberTextView: TextView
    private lateinit var resultCompleteBloodCountTextView: TextView
    private lateinit var resultUrinalysisTextView: TextView
    private lateinit var resultChestPATextView: TextView
    private lateinit var resultFastingBloodSugarTextView: TextView
    private lateinit var resultBloodUricAcidTextView: TextView
    private lateinit var resultLipidProfileTextView: TextView
    private lateinit var resultCreatinineTextView: TextView
    private lateinit var resultSGPTTextView: TextView
    private lateinit var resultSGOTTextView: TextView
    private lateinit var resultOtherTextView: TextView
    private lateinit var uploadedImageView: ImageView
    private lateinit var submitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_step3)

        hospitalNameTextView = findViewById(R.id.HospitalName)
        refNumberTextView = findViewById(R.id.RefNumber)
        resultCompleteBloodCountTextView = findViewById(R.id.result_CompleteBloodCount)
        resultUrinalysisTextView = findViewById(R.id.result_Urinalysis)
        resultChestPATextView = findViewById(R.id.result_ChestPA)
        resultFastingBloodSugarTextView = findViewById(R.id.result_FastingBloodSugar)
        resultBloodUricAcidTextView = findViewById(R.id.result_BloodUricAcid)
        resultLipidProfileTextView = findViewById(R.id.result_LipidProfile)
        resultCreatinineTextView = findViewById(R.id.result_Creatinine)
        resultSGPTTextView = findViewById(R.id.result_SGPT)
        resultSGOTTextView = findViewById(R.id.result_SGOT)
        resultOtherTextView = findViewById(R.id.result_Other)
        uploadedImageView = findViewById(R.id.uploadedImageView)
        submitButton = findViewById(R.id.Submit)

        // Retrieve data from the intent
        val hospitalName = intent.getStringExtra("hospitalName")
        val refNumber = intent.getStringExtra("refNumber")
        val completeBloodCountResult = intent.getStringExtra("completeBloodCountResult")
        val urinalysisResult = intent.getStringExtra("urinalysisResult")
        val chestPAResult = intent.getStringExtra("chestPAResult")
        val fastingBloodSugarResult = intent.getStringExtra("fastingBloodSugarResult")
        val bloodUricAcidResult = intent.getStringExtra("bloodUricAcidResult")
        val lipidProfileResult = intent.getStringExtra("lipidProfileResult")
        val creatinineResult = intent.getStringExtra("creatinineResult")
        val sgptResult = intent.getStringExtra("agptResult")
        val sgotResult = intent.getStringExtra("sgotResult")
        val otherResult = intent.getStringExtra("otherResult")
        val selectedImageUriString = intent.getStringExtra("selectedImageUri")

        // Set data to TextViews
        hospitalNameTextView.text = hospitalName
        refNumberTextView.text = refNumber
        resultCompleteBloodCountTextView.text = completeBloodCountResult
        resultUrinalysisTextView.text = urinalysisResult
        resultChestPATextView.text = chestPAResult
        resultFastingBloodSugarTextView.text = fastingBloodSugarResult
        resultBloodUricAcidTextView.text = bloodUricAcidResult
        resultLipidProfileTextView.text = lipidProfileResult
        resultCreatinineTextView.text = creatinineResult
        resultSGPTTextView.text = sgptResult
        resultSGOTTextView.text = sgotResult
        resultOtherTextView.text = otherResult

        if (!selectedImageUriString.isNullOrEmpty()) {
            val selectedImageUri: Uri = Uri.parse(selectedImageUriString)
            uploadedImageView.setImageURI(selectedImageUri)
        }

        submitButton.setOnClickListener {
            // TODO: Implement Firebase upload logic here
            // For simplicity, let's display a toast message indicating successful submission
            showToast("Data submitted to Firebase")
        }

        val backButton: View = findViewById(R.id.Backpage)
        backButton.setOnClickListener {
            finish() // Finish the activity to go back
        }
    }

    private fun showToast(message: String) {
        // TODO: Implement your showToast function or use Toast.makeText() here
    }
}
