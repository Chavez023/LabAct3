package com.example.signup

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.infirmary.R

class BgHistory : AppCompatActivity() {

    private lateinit var fhRelAsthma: EditText
    private lateinit var fhRelCancer: EditText
    private lateinit var fhRelCardiovascularDisease: EditText
    private lateinit var fhRelDiabetesMellitus: EditText
    private lateinit var fhRelHypertension: EditText
    private lateinit var fhRelKidneyDisease: EditText
    private lateinit var fhRelAllergy: EditText
    private lateinit var fhRelOtherRemarks: EditText
    private lateinit var nextButton: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_bghistory)

        val checkBoxAsthma: CheckBox = findViewById(R.id.FamHist_Asthma)
        val checkBoxCancer: CheckBox = findViewById(R.id.FamHist_Cancer)
        val checkBoxCardiovascularDisease: CheckBox = findViewById(R.id.FamHist_CardiovascularDisease)
        val checkBoxDiabetesMellitus: CheckBox = findViewById(R.id.FamHist_DiabetesMellitus)
        val checkBoxHypertension: CheckBox = findViewById(R.id.FamHist_Hypertension)
        val checkBoxKidneyDisease: CheckBox = findViewById(R.id.FamHist_KidneyDisease)
        val checkBoxAllergy: CheckBox = findViewById(R.id.FamHist_Allergy)
        val checkBoxOtherRemarks: CheckBox = findViewById(R.id.FamHist_OtherRemarks)

        fhRelAsthma = findViewById(R.id.FamHist_rel_Asthma)
        fhRelCancer = findViewById(R.id.FamHist_rel_Cancer)
        fhRelCardiovascularDisease = findViewById(R.id.FamHist_rel_CardiovascularDisease)
        fhRelDiabetesMellitus = findViewById(R.id.FamHist_rel_DiabetesMellitus)
        fhRelHypertension = findViewById(R.id.FamHist_rel_Hypertension)
        fhRelKidneyDisease = findViewById(R.id.FamHist_rel_KidneyDisease)
        fhRelAllergy = findViewById(R.id.FamHist_rel_Allergy)
        fhRelOtherRemarks = findViewById(R.id.FamHist_rel_OtherRemarks)
        nextButton = findViewById(R.id.Nextpage)

        // Ensure that EditText fields are initially hidden
        hideEditText(fhRelAsthma)
        hideEditText(fhRelCancer)
        hideEditText(fhRelCardiovascularDisease)
        hideEditText(fhRelDiabetesMellitus)
        hideEditText(fhRelHypertension)
        hideEditText(fhRelKidneyDisease)
        hideEditText(fhRelAllergy)
        hideEditText(fhRelOtherRemarks)

        checkBoxAsthma.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                showEditText(fhRelAsthma)
            } else {
                hideEditText(fhRelAsthma)
            }
        }

        checkBoxCancer.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                showEditText(fhRelCancer)
            } else {
                hideEditText(fhRelCancer)
            }
        }

        checkBoxCardiovascularDisease.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                showEditText(fhRelCardiovascularDisease)
            } else {
                hideEditText(fhRelCardiovascularDisease)
            }
        }

        checkBoxDiabetesMellitus.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                showEditText(fhRelDiabetesMellitus)
            } else {
                hideEditText(fhRelDiabetesMellitus)
            }
        }

        checkBoxHypertension.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                showEditText(fhRelHypertension)
            } else {
                hideEditText(fhRelHypertension)
            }
        }

        checkBoxKidneyDisease.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                showEditText(fhRelKidneyDisease)
            } else {
                hideEditText(fhRelKidneyDisease)
            }
        }

        checkBoxAllergy.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                showEditText(fhRelAllergy)
            } else {
                hideEditText(fhRelAllergy)
            }
        }

        checkBoxOtherRemarks.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                showEditText(fhRelOtherRemarks)
            } else {
                hideEditText(fhRelOtherRemarks)
            }
        }

        val backButton: View = findViewById(R.id.Backpage)
        backButton.setOnClickListener {
            finish()
        }

        nextButton.setOnClickListener {
            val asthmaText = fhRelAsthma.text.toString()
            val cancerText = fhRelCancer.text.toString()
            val cardiovascularDiseaseText = fhRelCardiovascularDisease.text.toString()
            val diabetesMellitusText = fhRelDiabetesMellitus.text.toString()
            val hypertensionText = fhRelHypertension.text.toString()
            val kidneyDiseaseText = fhRelKidneyDisease.text.toString()
            val allergyText = fhRelAllergy.text.toString()
            val otherRemarksText = fhRelOtherRemarks.text.toString()

            val intent = Intent(this, Signup_Confirmation::class.java)
            intent.putExtra("ASTHMA_KEY", asthmaText)
            intent.putExtra("CANCER_KEY", cancerText)
            intent.putExtra("CARDIOVASCULAR_KEY", cardiovascularDiseaseText)
            intent.putExtra("DIABETES_KEY", diabetesMellitusText)
            intent.putExtra("HYPERTENSION_KEY", hypertensionText)
            intent.putExtra("KIDNEY_KEY", kidneyDiseaseText)
            intent.putExtra("ALLERGY_KEY", allergyText)
            intent.putExtra("REMARKS_KEY", otherRemarksText)

            startActivity(intent)
        }
    }

    private fun showEditText(editTextToShow: EditText) {
        editTextToShow.visibility = View.VISIBLE
        editTextToShow.requestFocus()
    }

    private fun hideEditText(editTextToHide: EditText) {
        editTextToHide.visibility = View.GONE
    }
}
