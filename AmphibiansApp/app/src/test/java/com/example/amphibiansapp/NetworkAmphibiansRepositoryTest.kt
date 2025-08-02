package com.example.amphibiansapp

import com.example.amphibiansapp.data.NetworkAmphibiansRepository
import com.example.amphibiansapp.fake.FakeApiService
import com.example.amphibiansapp.fake.FakeDataSource
import org.junit.Test
import kotlin.test.assertEquals
import kotlinx.coroutines.test.runTest

class NetworkAmphibiansRepositoryTest {

    @Test
    fun networkAmphibiansRepository_getAmphibians_verifyAmphibianList() = runTest {
            val repository = NetworkAmphibiansRepository(FakeApiService())
            assertEquals(FakeDataSource.amphibiansList, repository.getAmphibians())
        }
}
