package com.bsoftware.aplikasimanajemengudang

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bsoftware.aplikasimanajemengudang.dataClass.DataBarangDataClass
import com.bsoftware.aplikasimanajemengudang.dataViewModel.DataBarangViewModel
import com.bsoftware.aplikasimanajemengudang.ui.theme.AplikasiManajemenGudangTheme

class ReadDataBarangActivity : ComponentActivity() {
    private val dataBarangViewModel : DataBarangViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AplikasiManajemenGudangTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val dataBarang by dataBarangViewModel.livedataDataBarang.observeAsState(emptyList())
                    ReadPage(dataBarangList = dataBarang)
                    // Greeting3("Android")
                }
            }
        }
        dataBarangViewModel.readDataBarang()
    }
}

@Composable
fun ReadPage(dataBarangList : List<DataBarangDataClass>) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        Column{
            Text(
                text = "Lihat Data Barang",
                style = TextStyle(
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = "Berikut data barang yang telah anda masukkan",
                style = TextStyle(
                    fontSize = 15.sp
                )
            )
        }
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(10.dp),
            modifier = Modifier.padding(top = 20.dp)
        ) {
            items(dataBarangList) { item ->
                Card(
                    modifier = Modifier
                        .height(300.dp)
                        .fillMaxWidth()
                ) {
                    Row(
                        modifier = Modifier.padding(10.dp)
                    ) {
                        Column {
                            Text(text = stringResource(id = R.string.idbarang, item.idbarang!!))
                            Text(text = stringResource(id = R.string.namabarang, item.namabarang!!))
                            Text(text = stringResource(id = R.string.kategori, item.kategori!!))
                            Text(text = stringResource(id = R.string.jumlah,item.jumlah!!))
                            Text(text = stringResource(id = R.string.lokasi, item.lokasi!!))
                            Text(text = stringResource(id = R.string.tanggalmasuk, item.tanggalmasuk!!))
                            Text(text = stringResource(id = R.string.hargabarang, item.hargabarang!!))
                            Text(text = stringResource(id = R.string.status,item.status!!))
                            Text(text = stringResource(id = R.string.catatan,item.catatan!!))
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview3() {
    AplikasiManajemenGudangTheme {
        // Greeting3("Android")
    }
}