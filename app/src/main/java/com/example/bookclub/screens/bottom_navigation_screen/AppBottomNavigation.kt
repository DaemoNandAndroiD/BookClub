package com.example.bookclub.screens.bottom_navigation_screen

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalView
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogWindowProvider
import com.example.bookclub.R
import com.example.bookclub.ui.theme.velaSansFontFamily

@Composable
fun CustomBottomNavigation(
    selectedNavigationIndex:Int,
    navigateToLibrary:(Int)->Unit,
    navigateToSearch:(Int)->Unit,
    navigateToBookmark:(Int)->Unit,
    navigateToLogout:(Int)->Unit,
){
    var dialogVisibility by remember { mutableStateOf(false) }

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
                modifier = Modifier.testTag(MainScreenTestTags.LIBRARY_NAV),
                selectedNavigationIndex = selectedNavigationIndex,
                imageVector = ImageVector.vectorResource(R.drawable.ic_library),
                index = 0,
                onClick = {
                    navigateToLibrary(0)
                }
            )

            Spacer(Modifier.weight(1f))

            CustomNavItem(
                modifier = Modifier.testTag(MainScreenTestTags.SEARCH_NAV),
                selectedNavigationIndex = selectedNavigationIndex,
                imageVector = Icons.Default.Search,
                index = 1,
                onClick = {
                    navigateToSearch(1)
                }
            )

            Spacer(Modifier.weight(6f))

            CustomNavItem(
                modifier = Modifier.testTag(MainScreenTestTags.BOOKMARKS_NAV),
                selectedNavigationIndex = selectedNavigationIndex,
                imageVector = ImageVector.vectorResource(R.drawable.ic_bookmarks),
                index = 2,
                onClick = {
                    navigateToBookmark(2)
                }
            )

            Spacer(Modifier.weight(1f))

            CustomNavItem(
                modifier = Modifier.testTag(MainScreenTestTags.LOGOUT_NAV),
                selectedNavigationIndex = selectedNavigationIndex,
                imageVector = ImageVector.vectorResource(R.drawable.ic_logout),
                index = 3,
                onClick = {
                    dialogVisibility = true
                }
            )

            Spacer(Modifier.weight(1f))
        }
    }

    if (dialogVisibility){
        Dialog(
            onDismissRequest = {dialogVisibility = false}
        ) {
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = colorResource(R.color.background), RoundedCornerShape(16.dp))
            ) {
                Column(
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.background(colorResource(R.color.background)).padding(vertical = dimensionResource(R.dimen.small_startend_padding))
                ) {
                    Image(
                        painter = painterResource(R.drawable.sad_wumpus),
                        contentDescription = null
                    )

                    Text(
                        "Вы точно хотите выйти?",
                        fontSize = 20.sp,
                        fontFamily = velaSansFontFamily,
                        fontWeight = FontWeight.Bold,
                        color = colorResource(R.color.black)
                    )

                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        TextButton(
                            onClick = {dialogVisibility = false },
                            modifier = Modifier.padding(8.dp),
                        ) {
                            Text(
                                "Нет",
                                fontSize = 16.sp,
                                fontFamily = velaSansFontFamily,
                                fontWeight = FontWeight.Bold,
                                color = colorResource(R.color.black)
                            )
                        }
                        TextButton(
                            onClick = {
                                dialogVisibility = false
                                navigateToLogout(3)
                                      },
                            modifier = Modifier.padding(8.dp),
                        ) {
                            Text(
                                "Да",
                                fontSize = 16.sp,
                                fontFamily = velaSansFontFamily,
                                fontWeight = FontWeight.Bold,
                                color = colorResource(R.color.black),
                                modifier = Modifier.testTag(MainScreenTestTags.DIALOG_CONFIRM)
                            )
                        }
                    }
                }
            }
        }
    }
}