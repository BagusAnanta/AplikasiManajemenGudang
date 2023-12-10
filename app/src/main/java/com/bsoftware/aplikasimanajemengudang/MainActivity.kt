package com.bsoftware.aplikasimanajemengudang

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bsoftware.aplikasimanajemengudang.sharePref.SharePreferenceLogin
import com.bsoftware.aplikasimanajemengudang.ui.theme.AplikasiManajemenGudangTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AplikasiManajemenGudangTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MainActivityPage()
                }
            }
        }
    }
}

@Composable
fun MainActivityPage(){
    val context : Context = LocalContext.current
    val activity : Activity? = (LocalContext.current as? Activity)
    val sharePref = SharePreferenceLogin(activity!!)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ){
        Column {
            Text(
                text = "Halo Selamat Datang ${sharePref.getUsername()}",
                style = TextStyle(
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = "Selamat datang pada aplikasi pendataan barang gudang ${sharePref.getUsername()}!, silahkan pilih opsi yang anda inginkan",
                style = TextStyle(
                    fontSize = 15.sp
                )
            )

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(top = 20.dp),
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                )
            ) {
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxSize()
                ) {
                    Text(
                        text = "Sistem Pendataan Barang Gudang Pusat Perbelanjaan",
                        style = TextStyle(
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    )
                    Text(
                        text = "Aplikasi ini merupakan sistem untuk pendataan barang-barang gudang pada pusat perbelanjaan",
                        modifier = Modifier.padding(top = 5.dp)
                    )
                }
            }

            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .size(440.dp)
                    .padding(top = 30.dp),
                shape = RoundedCornerShape(20.dp),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 6.dp
                )
            ){
                Column(
                    modifier = Modifier
                        .padding(10.dp)
                        .fillMaxSize()
                ){
                    Column {
                        Text(
                            text = "Kartu Konfigurasi Barang",
                            style = TextStyle(
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold
                            )
                        )
                        Text(
                            text = "Gunakan kartu ini untuk mengatur dan memasukkan data barang",
                            modifier = Modifier.padding(top = 5.dp)
                        )
                    }

                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center
                    ){
                        Row(
                            modifier = Modifier.padding(top = 10.dp),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Card(
                                modifier = Modifier
                                    .size(120.dp, 130.dp)
                                    .clickable {
                                        context.startActivity(
                                            Intent(
                                                context,
                                                CreateDataBarangActivity::class.java
                                            )
                                        )
                                    },
                                colors = CardDefaults.elevatedCardColors(
                                    containerColor = Color.White
                                ),
                                shape = RoundedCornerShape(20.dp),
                                elevation = CardDefaults.elevatedCardElevation(
                                    defaultElevation = 6.dp
                                )
                            ) {
                                Column(modifier = Modifier
                                    .padding(5.dp)
                                    .fillMaxSize()
                                ) {
                                    Text(
                                        text = "Masukkan data Barang",
                                        style = TextStyle(
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 15.sp
                                        )
                                    )

                                    Column(
                                        verticalArrangement = Arrangement.Bottom,
                                        horizontalAlignment = Alignment.Start,
                                        modifier = Modifier.fillMaxSize()
                                    ){
                                       // if you want add icon, place here
                                    }
                                }
                            }

                            Card(
                                modifier = Modifier
                                    .size(120.dp, 130.dp)
                                    .clickable {
                                        context.startActivity(
                                            Intent(
                                                context,
                                                ReadDataBarangActivity::class.java
                                            )
                                        )
                                    },
                                colors = CardDefaults.elevatedCardColors(
                                    containerColor = Color.White
                                ),
                                shape = RoundedCornerShape(20.dp),
                                elevation = CardDefaults.elevatedCardElevation(
                                    defaultElevation = 6.dp
                                )
                            ){
                                Column(modifier = Modifier.padding(5.dp)) {
                                    Text(
                                        text = "Lihat Data Barang",
                                        style = TextStyle(
                                            fontWeight = FontWeight.Bold,
                                            fontSize = 15.sp
                                        )
                                    )

                                    Column(
                                        verticalArrangement = Arrangement.Bottom,
                                        horizontalAlignment = Alignment.Start,
                                        modifier = Modifier.fillMaxSize()
                                    ){
                                        // if you want place icon,place here
                                    }
                                }
                            }
                        }

                        Row(
                            modifier = Modifier.padding(top = 10.dp),
                            horizontalArrangement = Arrangement.spacedBy(10.dp)
                        ) {
                            Card(
                                modifier = Modifier
                                    .size(120.dp, 130.dp)
                                    .clickable {
                                        context.startActivity(
                                            Intent(
                                                context,
                                                UpdateDataBarangActivity::class.java
                                            )
                                        )
                                    },
                                colors = CardDefaults.elevatedCardColors(
                                    containerColor = Color.White
                                ),
                                shape = RoundedCornerShape(20.dp),
                                elevation = CardDefaults.elevatedCardElevation(
                                    defaultElevation = 6.dp
                                )
                            ) {
                                Column(modifier = Modifier.padding(5.dp)) {
                                    Text(
                                        text = "Ubah Data Barang",
                                        style = TextStyle(
                                            fontSize = 15.sp,
                                            fontWeight = FontWeight.Bold
                                        )
                                    )

                                    Column(
                                        verticalArrangement = Arrangement.Bottom,
                                        horizontalAlignment = Alignment.Start,
                                        modifier = Modifier.fillMaxSize()
                                    ){
                                        // if you want place icon, place in here
                                    }
                                }
                            }

                            Card(
                                modifier = Modifier
                                    .size(120.dp, 130.dp)
                                    .clickable {
                                        context.startActivity(
                                            Intent(
                                                context,
                                                DeleteDataBarangActivity::class.java
                                            )
                                        )
                                    },
                                colors = CardDefaults.elevatedCardColors(
                                    containerColor = Color.White
                                ),
                                shape = RoundedCornerShape(20.dp),
                                elevation = CardDefaults.elevatedCardElevation(
                                    defaultElevation = 6.dp
                                )
                            ){
                                Column(modifier = Modifier.padding(5.dp)) {
                                    Text(
                                        text = "Hapus Data Barang",
                                        style = TextStyle(
                                            fontSize = 15.sp,
                                            fontWeight = FontWeight.Bold
                                        )
                                    )

                                    Column(
                                        verticalArrangement = Arrangement.Bottom,
                                        horizontalAlignment = Alignment.Start,
                                        modifier = Modifier.fillMaxSize()
                                    ){
                                       // if you want place icon, place here
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}



@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MainActivityPreview() {
    AplikasiManajemenGudangTheme {
        MainActivityPage()
    }
}