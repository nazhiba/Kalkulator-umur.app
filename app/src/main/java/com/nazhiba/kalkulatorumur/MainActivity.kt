package com.nazhiba.kalkulatorumur

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // penggunaan on clik listener
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener(){

            // pemangilan datapicker
            datapicker()
        }
    }

    // function untuk datapicker
    fun datapicker(){

        // inisialisasi kalender
        val mykalender = Calendar.getInstance()
        val tahun = mykalender.get(Calendar.YEAR)
        val bulan = mykalender.get(Calendar.MONTH)
        val hari = mykalender.get(Calendar.DAY_OF_MONTH)

        // pemilihan kalender
        DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener{ view, selectedyear, selectedmonth, selecteddayOfMonth ->
                // menampilkan pop-up
                Toast.makeText(this,"Tahun was ${selectedyear}, Bulan adalah ${selectedmonth+1}, di hari ${selecteddayOfMonth} BtnDatePicker pressed", Toast.LENGTH_LONG).show()
            },
            tahun,
            bulan,
            hari
        ).show()

    }
}