package com.example.bookclub.screens.bottom_navigation_screen

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.createGraph
import androidx.navigation.toRoute
import com.example.bookclub.screens.book_details_screen.BookDetails
import com.example.bookclub.screens.book_details_screen.BookDetailsScreen
import com.example.bookclub.screens.bookmarks_screen.Bookmarks
import com.example.bookclub.screens.bookmarks_screen.BookmarksScreen
import com.example.bookclub.screens.chapter_screen.Chapter
import com.example.bookclub.screens.chapter_screen.ChapterScreen
import com.example.bookclub.screens.library_screen.Library
import com.example.bookclub.screens.library_screen.LibraryScreen
import com.example.bookclub.screens.search_screen.Search
import com.example.bookclub.screens.search_screen.SearchScreen
import kotlinx.serialization.Serializable

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen(
    logOutOnclick:()->Unit
) {
    val navController = rememberNavController()

    var bottomBarVisibility by remember { mutableStateOf(true) }

    var selectedNavigationIndex by rememberSaveable {
        mutableIntStateOf(0)
    }

    Scaffold(
        bottomBar = {
            if(bottomBarVisibility){
                CustomBottomNavigation(
                    selectedNavigationIndex,
                    navigateToLibrary = {
                        selectedNavigationIndex = it
                        navController.navigate(Library) },
                    navigateToSearch = {
                        selectedNavigationIndex = it
                        navController.navigate(Search)},
                    navigateToBookmark = {
                        selectedNavigationIndex = it
                        navController.navigate(Bookmarks)},
                    navigateToLogout = {
                        selectedNavigationIndex = it
                        logOutOnclick()}
                )
            }},

        floatingActionButton = {
            if(bottomBarVisibility){
                BottomNavigationFab(
                    modifier = Modifier.testTag(MainScreenTestTags.PLAY_NAV)
                ){
                    navController.navigate(Chapter())
                }
            } },

        floatingActionButtonPosition = FabPosition.Center,
    ) {
        val graph = navController.createGraph(startDestination = Library) {
            composable<Library> {
                bottomBarVisibility = true
                LibraryScreen{
                    navController.navigate(BookDetails)
                }
            }
            composable<Search> {
                bottomBarVisibility = true
                SearchScreen(
                    onHideNavBar = {
                        bottomBarVisibility = !bottomBarVisibility
                    },
                    onBookDetailsNavigate = {
                        navController.navigate(BookDetails)
                    }
                )
            }
            composable<Bookmarks> {
                bottomBarVisibility = true
                BookmarksScreen(
                    onChapterNavigate = {index->
                        navController.navigate(Chapter(index))
                    },
                    onBookDetailsNavigate = {
                        navController.navigate(BookDetails)
                    },
                    onChapterWithQuoteNavigate = {index,quote->
                        navController.navigate(Chapter(index, quote))
                    }
                )
            }

            composable<BookDetails> {
                bottomBarVisibility = false
                BookDetailsScreen(
                    navigateBack = {
                        navController.popBackStack()
                    },
                    onRead = {
                        navController.navigate(Chapter(it))
                    }
                )
            }

            composable<Chapter> {
                bottomBarVisibility = false
                ChapterScreen(
                    launchChapterIndex = it.arguments?.getInt("chapterIndex") ?: 0,
                    quote = it.arguments?.getString("quote") ?: ""
                ){
                    navController.popBackStack()
                }
            }
        }

        NavHost(
            navController = navController,
            graph = graph
        )
    }
}