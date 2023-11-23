package com.example.infirmary.features.update

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import com.example.infirmary.R

class UpdateStep2 : AppCompatActivity() {

    private lateinit var hospitalNameEditText: EditText
    private lateinit var refNumberEditText: EditText
    private lateinit var uploadedImageView: ImageView
    private lateinit var selectImageButton: Button

    private val PICK_IMAGE_REQUEST = 1
    private var selectedImageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.feature_update_step2)

        hospitalNameEditText = findViewById(R.id.HospitalName)
        refNumberEditText = findViewById(R.id.RefNumber)
        uploadedImageView = findViewById(R.id.uploadedImageView)
        selectImageButton = findViewById(R.id.selectImageButton)

        selectImageButton.setOnClickListener {
            openGallery()
        }

        val nextPageButton: LinearLayout = findViewById(R.id.Nextpage)
        nextPageButton.setOnClickListener {
            navigateToUpdateStep3()
        }

        val backButton: LinearLayout = findViewById(R.id.Backpage)
        backButton.setOnClickListener {
            finish()
        }
    }

    private fun openGallery() {
        val galleryIntent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(galleryIntent, PICK_IMAGE_REQUEST)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null) {
            selectedImageUri = data.data
            uploadedImageView.setImageURI(selectedImageUri)
        }
    }

    private fun navigateToUpdateStep3() {
        val hospitalName = hospitalNameEditText.text.toString()
        val refNumber = refNumberEditText.text.toString()
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

        val intent = Intent(this, UpdateStep3::class.java)
            intent.putExtra("hospitalName", hospitalName)
            intent.putExtra("refNumber", refNumber)
            intent.putExtra("selectedImageUri", selectedImageUri.toString())

            // Retrieve data from this activity's intent
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
