package com.example.bookclub

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.bookclub.screens.bookmarks_screen.BookmarksScreen
import com.example.bookclub.screens.bookmarks_screen.components.BookWithProgress
import com.example.bookclub.screens.library_screen.LibraryScreen
import com.example.bookclub.screens.search_screen.SearchScreen
import com.example.bookclub.screens.welcome_screen.WelcomeScreen
import com.example.bookclub.ui.theme.BookClubTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BookClubTheme {
                BookmarksScreen()
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BookClubTheme {
        Greeting("Android")
    }
}