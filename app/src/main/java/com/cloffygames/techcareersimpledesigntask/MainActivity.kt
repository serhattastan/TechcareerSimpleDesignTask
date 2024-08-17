package com.cloffygames.techcareersimpledesigntask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.cloffygames.techcareersimpledesigntask.ui.theme.TechcareerSimpleDesignTaskTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TechcareerSimpleDesignTaskTheme {
                LoginScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LoginScreen(){
    val config = LocalConfiguration.current
    val screenWidht = config.screenWidthDp
    val screenHeight = config.screenHeightDp

    val productInfo = GraphicCard(
        1,
        "GIGABYTE RTX4070TI Windforce Oc",
        "2625 MHz",
        "HDMI",
        "8 GB",
        "GDDR6",
        "192-bit",
        true,
        32204,
        R.drawable.main_product,
        4.5f)

    Scaffold (
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "hepsiburada", color = Color.White)
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Yellow,
                    titleContentColor = Color.White
                )
            )
        }
    ){ paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "GIGABYTE RTX4070TI Windforce Oc",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = (screenWidht / 20).sp,
                lineHeight = (screenWidht / 19).sp,
                maxLines = 1,
                textAlign = TextAlign.Center
            )

            Image(painter = painterResource(
                id = productInfo.image),
                contentDescription = "",
                modifier = Modifier.width(screenWidht.dp).height((screenHeight/3).dp))

            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color(0x80CCCCCC))
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
            ){
                Row {
                    Column {
                        Text(text = "Çekirdek Hızı: ")
                        Text(text = "Grafik Bellek: ")
                        Text(text = "Bağlantı: ")

                    }
                    Column {
                        Text(text = productInfo.coreClock)
                        Text(text = productInfo.graphicMemory)
                        Text(text = productInfo.connectionType)

                    }
                }
                Row {
                    Column {
                        Text(text = "Overclock:  ")
                        Text(text = "Bellek Tipi:  ")
                        Text(text = "Bit Değeri:  ")

                    }
                    Column {
                        Text(text = if (productInfo.overClock) "Var" else "Yok")
                        Text(text = productInfo.memoryType)
                        Text(text = productInfo.byteValue)

                    }
                }

            }

            Row (
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = Color.Gray)
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
            ){
                Text(
                    text = "Fiyat: ${productInfo.price}₺",
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Black)
                Text(
                    text = "Raiting:  ${productInfo.userRating}",
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Black)
            }

            val quantity = remember { mutableStateOf(1) }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {

                val quantity = remember { mutableStateOf(1) }

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Row(
                        modifier = Modifier
                            .background(
                                Color.LightGray,
                                shape = RoundedCornerShape(4.dp)
                            )  // Köşeleri yuvarlatılmış gri arka plan
                            .padding(horizontal = 8.dp, vertical = 4.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        IconButton(
                            onClick = { if (quantity.value > 1) quantity.value-- },
                            modifier = Modifier.size(36.dp)  // Butonun boyutu
                        ) {
                            Text(text = "-", fontSize = 20.sp, color = Color.Black)
                        }
                        Text(
                            text = "${quantity.value} Adet",
                            modifier = Modifier.padding(horizontal = 16.dp),
                            fontWeight = FontWeight.Bold,
                            fontSize = 18.sp
                        )
                        IconButton(
                            onClick = { quantity.value++ },
                            modifier = Modifier.size(36.dp)  // Butonun boyutu
                        ) {
                            Text(text = "+", fontSize = 20.sp, color = Color.Black)
                        }
                    }

                    Button(
                        onClick = {  },
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFFFA500)
                        ),
                        modifier = Modifier
                            .height(48.dp)
                            .padding(start = 16.dp)
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.cart_image),
                            contentDescription = "Sepete Ekle",
                            modifier = Modifier.size(25.dp),
                            tint = Color.White
                        )
                        Text(
                            text = "Sepete Ekle",
                            color = Color.White,
                            fontSize = 16.sp,
                            modifier = Modifier.padding(start = 8.dp)
                        )
                    }

                }

            }

            Text(
                text = "Benzer Ürünler:",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp)

            Row {
                ProductCard(productInfo)
                ProductCard(productInfo)
                ProductCard(productInfo)

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TechcareerSimpleDesignTaskTheme {
        LoginScreen()
    }
}
