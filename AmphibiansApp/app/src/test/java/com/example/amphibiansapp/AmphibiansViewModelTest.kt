package com.example.amphibiansapp

import com.example.amphibiansapp.fake.FakeDataSource
import com.example.amphibiansapp.fake.FakeNetworkAmphibiansRepository
import com.example.amphibiansapp.ui.AmphibiansUiState
import com.example.amphibiansapp.ui.AmphibiansViewModel
import org.junit.Rule
import org.junit.Test
import kotlin.test.assertEquals

class AmphibiansViewModelTest {

    @get:Rule
    val testDispatcher = TestDispatcherRule()

    @Test
    fun amphibiansViewModel_getAmphibians_verifyAmphibiansUiStateSuccess() {
        val viewModel = AmphibiansViewModel(FakeNetworkAmphibiansRepository())
        assertEquals(
            AmphibiansUiState.Success(FakeDataSource.amphibiansList),
            viewModel.uiState.value
        )
    }
}