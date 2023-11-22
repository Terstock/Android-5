package com.example.fragment_lab_1fr.data.local

import com.example.fragment_lab_1fr.data.local.model.CosmeticsEntity

class CosmeticsDb {

    fun getCosmeticsList(): List<CosmeticsEntity>{

        return listOf(
            CosmeticsEntity(
                1,
                "fgfg",
                "fgfgf",
                " fgfgffffg",
                System.currentTimeMillis(),
                null
            ),
            CosmeticsEntity(2, "dfdf", "dffdd", "dfdfdf", System.currentTimeMillis(),null),
            CosmeticsEntity(2, "dfdf", "dffdd", "dfdfdf", System.currentTimeMillis(),null),
        )
    }

    fun saveCosmeticsList(list: List<CosmeticsEntity>){
        //simulation of saving to db
    }



}