package com.example.bookclub.screens.welcome_screen.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookclub.R
import com.example.bookclub.screens.welcome_screen.WelcomeScreenTestTags
import com.example.bookclub.ui.theme.velaSansFontFamily

@Composable
fun PasswordInputField(
    textFieldValue: TextFieldValue,
    onValueChanged:(TextFieldValue)->Unit,
    textHint:String
){
    var passwordVisibility by remember { mutableStateOf(false) }

    OutlinedTextField(
        value = textFieldValue,
        onValueChange = onValueChanged,
        placeholder = {
            Text(
                textHint,
                fontSize = 14.sp,
                fontFamily = velaSansFontFamily,
                fontWeight = FontWeight.Normal,
                color = colorResource(R.color.accent_medium)
            ) },
        modifier = Modifier.fillMaxWidth().testTag(WelcomeScreenTestTags.passwordInput),
        textStyle = TextStyle(
            fontFamily = velaSansFontFamily,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            color = colorResource(R.color.accent_light)
        ),
        shape = RoundedCornerShape(8.dp),
        visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
        trailingIcon = {
            if(textFieldValue.text.isNotEmpty()){
                Icon(
                    imageVector = if (!passwordVisibility) ImageVector.vectorResource(R.drawable.ic_eye_on) else ImageVector.vectorResource(R.drawable.ic_eye_off),
                    contentDescription = null,
                    tint = colorResource(R.color.accent_light),
                    modifier = Modifier.clickable {
                        passwordVisibility = !passwordVisibility
                    }
                )
            }
        },
        colors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            focusedTextColor = colorResource(R.color.accent_light),
            unfocusedTextColor = colorResource(R.color.accent_light),
            cursorColor = colorResource(R.color.accent_light),
            focusedBorderColor = colorResource(R.color.accent_medium),
            unfocusedBorderColor = colorResource(R.color.accent_medium)
        )
    )
}