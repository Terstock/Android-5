package com.example.fragment_lab_1fr

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.fragment_lab_1fr.databinding.FragmentFirstFragmentBinding
import com.example.fragment_lab_1fr.databinding.ItemCosmeticsBinding

class CosmeticsAdapter(
    val onClick:(cosmetics: Cosmetics,position:Int) -> Unit
): RecyclerView.Adapter<CosmeticsAdapter.CosmeticsViewHolder>() {

     private val list = ArrayList<Cosmetics>()

    fun setList(newList: List<Cosmetics>){
    list.clear()
    list.addAll(newList)
    notifyDataSetChanged()
    }

    inner class CosmeticsViewHolder(val binding: ItemCosmeticsBinding): RecyclerView.ViewHolder(binding.root){

        fun bind(element: Cosmetics, position: Int) {

            binding.tvName.text = element.name
            val str = binding.tvDesc.context.getString(R.string.date) + element.date
            binding.tvDesc.text= str

//            binding.descrtv.text = element.description
//            val str2 = binding.descrtv.context.getString(R.string.description) + element.description
//            binding.descrtv.text= str2

            binding.btn.setOnClickListener{
                onClick(element,position)
            }

            Glide.with(binding.iv.context)
                .load("https://s2.stc.all.kpcdn.net/woman/wp-content/uploads/2022/04/20-luchshih-rossijskih-brendov-kosmetiki-960x540.jpg")
                .centerInside()
                .placeholder(R.drawable.baseline_back_hand_24)
                .into(binding.iv)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CosmeticsViewHolder {
        val binding = ItemCosmeticsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CosmeticsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CosmeticsViewHolder, position: Int) {

        val element = list[position]
        holder.bind(element, position)
    }


}