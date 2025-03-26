package com.example.bookclub.screens.search_screen

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.traversalIndex
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookclub.R
import com.example.bookclub.screens.library_screen.utils.GridItemData
import com.example.bookclub.screens.search_screen.components.CategoryTitle
import com.example.bookclub.screens.search_screen.components.SearchItem
import com.example.bookclub.screens.search_screen.components.SearchItemText
import com.example.bookclub.screens.search_screen.components.SearchRowComponent
import com.example.bookclub.screens.search_screen.components.getAuthors
import com.example.bookclub.screens.search_screen.components.getGenresTexts
import com.example.bookclub.screens.search_screen.components.getRecentTexts
import com.example.bookclub.screens.search_screen.components.getSearchResults
import com.example.bookclub.screens.search_screen.utils.Author
import com.example.bookclub.ui.theme.velaSansFontFamily
import kotlin.math.exp

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun SearchScreen(
    recentTextsData: List<String>? = null,
    searchResultsData: List<GridItemData>? = null,
    genresData: List<String>? = null,
    authorsData: List<Author>? = null,
    onBookDetailsNavigate: () -> Unit,
    onHideNavBar: () -> Unit
) {
    var textFieldState by remember { mutableStateOf("") }
    var expanded by rememberSaveable { mutableStateOf(false) }

    val configuration = LocalConfiguration.current
    val screenWidth = configuration.screenWidthDp.dp
    val screenHeight = configuration.screenHeightDp.dp

    val recentTexts = remember { getRecentTexts(recentTextsData).toMutableStateList() }

    val searchResults = getSearchResults(searchResultsData)

    val genresTexts = getGenresTexts(genresData)

    val authors = getAuthors(authorsData)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(R.color.background))
            .statusBarsPadding()
    ) {

        SearchBar(
            modifier = Modifier
                .testTag(SearchScreenTestTags.SEARCH_BAR)
                .fillMaxWidth()
                .padding(
                    start = dimensionResource(R.dimen.small_startend_padding),
                    end = dimensionResource(R.dimen.small_startend_padding),
                    top = dimensionResource(R.dimen.small_startend_padding)
                ),
            inputField = {
                SearchBarDefaults.InputField(
                    modifier = Modifier
                        .fillMaxSize()
                        .testTag(SearchScreenTestTags.SEARCH_BAR_FIELD)
                        .border(
                            width = 1.dp,
                            color = if (!expanded) colorResource(R.color.accent_medium) else Color.Transparent,
                            shape = CircleShape
                        ),
                    query = textFieldState,
                    onQueryChange = { textFieldState = it },
                    onSearch = { expanded = false },
                    expanded = expanded,
                    onExpandedChange = {
                        expanded = it
                        onHideNavBar()
                    },
                    placeholder = {
                        Text(
                            stringResource(R.string.search_hint),
                            fontSize = 16.sp,
                            fontFamily = velaSansFontFamily,
                            fontWeight = FontWeight.Normal,
                            color = colorResource(R.color.accent_medium),
                            modifier = Modifier.testTag(SearchScreenTestTags.SEARCH_BAR_PLACEHOLDER)
                        )
                    },

                    colors = TextFieldDefaults.colors(
                        cursorColor = colorResource(R.color.red_secondary),
                        focusedTextColor = colorResource(R.color.accent_dark),
                        unfocusedTextColor = colorResource(R.color.accent_dark),
                        focusedContainerColor = colorResource(R.color.background),
                    ),

                    leadingIcon = {
                        if (!expanded) {
                            Icon(
                                Icons.Default.Search,
                                contentDescription = null,
                                tint = colorResource(R.color.accent_medium)
                            )
                        } else {
                            IconButton(
                                modifier = Modifier.testTag(SearchScreenTestTags.SEARCH_BACK_BUTTON),
                                onClick = {
                                    expanded = false
                                    onHideNavBar()
                                }
                            ) {
                                Icon(
                                    Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = null,
                                    tint = colorResource(R.color.accent_dark)
                                )
                            }
                        }
                    },
                    trailingIcon = {
                        if (expanded) {
                            IconButton(
                                onClick = {
                                    textFieldState = ""
                                }
                            ) {
                                Icon(
                                    Icons.Default.Close,
                                    contentDescription = null,
                                    tint = colorResource(R.color.accent_dark)
                                )
                            }
                        }
                    }
                )
            },
            expanded = expanded,
            onExpandedChange = {
                expanded = it
                onHideNavBar()
            },
            colors = SearchBarDefaults.colors(
                containerColor = if (!expanded) colorResource(R.color.white) else colorResource(R.color.background),
                dividerColor = colorResource(R.color.accent_medium)
            ),
        ) {
            Spacer(Modifier.height(16.dp))
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .background(colorResource(R.color.background)),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                repeat(searchResults.size) {
                    SearchItem(
                        searchResults[it],
                        Modifier.testTag(SearchScreenTestTags.SEARCH_RESULT).height(screenHeight * 0.14f),
                        onBookDetailsNavigate
                    )
                }

                Spacer(modifier = Modifier.height(24.dp))
            }
        }

        LazyColumn(
            modifier = Modifier
                .testTag(SearchScreenTestTags.SCROLL_COLUMN)
                .fillMaxWidth()
                .padding(
                    top = 24.dp,
                    start = dimensionResource(R.dimen.small_startend_padding),
                    end = dimensionResource(R.dimen.small_startend_padding)
                )
        ) {
            if (recentTexts.isNotEmpty()) {
                item {
                    CategoryTitle(
                        stringResource(R.string.recent_category),
                        modifier = Modifier.padding(bottom = 8.dp).testTag(SearchScreenTestTags.RECENT_CATEGORY)
                    )
                }
            }


            items(recentTexts.size) {
                SearchRowComponent(
                    modifier = Modifier
                        .testTag(SearchScreenTestTags.RECENT_ITEM)
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                        .clickable {
                            textFieldState = recentTexts[it]
                            expanded = true
                            onHideNavBar()
                        },
                    content = {
                        Icon(
                            imageVector = ImageVector.vectorResource(R.drawable.ic_history),
                            contentDescription = null,
                            modifier = Modifier.padding(start = 16.dp),
                            tint = colorResource(R.color.accent_dark)
                        )
                        SearchItemText(
                            recentTexts[it],
                            Modifier
                                .padding(
                                    horizontal = 8.dp,
                                    vertical = 16.dp
                                )
                        )

                        Spacer(Modifier.weight(1f))

                        IconButton(
                            onClick = {
                                recentTexts.removeAt(it)
                            }
                        ) {
                            Icon(
                                Icons.Default.Close,
                                contentDescription = null,
                                tint = colorResource(R.color.accent_dark),
                            )
                        }
                    }
                )
            }

            if (genresTexts.isNotEmpty()) {
                item {
                    CategoryTitle(
                        stringResource(R.string.genres_category),
                        modifier = Modifier.padding(top = 24.dp, bottom = 8.dp).testTag(SearchScreenTestTags.GENRES_CATEGORY)
                    )
                }
            }

            items(genresTexts.size / 2) {
                FlowRow(
                    modifier = Modifier.padding(top = 8.dp),
                    maxItemsInEachRow = 2,
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    SearchRowComponent(
                        modifier = Modifier
                            .testTag(SearchScreenTestTags.GENRE_ITEM)
                            .width((screenWidth - 40.dp) / 2)
                            .fillMaxRowHeight()
                            .clickable {
                                expanded = true
                                textFieldState = genresTexts[it * 2]
                                onHideNavBar()
                            },
                        content = {
                            SearchItemText(
                                genresTexts[it * 2],
                                Modifier
                                    .padding(
                                        horizontal = dimensionResource(R.dimen.small_startend_padding),
                                        vertical = dimensionResource(R.dimen.small_startend_padding)
                                    )
                            )
                        }
                    )

                    SearchRowComponent(
                        modifier = Modifier
                            .testTag(SearchScreenTestTags.GENRE_ITEM)
                            .width((screenWidth - 40.dp) / 2 - 1.dp)
                            .fillMaxRowHeight()
                            .clickable {
                                expanded = true
                                textFieldState = genresTexts[it * 2 + 1]
                                onHideNavBar()
                            },
                        content = {
                            SearchItemText(
                                genresTexts[it * 2 + 1],
                                Modifier
                                    .padding(
                                        horizontal = dimensionResource(R.dimen.small_startend_padding),
                                        vertical = dimensionResource(R.dimen.small_startend_padding)
                                    )
                            )
                        }
                    )
                }
            }

            if (authors.isNotEmpty()) {
                item {
                    CategoryTitle(
                        stringResource(R.string.authors_category),
                        modifier = Modifier.padding(top = 24.dp, bottom = 8.dp).testTag(SearchScreenTestTags.AUTHORS_CATEGORY)
                    )
                }
            }

            items(authors.size) {
                SearchRowComponent(
                    modifier = Modifier
                        .testTag(SearchScreenTestTags.AUTHOR_ITEM)
                        .fillMaxWidth()
                        .padding(top = 8.dp)
                        .clickable {
                            expanded = true
                            textFieldState = authors[it].text
                            onHideNavBar()
                        },
                    content = {
                        Image(
                            painterResource(authors[it].image),
                            contentDescription = null,
                            modifier = Modifier
                                .padding(
                                    start = 16.dp,
                                    top = 12.dp,
                                    bottom = 12.dp,
                                )
                                .size(48.dp),
                            contentScale = ContentScale.FillBounds
                        )

                        SearchItemText(
                            authors[it].text,
                            Modifier
                                .padding(
                                    horizontal = 12.dp,
                                )
                        )
                    }
                )
            }

            item {
                Spacer(modifier = Modifier.height(128.dp))
            }
        }
    }
}

@Preview
@Composable
fun qerqq() {
    SearchScreen(
        onBookDetailsNavigate = {},
        onHideNavBar = {}
    )
}