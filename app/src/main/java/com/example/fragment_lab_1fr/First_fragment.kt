package com.example.fragment_lab_1fr

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.fragment_lab_1fr.databinding.FragmentFirstFragmentBinding


class First_fragment : Fragment() {

    lateinit var binding: FragmentFirstFragmentBinding
    lateinit var adapter: CosmeticsAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFirstFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //place for code

        val list = ArrayList<Cosmetics>()
        list.add(Creamus("Beauty and youth", 2000))
        list.add(Creamus("Flower glade Montana", 1999))
        list.add(Creamus("Atlantic breeze", 2021))
        list.add(Creamus("Ice Breath", 2007))
        list.add(Creamus("Essential nectar", 1996))
        list.add(Creamus("The best possible", 2019))
        list.add(Creamus("Evening pleasure", 1967))

        adapter = CosmeticsAdapter() { cosmetics, position ->
            findNavController().navigate(
                First_fragmentDirections.actionFirstFragmentToSecondFragment(
                    cosmetics.name

                )
            )

            Toast.makeText(requireContext(), "Product`s details №$position", Toast.LENGTH_SHORT)
                .show()

        }


        adapter.setList(list)
        binding.rv.adapter = adapter


        binding.btnToSecondFragment.setOnClickListener {
            findNavController().navigate(
                First_fragmentDirections.actionFirstFragmentToSecondFragment(
                    "Some string"
                )
            )

//            findNavController().popBackStack()
        }
    }
}


