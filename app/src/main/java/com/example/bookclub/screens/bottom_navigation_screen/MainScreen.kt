package com.example.bookclub.screens.bottom_navigation_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import com.example.bookclub.screens.bookmarks_screen.Bookmarks
import com.example.bookclub.screens.bookmarks_screen.BookmarksScreen
import com.example.bookclub.screens.library_screen.Library
import com.example.bookclub.screens.library_screen.LibraryScreen
import com.example.bookclub.screens.search_screen.Search
import com.example.bookclub.screens.search_screen.SearchScreen

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            CustomBottomNavigation(
                navigateToLibrary = {navController.navigate(Library)},
                navigateToSearch = {navController.navigate(Search)},
                navigateToBookmark = {navController.navigate(Bookmarks)},
                navigateToLogout = {}
            )},
        floatingActionButton = { BottomNavigationFab() },
        floatingActionButtonPosition = FabPosition.Center,
    ) {
        val graph = navController.createGraph(startDestination = Library) {
            composable<Library> {
                LibraryScreen()
            }
            composable<Search> {
                SearchScreen()
            }
            composable<Bookmarks> {
                BookmarksScreen()
            }
        }

        NavHost(
            navController = navController,
            graph = graph
        )
    }
}

@Preview
@Composable
fun previewW(){
    MainScreen()
}