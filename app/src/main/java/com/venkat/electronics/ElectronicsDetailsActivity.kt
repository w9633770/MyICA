package com.venkat.electronics

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.venkat.electronics.ui.theme.ElectronicsAppTheme

class ElectronicsDetailsActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ElectronicsAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .requiredWidth(width = 360.dp)
            .requiredHeight(height = 640.dp)
            .background(color = Color.White)
    ) {
        Image(
            painter = painterResource(id = R.drawable.electronic31),
            contentDescription = "",
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 0.dp,
                    y = (-10).dp)
                .requiredWidth(width = 360.dp)
                .requiredHeight(height = 257.dp)
                .clip(shape = RoundedCornerShape(20.dp)))
        Text(
            text = "",
            color = Color.Black,
            style = TextStyle(fontSize = 24.sp, fontWeight = FontWeight.Bold),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 25.dp,
                    y = 268.dp))
        Text(
            text = "£",
            color = Color(0xfff97847),
            style = MaterialTheme.typography.headlineLarge,
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 240.dp,
                    y = 261.dp)
                .requiredWidth(width = 17.dp)
                .requiredHeight(height = 28.dp))
        Text(
            text = "5000",
            color = Color(0xfff97847),
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 274.dp,
                    y = 266.dp)
                .requiredWidth(width = 86.dp)
                .requiredHeight(height = 25.dp))
        Text(
            text = "80% of people suggest this product",
            color = Color(0xff0a090b).copy(alpha = 0.5f),
            style = TextStyle(
                fontSize = 12.sp),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 29.dp,
                    y = 335.dp))
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 36.dp,
                    y = 311.dp)
                .requiredWidth(width = 50.dp)
                .requiredHeight(height = 17.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.vector),
                contentDescription = "Vector",
                modifier = Modifier
                    .fillMaxSize())
            Text(
                text = "4.5",
                color = Color(0xff2b2727),
                style = TextStyle(
                    fontSize = 12.sp),
                modifier = Modifier
                    .align(alignment = Alignment.TopStart)
                    .offset(x = 19.999755859375.dp,
                        y = 0.dp)
                    .requiredWidth(width = 30.dp)
                    .requiredHeight(height = 17.dp))
        }
        Text(
            text = "Product Info",
            color = Color(0xff0a090b),
            style = TextStyle(
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 21.dp,
                    y = 360.dp))
        Text(
            text = "Lorem ipsum dolor sit amet consectetur. Quam fames vestibulum pulvinar sit sodales integer commodo. Varius quam amet et dolor orci rhoncus eu urna dolor. Sed sed consectetur in eget ipsum suspendisse viverra. Sodales mus eget nulla justo mauris amet pellentesque augue. Et faucibus pellentesque aliquet elementum dictumst. Nibh id duis leo porta donec laoreet.",
            color = Color(0xff0a090b),
            style = TextStyle(
                fontSize = 12.sp),
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 25.dp,
                    y = 397.dp)
                .requiredWidth(width = 335.dp)
                .requiredHeight(height = 120.dp))

        val localContext = LocalContext.current

        Row(
            horizontalArrangement = Arrangement.spacedBy(10.000000953674316.dp, Alignment.CenterHorizontally),
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .offset(x = 17.dp,
                    y = 563.dp)
                .requiredWidth(width = 325.dp)
                .requiredHeight(height = 45.dp)
                .clip(shape = RoundedCornerShape(10.000000953674316.dp))
                .background(color = Color.Black)
                .clickable {
                    localContext.startActivity(Intent(localContext,PaymentActivity::class.java))
                }
                .padding(start = 50.000003814697266.dp,
                    end = 50.000003814697266.dp,
                    top = 15.004829406738281.dp,
                    bottom = 13.dp)
        ) {
            Text(
                text = "Buy Now",
                color = Color.White,
                textAlign = TextAlign.Center,
                style = TextStyle(
                    fontSize = 16.sp),
                modifier = Modifier
                    .requiredWidth(width = 86.dp)
                    .requiredHeight(height = 25.dp))
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ElectronicsAppTheme {
        Greeting("Android")
    }
}