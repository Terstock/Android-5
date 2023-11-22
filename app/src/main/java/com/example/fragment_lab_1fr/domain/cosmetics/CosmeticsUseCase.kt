package com.example.fragment_lab_1fr.domain.cosmetics

import com.example.fragment_lab_1fr.data.CosmeticsRepository
import com.example.fragment_lab_1fr.data.local.model.CosmeticsEntity
import com.example.fragment_lab_1fr.domain.cosmetics.model.Cosmetica
import kotlinx.coroutines.delay
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

object CosmeticsUseCase {

    private val repo = CosmeticsRepository
    suspend fun getCosmetics(): List<Cosmetica>{
        val dataFromRepo: List<CosmeticsEntity> = repo.getCosmeticsList()
        val data = ArrayList<Cosmetica>()
        dataFromRepo.forEach {
            data.add(mapEntityToDomain(it))
        }
        delay(200)
        return data
    }

    fun mapEntityToDomain(data: CosmeticsEntity): Cosmetica{
        val date = Date(data.createDate)
        val dateStr =
            SimpleDateFormat("dd MMMM yyyy", Locale.getDefault()).format(date)
        return  Cosmetica(
            data.id,
            data.name,
            data.desc,
            dateStr,
            data.picture
        )

    }
}
