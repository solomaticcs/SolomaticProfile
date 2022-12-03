package com.solomaticcs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.solomaticcs.ui.theme.SolomaticProfileTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SolomaticProfileTheme {
                Screen()
            }
        }
    }
}

@Composable
private fun Screen() {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        Column {
            Top(modifier = Modifier.weight(1F))
            Bottom(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
            )
        }
    }
}

@Composable
private fun Top(modifier: Modifier) {
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Photo()
        Name()
        Title()
    }
}

@Composable
private fun Photo() {
    Image(
        painter = painterResource(id = R.drawable.tony),
        contentDescription = "",
        contentScale = ContentScale.Fit,
        modifier = Modifier
            .size(150.dp)
            .border(BorderStroke(1.dp, Color.Black))
    )
}

@Composable
private fun Name() {
    Text(
        text = "Tony Yang",
        fontSize = 32.sp,
        fontWeight = FontWeight.Bold
    )
}

@Composable
private fun Title() {
    Text(
        text = "Title",
        fontSize = 18.sp
    )
}

@Composable
private fun Bottom(modifier: Modifier) {
    Column(modifier = modifier.padding(all = 16.dp)) {
        Item(imageResId = R.drawable.ic_baseline_phone_24, text = "+886 912345678")
        Item(imageResId = R.drawable.ic_baseline_web_24, text = "@solomaticcs")
        Item(imageResId = R.drawable.ic_baseline_email_24, text = "superzoro168@gmail.com")
    }
}

@Composable
fun Item(imageResId: Int, text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Image(
            painter = painterResource(imageResId),
            contentDescription = ""
        )
        Text(
            text = text
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewScreen() {
    SolomaticProfileTheme {
        Screen()
    }
}