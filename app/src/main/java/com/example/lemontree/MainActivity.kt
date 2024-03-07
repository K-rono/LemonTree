package com.example.lemontree

import android.media.Image
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.lemontree.ui.theme.LemonTreeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LemonTreeTheme {

            }
        }
    }
}
@Composable
fun ResourceCycler(phase: Int) {
    val phase by remember { mutableStateOf(1) }
    val image: Int
    val text : Int


    when (phase) {
        1 -> {
            image = R.drawable.lemon_tree
            text = R.string.step1
        }
        2 -> {
            image = R.drawable.lemon_squeeze
            text = R.string.step2
        }
        3 -> {
            image = R.drawable.lemon_drink
            text = R.string.step3
        }
        else -> {
            image = R.drawable.lemon_restart
            text = R.string.step4
        }
    }

    ShowLemonTree(
        Modifier
            .fillMaxSize()
            .wrapContentHeight(Alignment.CenterVertically),
        image,
        text
    )
}

@Composable
fun ShowLemonTree(modifier: Modifier = Modifier, image: Int, text: Int) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = image),
            contentDescription = "",
            modifier = Modifier.clickable {})
        Text(stringResource(id = text))
    }
}


