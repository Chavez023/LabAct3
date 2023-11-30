package com.example.infirmary.signup

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.infirmary.R

class BgHistAct : AppCompatActivity() {

    private lateinit var fhRelAsthma: EditText
    private lateinit var fhRelCancer: EditText
    private lateinit var fhRelCardiovascularDisease: EditText
    private lateinit var fhRelDiabetesMellitus: EditText
    private lateinit var fhRelHypertension: EditText
    private lateinit var fhRelKidneyDisease: EditText
    private lateinit var fhRelAllergy: EditText
    private lateinit var fhRelOtherRemarks: EditText

    private lateinit var pmSpecAllergy: EditText
    private lateinit var pmSpecSurgicalOperations: EditText
    private lateinit var pmSpecYellowishdiscolorationofskinsclera: EditText
    private lateinit var pmSpecLasthospitalization: EditText
    private lateinit var pmSpecOther: EditText

    private lateinit var nextButton: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_act_bghistory)

        val checkBoxfmAsthma: CheckBox = findViewById(R.id.FamHist_Asthma)
        val checkBoxfmCancer: CheckBox = findViewById(R.id.FamHist_Cancer)
        val checkBoxfmCardiovascularDisease: CheckBox = findViewById(R.id.FamHist_CardiovascularDisease)
        val checkBoxfmDiabetesMellitus: CheckBox = findViewById(R.id.FamHist_DiabetesMellitus)
        val checkBoxfmHypertension: CheckBox = findViewById(R.id.FamHist_Hypertension)
        val checkBoxfmKidneyDisease: CheckBox = findViewById(R.id.FamHist_KidneyDisease)
        val checkBoxfmAllergy: CheckBox = findViewById(R.id.FamHist_Allergy)
        val checkBoxfmOtherRemarks: CheckBox = findViewById(R.id.FamHist_OtherRemarks)

        val checkBoxpmHypertension: CheckBox = findViewById(R.id.PastMed_Hypertension)
        val checkBoxpmAsthma: CheckBox = findViewById(R.id.PastMed_Asthma)
        val checkBoxpmDiabetesMellitus: CheckBox = findViewById(R.id.PastMed_DiabetesMellitus)
        val checkBoxpmTuberculosis: CheckBox = findViewById(R.id.PastMed_Tuberulosis)
        val checkBoxpmAllergy: CheckBox = findViewById(R.id.PastMed_Allergy)
        val checkBoxpmSurgicalOperations: CheckBox = findViewById(R.id.PastMed_SurgicalOperations)
        val checkBoxpmYellowishdiscolorationofskinsclera: CheckBox =
            findViewById(R.id.PastMed_Yellowishdiscolorationofskinsclera)
        val checkBoxpmLasthospitalization: CheckBox = findViewById(R.id.PastMed_Lasthospitalization)
        val checkBoxpmOther: CheckBox = findViewById(R.id.PastMed_Other)

        fhRelAsthma = findViewById(R.id.FamHist_rel_Asthma)
        fhRelCancer = findViewById(R.id.FamHist_rel_Cancer)
        fhRelCardiovascularDisease = findViewById(R.id.FamHist_rel_CardiovascularDisease)
        fhRelDiabetesMellitus = findViewById(R.id.FamHist_rel_DiabetesMellitus)
        fhRelHypertension = findViewById(R.id.FamHist_rel_Hypertension)
        fhRelKidneyDisease = findViewById(R.id.FamHist_rel_KidneyDisease)
        fhRelAllergy = findViewById(R.id.FamHist_rel_Allergy)
        fhRelOtherRemarks = findViewById(R.id.FamHist_rel_OtherRemarks)
        pmSpecAllergy = findViewById(R.id.PastMed_Spec_Allergy)
        pmSpecSurgicalOperations = findViewById(R.id.PastMed_Spec_SurgicalOperations)
        pmSpecYellowishdiscolorationofskinsclera =
            findViewById(R.id.PastMed_Spec_Yellowishdiscolorationofskinsclera)
        pmSpecLasthospitalization = findViewById(R.id.PastMed_Spec_Lasthospitalization)
        pmSpecOther = findViewById(R.id.PastMed_Spec_Other)

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
        hideEditText(pmSpecAllergy)
        hideEditText(pmSpecSurgicalOperations)
        hideEditText(pmSpecYellowishdiscolorationofskinsclera)
        hideEditText(pmSpecLasthospitalization)
        hideEditText(pmSpecOther)

        // Process checkboxes with associated fields
        processCheckboxWithField(intent, checkBoxfmAsthma, "CHECKBOX_FM_ASTHMA", fhRelAsthma)
        processCheckboxWithField(intent, checkBoxfmCancer, "CHECKBOX_FM_CANCER", fhRelCancer)
        processCheckboxWithField(
            intent,
            checkBoxfmCardiovascularDisease,
            "CHECKBOX_FM_CARDIOVASCULAR",
            fhRelCardiovascularDisease
        )
        processCheckboxWithField(
            intent,
            checkBoxfmDiabetesMellitus,
            "CHECKBOX_FM_DIABETES",
            fhRelDiabetesMellitus
        )
        processCheckboxWithField(
            intent,
            checkBoxfmHypertension,
            "CHECKBOX_FM_HYPERTENSION",
            fhRelHypertension
        )
        processCheckboxWithField(intent, checkBoxfmKidneyDisease, "CHECKBOX_FM_KIDNEY", fhRelKidneyDisease)
        processCheckboxWithField(intent, checkBoxfmAllergy, "CHECKBOX_FM_ALLERGY", fhRelAllergy)
        processCheckboxWithField(intent, checkBoxfmOtherRemarks, "CHECKBOX_FM_OTHER", fhRelOtherRemarks)

        processCheckboxWithField(intent, checkBoxpmAllergy, "CHECKBOX_PM_ALLERGY", pmSpecAllergy)
        processCheckboxWithField(
            intent,
            checkBoxpmSurgicalOperations,
            "CHECKBOX_PM_SURGICAL_OPERATIONS",
            pmSpecSurgicalOperations
        )
        processCheckboxWithField(
            intent,
            checkBoxpmYellowishdiscolorationofskinsclera,
            "CHECKBOX_PM_YELLOWISH_DISCOLORATION",
            pmSpecYellowishdiscolorationofskinsclera
        )
        processCheckboxWithField(
            intent,
            checkBoxpmLasthospitalization,
            "CHECKBOX_PM_LAST_HOSPITALIZATION",
            pmSpecLasthospitalization
        )
        processCheckboxWithField(intent, checkBoxpmOther, "CHECKBOX_PM_OTHER", pmSpecOther)

        // Set up Back button listener
        val backButton: LinearLayout = findViewById(R.id.Backpage)
        backButton.setOnClickListener {
            finish()
        }

        nextButton.setOnClickListener {
            // Retrieve text from EditText fields
            val asthmaText = fhRelAsthma.text.toString()
            val cancerText = fhRelCancer.text.toString()
            val cardiovascularDiseaseText = fhRelCardiovascularDisease.text.toString()
            val diabetesMellitusText = fhRelDiabetesMellitus.text.toString()
            val hypertensionText = fhRelHypertension.text.toString()
            val kidneyDiseaseText = fhRelKidneyDisease.text.toString()
            val allergyText = fhRelAllergy.text.toString()
            val otherRemarksText = fhRelOtherRemarks.text.toString()
            val pmspecAllergyText = pmSpecAllergy.text.toString()
            val pmspecSurgicalOperationsText = pmSpecSurgicalOperations.text.toString()
            val pmspecYellowishdiscolorationofskinscleraText =
                pmSpecYellowishdiscolorationofskinsclera.text.toString()
            val pmspecLasthospitalizationText = pmSpecLasthospitalization.text.toString()
            val pmspecOtherText = pmSpecOther.text.toString()

            // Retrieve data from the previous intent
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

            // Create an intent for the next activity (AgreeAct)
            val nextIntent = Intent(this, ConfirmationAct::class.java)
            nextIntent.putExtra("FH_ASTHMA_KEY", asthmaText)
            nextIntent.putExtra("FH_CANCER_KEY", cancerText)
            nextIntent.putExtra("FH_CARDIOVASCULAR_KEY", cardiovascularDiseaseText)
            nextIntent.putExtra("FH_DIABETES_KEY", diabetesMellitusText)
            nextIntent.putExtra("FH_HYPERTENSION_KEY", hypertensionText)
            nextIntent.putExtra("FH_KIDNEY_KEY", kidneyDiseaseText)
            nextIntent.putExtra("FH_ALLERGY_KEY", allergyText)
            nextIntent.putExtra("FH_REMARKS_KEY", otherRemarksText)

            nextIntent.putExtra("PM_SPEC_ALLERGY_KEY", pmspecAllergyText)
            nextIntent.putExtra("PM_SPEC_SURGICAL_OPERATIONS_KEY", pmspecSurgicalOperationsText)
            nextIntent.putExtra("PM_SPEC_YELLOWISH_DISCOLORATION_KEY", pmspecYellowishdiscolorationofskinscleraText)
            nextIntent.putExtra("PM_SPEC_LAST_HOSPITALIZATION_KEY", pmspecLasthospitalizationText)
            nextIntent.putExtra("PM_SPEC_OTHER_KEY", pmspecOtherText)

            nextIntent.putExtra("email", email)
            nextIntent.putExtra("phone", phone)
            nextIntent.putExtra("idnumber", idNumber)
            nextIntent.putExtra("password", password)

            nextIntent.putExtra("lastname", lastname)
            nextIntent.putExtra("firstname", firstname)
            nextIntent.putExtra("middlename", middlename)
            nextIntent.putExtra("birthdate", birthdate)
            nextIntent.putExtra("gender", gender)
            nextIntent.putExtra("role", role)

            nextIntent.putExtra("CHECKBOX_PM_HYPERTENSION", checkBoxpmHypertension.isChecked)
            nextIntent.putExtra("CHECKBOX_PM_Asthma", checkBoxpmAsthma.isChecked)
            nextIntent.putExtra("CHECKBOX_PM_DIABETES", checkBoxpmDiabetesMellitus.isChecked)
            nextIntent.putExtra("CHECKBOX_PM_TUBERCULOSIS", checkBoxpmTuberculosis.isChecked)

            startActivity(nextIntent)
        }
    }

    private fun processCheckboxWithField(
        intent: Intent,
        checkBox: CheckBox,
        dataKey: String,
        editText: EditText?
    ) {
        checkBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                editText?.visibility = View.VISIBLE
            } else {
                editText?.visibility = View.GONE
            }
        }

        // Retrieve data from the previous intent and set the checkbox state
        val checkboxState = intent.getBooleanExtra(dataKey, false)
        checkBox.isChecked = checkboxState

        // Show/hide associated EditText based on checkbox state
        if (checkboxState) {
            editText?.visibility = View.VISIBLE
        } else {
            editText?.visibility = View.GONE
        }
    }

    private fun showEditText(editTextToShow: EditText) {
        editTextToShow.visibility = View.VISIBLE
        editTextToShow.requestFocus()
    }

    private fun hideEditText(editTextToHide: EditText) {
        editTextToHide.visibility = View.GONE
    }

    private fun processCheckboxWithoutField(intent: Intent, checkBox: CheckBox, dataKey: String) {
        checkBox.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // If checkbox is checked, add the label text to the data
                intent.putExtra(dataKey, checkBox.text.toString())
            } else {
                // If checkbox is unchecked, remove the data for this checkbox
                intent.removeExtra(dataKey)
            }
        }

        // Retrieve data from the previous intent and set the checkbox state
        val checkboxState = intent.getBooleanExtra(dataKey, false)
        checkBox.isChecked = checkboxState
    }
}
