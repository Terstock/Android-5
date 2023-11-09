package com.example.fragment_lab_1fr

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs


class Second_fragment : Fragment() {


    val args:Second_fragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val tv = view.findViewById<TextView>(R.id.tv)
//        val str = args.namus
//        tv.text = str

        val tv = view.findViewById<TextView>(R.id.tv)
        tv.text = "Our brand is unique in that we use only plant ingredients in our products, completely excluding any chemicals or dietary supplements. We want our customers to use only high-quality products and never experience physical or aesthetic dissatisfaction with the purchased product."


    }


}