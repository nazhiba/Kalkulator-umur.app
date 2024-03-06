package com.nazhiba.kalkulatorumur

import android.app.DatePickerDialog
import android.icu.util.Calendar
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.Locale

class MainActivity : AppCompatActivity() {

    //
    private var tvselectedDate:TextView? = null
    private var tvageinMinutes:TextView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // penggunaan on clik listener
        val button = findViewById<Button>(R.id.button)
        tvselectedDate = findViewById(R.id.tvselecteddate)
        tvageinMinutes = findViewById(R.id.tvageinMinutes)
        button.setOnClickListener(){

            // pemangilan datapicker
            datapicker()
        }
    }

    // function untuk datapicker
    private fun datapicker(){

        // inisialisasi kalender
        val mykalender = Calendar.getInstance()
        val tahun = mykalender.get(Calendar.YEAR)
        val bulan = mykalender.get(Calendar.MONTH)
        val hari = mykalender.get(Calendar.DAY_OF_MONTH)

        // pemilihan kalender
        val dpd = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener{ _, selectedyear, selectedmonth, selecteddayOfMonth ->
                // menampilkan pop-up
                Toast.makeText(this,"Tahun was ${selectedyear}, Bulan adalah ${selectedmonth+1}, di hari ${selecteddayOfMonth} BtnDatePicker pressed", Toast.LENGTH_LONG).show()

                val selecteddate = "$selecteddayOfMonth/${selectedmonth+1}/$selectedyear"
                tvselectedDate?.text = selecteddate

                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val thedate = sdf.parse(selecteddate)
                thedate?.let {
                    val selectedDatesInMinutes = thedate.time/60000

                    val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))
                    currentDate?.let {
                        val currentDateInMinutes = currentDate.time/60000

                        val differenceInMinutes = currentDateInMinutes - selectedDatesInMinutes
                        tvageinMinutes?.text = differenceInMinutes.toString()
                    }

                }


            },
            tahun,
            bulan,
            hari
        )
        dpd.datePicker.maxDate = System.currentTimeMillis() - 86400000
        dpd.show()




    }
}