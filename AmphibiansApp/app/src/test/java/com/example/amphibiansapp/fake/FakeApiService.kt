package com.example.amphibiansapp.fake

import com.example.amphibiansapp.model.Amphibian
import com.example.amphibiansapp.network.AmphibiansApiService

class FakeApiService : AmphibiansApiService {
    override suspend fun getAmphibians(): List<Amphibian> {
        return FakeDataSource.amphibiansList
    }
}