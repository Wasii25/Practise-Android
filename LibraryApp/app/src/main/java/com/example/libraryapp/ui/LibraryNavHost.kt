package com.example.libraryapp.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.libraryapp.ui.screens.BookDetailsScreen
import com.example.libraryapp.ui.screens.LibraryScreen

@Composable
fun LibraryNavHost(
    modifier: Modifier,
    navController: NavHostController
) {
    NavHost(
        navController = navController,
        startDestination = "library"
    ) {

        composable("library") {
            LibraryScreen(
                onBookClick = { bookId ->
                    navController.navigate("details/$bookId")
                },
                modifier = Modifier.fillMaxSize()
            )
        }

        composable(
            route = "details/{bookId}",
            arguments = listOf(
                navArgument("bookId") {
                    type = NavType.StringType
                }
            )
        ) { backStackEntry ->
            val bookId = backStackEntry.arguments?.getString("bookId")
            BookDetailsScreen(bookId ?: "", modifier = Modifier.fillMaxSize())
        }
    }
}