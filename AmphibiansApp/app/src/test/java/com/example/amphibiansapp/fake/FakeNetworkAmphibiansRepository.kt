package com.example.amphibiansapp.fake

import com.example.amphibiansapp.data.AmphibiansRepository
import com.example.amphibiansapp.model.Amphibian

class FakeNetworkAmphibiansRepository: AmphibiansRepository {
    override suspend fun getAmphibians(): List<Amphibian> {
        return FakeDataSource.amphibiansList
    }
}