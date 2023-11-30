package com.example.infirmary.sections.message

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.infirmary.DashboardFragment
import com.example.infirmary.R

class Frag_Messages : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.sec_frag_messages, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = DashboardFragment()
    }
}
