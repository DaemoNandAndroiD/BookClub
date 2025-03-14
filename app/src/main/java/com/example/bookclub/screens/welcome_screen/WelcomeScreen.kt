package com.example.bookclub.screens.welcome_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookclub.R
import com.example.bookclub.screens.welcome_screen.components.BookImage
import com.example.bookclub.screens.welcome_screen.components.InputField
import com.example.bookclub.screens.welcome_screen.components.PasswordInputField
import com.example.bookclub.screens.welcome_screen.utils.AutoScrollingLazyRow
import com.example.bookclub.screens.welcome_screen.utils.ListItem
import com.example.bookclub.ui.theme.alumniSansFontFamily
import com.example.bookclub.ui.theme.velaSansFontFamily
import kotlinx.coroutines.flow.distinctUntilChanged
import java.util.UUID

@Composable
fun WelcomeScreen() {
    var emailInput by remember { mutableStateOf(TextFieldValue("")) }
    var passwordInput by remember { mutableStateOf(TextFieldValue("")) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.accent_dark))
    ) {
        AutoScrollingLazyRow(
            listOf(
                ListItem(res = R.drawable.image),
                ListItem(res = R.drawable.image),
                ListItem(res = R.drawable.image),
                ListItem(res = R.drawable.image),
                ListItem(res = R.drawable.image),
                ListItem(res = R.drawable.image),
                ListItem(res = R.drawable.image),
                ListItem(res = R.drawable.image),
                ListItem(res = R.drawable.image),
                ListItem(res = R.drawable.image),
            ),
            modifier = Modifier.fillMaxHeight(0.3f)
        ){
            BookImage(it.res)
        }



        Column(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier.padding(
                start = dimensionResource(R.dimen.small_startend_padding),
                end = dimensionResource(R.dimen.small_startend_padding),
                top = 48.dp,
                bottom = 32.dp
            )
        ) {
            Text(
                text = stringResource(R.string.small_title_welcome),
                fontSize = 48.sp,
                fontFamily = alumniSansFontFamily,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Text(
                modifier = Modifier.fillMaxWidth(),
                style = LocalTextStyle.current.merge(
                    TextStyle(
                        platformStyle = PlatformTextStyle(
                            includeFontPadding = false
                        ),
                        lineHeight = 76.sp,
                        lineHeightStyle = LineHeightStyle(
                            alignment = LineHeightStyle.Alignment.Top,
                            trim = LineHeightStyle.Trim.FirstLineTop
                        )
                    )
                ),
                text = stringResource(R.string.big_title_welcome),
                fontSize = 96.sp,
                fontFamily = alumniSansFontFamily,
                fontWeight = FontWeight.Bold,
                color = colorResource(R.color.red_secondary)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = dimensionResource(R.dimen.small_startend_padding)),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            InputField(
                textFieldValue = emailInput,
                onValueChanged = { emailInput = it },
                textHint = stringResource(R.string.email_input_hint),
                icon = Icons.Default.Clear,
                iconClick = {
                    emailInput = TextFieldValue("")
                },
            )
            PasswordInputField(
                textFieldValue = passwordInput,
                onValueChanged = { passwordInput = it },
                textHint = stringResource(R.string.password_input_hint),
            )
        }

        TextButton(
            modifier = Modifier
                .padding(
                    horizontal = dimensionResource(R.dimen.small_startend_padding),
                    vertical = dimensionResource(R.dimen.medium_vertical_padding)
                )
                .fillMaxWidth()
                .background(
                    if (emailInput.text.isEmpty() || passwordInput.text.isEmpty())
                        colorResource(R.color.accent_medium)
                    else colorResource(R.color.white),
                    RoundedCornerShape(100.dp)
                ),
            onClick = {}
        ) {
            Text(
                text = stringResource(R.string.enter_button_title),
                fontFamily = velaSansFontFamily,
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                color = if (emailInput.text.isEmpty() || passwordInput.text.isEmpty())
                    colorResource(R.color.accent_light)
                else colorResource(R.color.accent_dark)
            )
        }
    }
}

@Preview
@Composable
fun Preview() {
    WelcomeScreen()
}