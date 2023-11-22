package com.example.fragment_lab_1fr.data
import com.example.fragment_lab_1fr.data.local.CosmeticsDb
import com.example.fragment_lab_1fr.data.remote.model.CosmeticsApi
import com.example.fragment_lab_1fr.data.local.model.CosmeticsEntity
import com.example.fragment_lab_1fr.data.remote.model.CosmeticsApiInterface

object CosmeticsRepository {


    private val cosmeticsDb = CosmeticsDb()
    private val api = CosmeticsApiInterface()

    fun getCosmeticsList(): List<CosmeticsEntity> {

        val dataFromInet: List<CosmeticsApi>? = api.getCosmeticsList()
        if (dataFromInet != null) {
            val dataFromCache = ArrayList<CosmeticsEntity>()
            dataFromInet.forEach {
                dataFromCache.add(mapApiToEntity(it))
            }
            cosmeticsDb.saveCosmeticsList(dataFromCache)


            return cosmeticsDb.getCosmeticsList()
        } else {
            return cosmeticsDb.getCosmeticsList()
        }
    }

    private fun mapApiToEntity(apiData: CosmeticsApi): CosmeticsEntity {
        return CosmeticsEntity(
            System.currentTimeMillis(),
            apiData.externalId,
            apiData.name,
            apiData.desc,
            apiData.createDate,
            null
        )
    }
}
