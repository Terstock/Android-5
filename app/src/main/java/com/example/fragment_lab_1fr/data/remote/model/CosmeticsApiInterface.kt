package com.example.fragment_lab_1fr.data.remote.model

import com.example.fragment_lab_1fr.data.remote.model.CosmeticsApi

class CosmeticsApiInterface {


    //simulation of internet


    fun getCosmeticsList(): List<CosmeticsApi>? {

        if (System.currentTimeMillis() % 2 == 0L){
            return generateCosmeticsList()
        } else {
            return null
        }
    }

    private fun generateCosmeticsList(): List<CosmeticsApi>{
        return listOf(
            CosmeticsApi("dfdfdf", "fgfgfgf", "fgfgfddgfg", System.currentTimeMillis(), null),
            CosmeticsApi("dfdfdfdf", "fgfgfgfff", "fgfgfgfgdd", System.currentTimeMillis(), null),
            CosmeticsApi("dfdfdfdfd", "fgfgfgfdd", "fgfgfgfgff", System.currentTimeMillis(), null),
        )
    }

}