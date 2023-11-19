package com.example.infirmary

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.LinearLayout

class UpdateStep1 : AppCompatActivity() {

    private lateinit var resultCompleteBloodCount: EditText
    private lateinit var resultUrinalysis: EditText
    private lateinit var resultChestPA: EditText
    private lateinit var resultFasstingBloodSugar: EditText
    private lateinit var resultBloodUricAcid: EditText
    private lateinit var resultLipidProfile: EditText
    private lateinit var resultCreatinine: EditText
    private lateinit var resultSGPT: EditText
    private lateinit var resultSGOT: EditText
    private lateinit var resultOther: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_update_step1)

        resultCompleteBloodCount = findViewById(R.id.result_CompleteBloodCount)
        resultUrinalysis = findViewById(R.id.result_Urinalysis)
        resultChestPA = findViewById(R.id.result_ChestPA)
        resultFasstingBloodSugar = findViewById(R.id.result_FastingBloodSugar)
        resultBloodUricAcid = findViewById(R.id.result_BloodUricAcid)
        resultLipidProfile = findViewById(R.id.result_LipidProfile)
        resultCreatinine = findViewById(R.id.result_Creatinine)
        resultSGPT = findViewById(R.id.result_SGPT)
        resultSGOT = findViewById(R.id.result_SGOT)
        resultOther = findViewById(R.id.result_Other)

        val nextPageButton: LinearLayout = findViewById(R.id.Nextpage)
        nextPageButton.setOnClickListener {
            navigateToUpdateStep2()
        }
    }

    private fun navigateToUpdateStep2() {
        val completeBloodCountResult = resultCompleteBloodCount.text.toString()
        val urinalysisResult = resultUrinalysis.text.toString()
        val chestPAResult = resultChestPA.text.toString()
        val fastingBloodSugarResult = resultFasstingBloodSugar.text.toString()
        val bloodUricAcidResult = resultBloodUricAcid.text.toString()
        val lipidProfileResult = resultLipidProfile.text.toString()
        val creatinineResult = resultCreatinine.text.toString()
        val sgptResult = resultSGPT.text.toString()
        val sgotResult = resultSGOT.text.toString()
        val otherResult = resultOther.text.toString()

        val intent = Intent(this, UpdateStep2::class.java)
        intent.putExtra("completeBloodCountResult", completeBloodCountResult)
        intent.putExtra("urinalysisResult", urinalysisResult)
        intent.putExtra("chestPAResult", chestPAResult)
        intent.putExtra("fastingBloodSugarResult", fastingBloodSugarResult)
        intent.putExtra("bloodUricAcidResult", bloodUricAcidResult)
        intent.putExtra("lipidProfileResult", lipidProfileResult)
        intent.putExtra("creatinineResult", creatinineResult)
        intent.putExtra("sgptResult", sgptResult)
        intent.putExtra("sgotResult", sgotResult)
        intent.putExtra("otherResult", otherResult)

        startActivity(intent)
    }
}