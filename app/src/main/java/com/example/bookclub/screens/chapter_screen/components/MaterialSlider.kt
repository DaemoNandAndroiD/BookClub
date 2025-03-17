package com.example.bookclub.screens.chapter_screen.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Label
import androidx.compose.material3.PlainTooltip
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bookclub.R
import com.example.bookclub.ui.theme.velaSansFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MaterialSlider(
    modifier: Modifier = Modifier,
    initalValue: Float,
    startValue: Float,
    endValue: Float,
    onValueChange: (Float) -> Unit
) {
    var sliderPosition by rememberSaveable { mutableFloatStateOf(initalValue) }

    val interactionSource = remember { MutableInteractionSource() }
    val colors = SliderDefaults.colors(
        thumbColor = colorResource(R.color.accent_dark),
        activeTrackColor = colorResource(R.color.accent_medium),
        inactiveTrackColor = colorResource(R.color.accent_medium),
        activeTickColor = colorResource(R.color.accent_dark),
        inactiveTickColor = colorResource(R.color.accent_dark),
        disabledActiveTickColor = colorResource(R.color.accent_dark),
        disabledInactiveTickColor = colorResource(R.color.accent_dark)
    )

    Slider(
        value = sliderPosition,
        valueRange = startValue..endValue,
        onValueChange = {
            onValueChange(it)
            sliderPosition = it
        },
        steps = 0,
        modifier = modifier,
        interactionSource = interactionSource,
        colors = colors,
        thumb = {
            Label(
                label = {
                    PlainTooltip(
                        modifier = Modifier.width(48.dp).height(44.dp),
                        containerColor = colorResource(R.color.accent_dark),
                        shape = CircleShape
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = sliderPosition.toInt().toString(),
                                color = colorResource(R.color.white),
                                textAlign = TextAlign.Center,
                                fontSize = 14.sp,
                                fontFamily = velaSansFontFamily,
                                fontWeight = FontWeight.Normal,
                            )
                        }
                    }
                },
                interactionSource = interactionSource
            ) {
                SliderDefaults.Thumb(interactionSource = interactionSource, colors = colors)
            }
        }
    )

}

@Preview
@Composable
fun SliderSample() {
    val colors = SliderDefaults.colors(
        thumbColor = colorResource(R.color.accent_dark),
        disabledActiveTrackColor = colorResource(R.color.accent_dark),
    )
    var sliderPosition by remember { mutableStateOf(0f) }
    Column(modifier = Modifier.padding(horizontal = 16.dp)) {
        Text(text = "%.2f".format(sliderPosition))
        Slider(
            modifier = Modifier.semantics { contentDescription = "Localized Description" },
            value = sliderPosition,
            onValueChange = { sliderPosition = it },
            colors = colors
        )
    }
}
