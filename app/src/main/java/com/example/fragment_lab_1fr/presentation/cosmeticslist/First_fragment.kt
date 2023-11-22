package com.example.fragment_lab_1fr.presentation.cosmeticslist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.fragment_lab_1fr.domain.cosmetics.model.Cosmetics
import com.example.fragment_lab_1fr.Creamus
import com.example.fragment_lab_1fr.R
import com.example.fragment_lab_1fr.databinding.FragmentFirstFragmentBinding
import com.example.fragment_lab_1fr.presentation.cosmeticsdetais.Second_fragmentArgs


class First_fragment : Fragment() {

//    val args: Second_fragmentArgs by navArgs()
    lateinit var binding: FragmentFirstFragmentBinding
    lateinit var adapter: CosmeticsAdapter
    lateinit var viewModel: CosmeticsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        viewModel = ViewModelProvider(this).get(CosmeticsViewModel::class.java)
        binding = FragmentFirstFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root


    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //place for code


        val tv = view.findViewById<TextView>(R.id.tv)
        val rv = view.findViewById<RecyclerView>(R.id.rv)
        val swipe = view.findViewById<SwipeRefreshLayout>(R.id.swipe)
//        tv.text = args.mystr


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
//
                First_fragmentDirections.actionFirstFragmentToSecondFragment(cosmetics.name)
            )

            Toast.makeText(requireContext(), "Product`s details №$position", Toast.LENGTH_SHORT)
                .show()

        }




        adapter.setList(list)
        binding.rv.adapter = adapter


        binding.btnToSecondFragment.setOnClickListener {
//
            findNavController().navigate(
                First_fragmentDirections.actionFirstFragmentToSecondFragment("Some string")
            )

//            findNavController().popBackStack()
        }

        swipe.setOnRefreshListener {
            viewModel.getAllData()
        }


//            viewModel.cosmeticsListLd.observe(viewLifecycleOwner) {
//                adapter.setNewData(it)
//            }

            viewModel.weatherLd.observe(viewLifecycleOwner) {
                tv.text = it
            }
            viewModel.isLoading.observe(viewLifecycleOwner) {
                if (!it)
                    swipe.isRefreshing = false
            }
            rv.adapter = adapter





        }

    }









