package com.example.infirmary

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class DashboardFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_dashboard, container, false)

        // Find the button by its ID
        val buttonNavigate = view.findViewById<Button>(R.id.button)

        // Set a click listener for the button
        buttonNavigate.setOnClickListener {
            // Handle button click, navigate to UpdateStep1 activity
            val intent = Intent(activity, UpdateStep1::class.java)
            startActivity(intent)
        }

        return view
    }

    companion object {
        @JvmStatic
        fun newInstance() = DashboardFragment()
    }
}
