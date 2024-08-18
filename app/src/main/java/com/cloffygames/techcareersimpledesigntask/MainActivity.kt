package com.cloffygames.techcareersimpledesigntask

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.isSystemInDarkTheme
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
import com.cloffygames.techcareersimpledesigntask.ui.theme.BackgroundColor
import com.cloffygames.techcareersimpledesigntask.ui.theme.BackgroundColorDark
import com.cloffygames.techcareersimpledesigntask.ui.theme.LightGray
import com.cloffygames.techcareersimpledesigntask.ui.theme.Orange
import com.cloffygames.techcareersimpledesigntask.ui.theme.PrimaryColor
import com.cloffygames.techcareersimpledesigntask.ui.theme.PrimaryColorDark
import com.cloffygames.techcareersimpledesigntask.ui.theme.SecondaryColor
import com.cloffygames.techcareersimpledesigntask.ui.theme.SecondaryColorDark
import com.cloffygames.techcareersimpledesigntask.ui.theme.TechcareerSimpleDesignTaskTheme
import com.cloffygames.techcareersimpledesigntask.ui.theme.roboto_bold

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TechcareerSimpleDesignTaskTheme {
                ProductScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductScreen(darkTheme: Boolean = isSystemInDarkTheme()) {
    val config = LocalConfiguration.current
    val screenWidht = config.screenWidthDp
    val screenHeight = config.screenHeightDp

    // Ürün bilgileri
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
        4.5f
    )
    val productInfo2 = GraphicCard(
        1,
        "ASUS TUF GAMING GeForce RTX 4070 Ti",
        "2625 MHz",
        "HDMI",
        "16 GB",
        "GDDR6X",
        "256-bit",
        true,
        46438,
        R.drawable.main_product,
        4.5f
    )
    val productInfo3 = GraphicCard(
        1,
        "MSI GeForce RTX 4080 SUPER",
        "2310 MHz",
        "HDMI",
        "16 GB",
        "GDDR6X",
        "256-bit",
        true,
        46438,
        R.drawable.main_product,
        4.5f
    )
    val productInfo4 = GraphicCard(
        1,
        "GIGABYTE GeForce RTX 4060 Ti",
        "2310 MHz",
        "HDMI",
        "8 GB",
        "GDDR6",
        "128-bit",
        true,
        46438,
        R.drawable.main_product,
        4.5f
    )

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "hepsiburada", color = Color.White, fontFamily = roboto_bold)  // Başlık metni
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = if (darkTheme) PrimaryColorDark else PrimaryColor,  // App bar rengi
                    titleContentColor = if (darkTheme) SecondaryColorDark else SecondaryColor  // Başlık rengi
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(if (darkTheme) BackgroundColorDark else BackgroundColor),  // Arka plan rengini tema rengine göre ayarlar
            verticalArrangement = Arrangement.SpaceEvenly,  // Dikeyde eşit boşluk bırakır
            horizontalAlignment = Alignment.CenterHorizontally  // Yatayda ortalar
        ) {
            Text(// Ürün ismini gösterir
                text = "GIGABYTE RTX4070TI Windforce Oc",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = (screenWidht / 20).sp,
                lineHeight = (screenWidht / 19).sp,
                maxLines = 1,
                textAlign = TextAlign.Center
            )

            Image(// Ürün resmini gösterir
                painter = painterResource(id = productInfo.image),
                contentDescription = "",
                modifier = Modifier
                    .width(screenWidht.dp)
                    .height((screenHeight / 3).dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = if (darkTheme) Color.DarkGray else LightGray)
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Row {
                    Column {// Ürün teknik özellikleri başlıkları
                        Text(text = "Çekirdek Hızı: ")
                        Text(text = "Grafik Bellek: ")
                        Text(text = "Bağlantı: ")
                    }
                    Column {// Ürün teknik özellikleri değerleri
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
                    Column {// Ürün özelliklerinin değerlerini gösterir
                        Text(text = if (productInfo.overClock) "Var" else "Yok")
                        Text(text = productInfo.memoryType)
                        Text(text = productInfo.byteValue)
                    }
                }
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = if (darkTheme) PrimaryColor else LightGray)
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(// Ürün fiyatını gösterir
                    text = "Fiyat: ${productInfo.price}₺",
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Black
                )
                Text(// Ürün kullanıcı puanını gösterir
                    text = "Raiting:  ${productInfo.userRating}",
                    textAlign = TextAlign.Center,
                    fontFamily = FontFamily.SansSerif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = Color.Black
                )
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                val quantity = remember { mutableStateOf(1) }  // Ürün adedi için state oluşturur

                Row(
                    modifier = Modifier
                        .background(
                            if (darkTheme) BackgroundColor else BackgroundColorDark,
                            shape = RoundedCornerShape(4.dp)
                        )  // Köşeleri yuvarlatılmış arka plan
                        .padding(horizontal = 8.dp, vertical = 4.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    IconButton(
                        onClick = { if (quantity.value > 1) quantity.value-- },  // Adedi azaltan buton
                        modifier = Modifier.size(36.dp)  // Buton boyutu
                    ) {
                        Text(text = "-", fontSize = 20.sp, color = Color.Black)
                    }
                    Text(// Ürün adedini gösterir
                        text = "${quantity.value} Adet",
                        modifier = Modifier.padding(horizontal = 16.dp),
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = if (darkTheme) Color.Black else Color.DarkGray
                    )
                    IconButton(
                        onClick = { quantity.value++ },  // Adedi artıran buton
                        modifier = Modifier.size(36.dp)  // Buton boyutu
                    ) {
                        Text(text = "+", fontSize = 20.sp, color = Color.Black)
                    }
                }

                Button(// Sepete ekle butonu, işlem tanımlı değil
                    onClick = {  },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Orange  // Buton rengi
                    ),
                    modifier = Modifier
                        .height(48.dp)
                        .padding(start = 16.dp)
                ) {
                    Icon(// Sepete ekle butonunun simgesi
                        painter = painterResource(R.drawable.cart_image),
                        contentDescription = "Sepete Ekle",
                        modifier = Modifier.size(25.dp),
                        tint = Color.White
                    )
                    Text(// Sepete ekle butonu metni
                        text = "Sepete Ekle",
                        color = Color.White,
                        fontSize = 16.sp,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }

            }

            Text(// "Benzer Ürünler" başlığı
                text = "Benzer Ürünler:",
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp
            )

            Row {//Benzer Ürünler kısmındaki ürünleri gösterir
                ProductCard(productInfo2)
                ProductCard(productInfo3)
                ProductCard(productInfo4)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    TechcareerSimpleDesignTaskTheme {
        ProductScreen()
    }
}
