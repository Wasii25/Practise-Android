package com.example.amphibiansapp

import org.junit.Rule

class AmphibiansViewModelTest {

    @get:Rule
    val testDispatcher = TestDispatcherRule()

    fun amphibiansViewModel_getAmphibians_verify
}
//
//@get:Rule
//val testDispatcher = TestDispatcherRule()
//
//@Test
//fun marsViewModel_getMarsPhotos_verifyMarsUiStateSuccess() = runTest {
//    val viewModel = MarsViewModel(FakeNetworkMarsPhotosRepository())
//    assertEquals(
//        MarsUiState.Success("Success: 2 Mars photos retrieved"),
//        viewModel.marsUiState
//    )
//}