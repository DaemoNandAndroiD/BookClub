package com.example.bookclub.screens.bottom_navigation_screen

import android.widget.Space
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.bookclub.R

@Composable
fun CustomBottomNavigation(
    navigateToLibrary:()->Unit,
    navigateToSearch:()->Unit,
    navigateToBookmark:()->Unit,
    navigateToLogout:()->Unit,
){
    val selectedNavigationIndex = rememberSaveable {
        mutableIntStateOf(0)
    }

    BottomAppBar(
        modifier = Modifier
            .fillMaxWidth()
            .padding(
                start = dimensionResource(R.dimen.medium_vertical_padding),
                end = dimensionResource(R.dimen.medium_vertical_padding),
                bottom = 40.dp
            )
            .height(64.dp)
            .clip(CircleShape),
        containerColor = colorResource(R.color.accent_dark),
    ) {
        Row(
            modifier = Modifier.fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Spacer(Modifier.weight(1f))

            CustomNavItem(
                selectedNavigationIndex = selectedNavigationIndex.intValue,
                imageVector = ImageVector.vectorResource(R.drawable.ic_library),
                index = 0,
                onClick = {
                    navigateToLibrary()
                    selectedNavigationIndex.intValue = 0
                }
            )

            Spacer(Modifier.weight(1f))

            CustomNavItem(
                selectedNavigationIndex = selectedNavigationIndex.intValue,
                imageVector = Icons.Default.Search,
                index = 1,
                onClick = {
                    navigateToSearch()
                    selectedNavigationIndex.intValue = 1
                }
            )

            Spacer(Modifier.weight(6f))

            CustomNavItem(
                selectedNavigationIndex = selectedNavigationIndex.intValue,
                imageVector = ImageVector.vectorResource(R.drawable.ic_bookmarks),
                index = 2,
                onClick = {
                    navigateToBookmark()
                    selectedNavigationIndex.intValue = 2
                }
            )

            Spacer(Modifier.weight(1f))

            CustomNavItem(
                selectedNavigationIndex = selectedNavigationIndex.intValue,
                imageVector = ImageVector.vectorResource(R.drawable.ic_logout),
                index = 3,
                onClick = {
                    navigateToLogout()
                    selectedNavigationIndex.intValue = 3
                }
            )

            Spacer(Modifier.weight(1f))
        }
    }
}