package com.techbyking.composedemo
// Jetpack Compose 1.5 Essentials Book
// Jan 17, 2024  David King
// Chapter 4
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderPositions
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Alignment
import androidx.compose.runtime.*
import com.techbyking.composedemo.ui.theme.ComposeDemoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                   DemoScreen()
                }
            }
        }
    }
}

@Composable
fun DemoText(message : String, fontSize : Float){
    Text(
        text = message,
        fontSize =fontSize.sp,
        fontWeight = FontWeight.Bold
    )
} // End DemoScreen function

@Composable
fun DemoSlider(sliderPosition: Float, onPositionChange: (Float) -> Unit){
    Slider(
        modifier = Modifier.padding(10.dp),
        valueRange = 20f..38f,
        value = sliderPosition,
        onValueChange = onPositionChange
    )

}


@Composable
fun DemoScreen(){
    var sliderPosition by remember {mutableStateOf(20f)}

    // Event handler Lambda when slider moves
    val handlePositionChange = {position : Float -> sliderPosition = position}

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    )
    {
        DemoText (message = "This is Compose 1.5", fontSize = sliderPosition)

        Spacer(modifier = Modifier.height(150.dp))

        DemoSlider(
            sliderPosition = sliderPosition,
            onPositionChange = handlePositionChange
        )

        Text(
            style = MaterialTheme.typography.headlineMedium,
            text = sliderPosition.toInt().toString() + "sp"
        )
    }
}


@Preview(showSystemUi = true)
@Composable
fun DemoTextPreview(){
    ComposeDemoTheme {
        DemoScreen()
    }
}



