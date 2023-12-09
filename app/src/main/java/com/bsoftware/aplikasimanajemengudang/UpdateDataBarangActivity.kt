package com.bsoftware.aplikasimanajemengudang

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bsoftware.aplikasimanajemengudang.dataClass.DataBarangDataClass
import com.bsoftware.aplikasimanajemengudang.dataViewModel.DataBarangViewModel
import com.bsoftware.aplikasimanajemengudang.ui.theme.AplikasiManajemenGudangTheme

class UpdateDataBarangActivity : ComponentActivity() {

    private val databarangviewmodel : DataBarangViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AplikasiManajemenGudangTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    UpdatePage(databarangviewmodel)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UpdatePage(databarangviewmodel: DataBarangViewModel = DataBarangViewModel()){
    var idbarang by remember { mutableStateOf("") }
    var namabarang by remember{ mutableStateOf("") }
    var kategori by remember { mutableStateOf("") }
    var jumlah by remember { mutableStateOf("") }
    var lokasi by remember { mutableStateOf("") }
    var tanggalmasuk by remember { mutableStateOf("") }
    var hargabarang by remember { mutableStateOf("") }
    val status by remember { mutableStateOf("") }
    var catatan by remember { mutableStateOf("") }

    val context : Context = LocalContext.current
    val activity : Activity? = (LocalContext.current as? Activity)

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(20.dp)
    ) {
        Column{
            Text(
                text = "Masukkan Data Barang",
                style = TextStyle(
                    fontSize = 25.sp,
                    fontWeight = FontWeight.Bold
                )
            )
            Text(
                text = "Isi field dibawah ini sesuai dengan deskripsi barang",
                style = TextStyle(
                    fontSize = 15.sp
                )
            )
        }

        Column(
            modifier = Modifier.padding(top = 30.dp)
        ) {
            OutlinedTextField(
                value = idbarang,
                onValueChange = {idbarang = it},
                label = {
                    Text(
                        text = "Masukkan Id Barang",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold
                        )
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),

                )
            OutlinedTextField(
                value = namabarang,
                onValueChange = {namabarang = it},
                label = {
                    Text(
                        text = "Masukkan Nama Barang",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold
                        )
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                shape = RoundedCornerShape(10.dp),

                )
            OutlinedTextField(
                value = kategori,
                onValueChange = {kategori = it},
                label = {
                    Text(
                        text = "Masukkan Kategori Barang (/Box)",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold
                        )
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                shape = RoundedCornerShape(10.dp)
            )
            OutlinedTextField(
                value = jumlah,
                onValueChange = {jumlah = it},
                label = {
                    Text(
                        text = "Masukkan Jumlah Barang",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold
                        )
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                shape = RoundedCornerShape(10.dp)
            )
            OutlinedTextField(
                value = lokasi,
                onValueChange = {lokasi = it},
                label = {
                    Text(
                        text = "Masukkan Lokasi Barang",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold
                        )
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                shape = RoundedCornerShape(10.dp)
            )
            OutlinedTextField(
                value = tanggalmasuk,
                onValueChange = {tanggalmasuk = it},
                label = {
                    Text(
                        text = "Masukkan Tanggal Masuk",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold
                        )
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                shape = RoundedCornerShape(10.dp)
            )
            OutlinedTextField(
                value = hargabarang,
                onValueChange = {hargabarang = it},
                label = {
                    Text(
                        text = "Masukkan Harga Barang Satuan",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold
                        )
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                shape = RoundedCornerShape(10.dp)
            )
            OutlinedTextField(
                value = status,
                onValueChange = {hargabarang = it},
                label = {
                    Text(
                        text = "Masukkan Status Stok Barang",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold
                        )
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                shape = RoundedCornerShape(10.dp)
            )
            OutlinedTextField(
                value = catatan,
                onValueChange = {catatan = it},
                label = {
                    Text(
                        text = "Masukkan Catatan (Jika Ada)",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold
                        )
                    )
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp),
                shape = RoundedCornerShape(10.dp)
            )
            Button(
                onClick = {
                    databarangviewmodel.updateDataBarang(
                        idbarang = idbarang,
                        namabarang = namabarang,
                        kategori = kategori,
                        jumlah = jumlah.toInt(),
                        lokasi = lokasi,
                        tanggalmasuk = tanggalmasuk,
                        hargabarang = hargabarang,
                        status = status,
                        catatan = catatan
                    )
                    // intent back into mainActivity
                    Toast.makeText(context,"Data Barang Berhasil di update", Toast.LENGTH_SHORT).show()
                    context.startActivity(Intent(context,MainActivity::class.java))
                    activity?.finish()
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
            ) {
                Text(text = "Update Data")
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun UpdateDataBarangPreview() {
    AplikasiManajemenGudangTheme {
       UpdatePage()
    }
}