package com.example.myapp

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button_date = findViewById(R.id.button_date) as Button
        button_date.setOnClickListener { view->
            datePicker()

            Toast.makeText(this,"button Working",Toast.LENGTH_LONG).show()
        }
    }

    val tv=findViewById(R.id.tv1) as TextView
    val tv2= findViewById(R.id.textView3) as TextView

    fun datePicker(){

        val myCalender = Calendar.getInstance()
        val year = myCalender.get(Calendar.YEAR)
        val month = myCalender.get(Calendar.MONTH)
        val day = myCalender.get(Calendar.DAY_OF_MONTH)

        var Picker = DatePickerDialog(this,
            DatePickerDialog.OnDateSetListener {
                    view, syear, smonth, sday ->
                Toast.makeText(this,"The Chosen year $sday",Toast.LENGTH_LONG).show()
                val selectedDate="$sday/${smonth+1}/$syear"
                tv.setText(selectedDate)

                //
                val df = SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)

                //we create Date Object
                val dateObj = df.parse(selectedDate)

                //.time calls for getTime in milliseconds till now. since jan 6 1970
                val inMinutes = dateObj!!.time / 60000
                val curDate = df.parse(df.format(System.currentTimeMillis()))

                val curDateMin = curDate!!.time /60000
                val finalMin = inMinutes - curDateMin

                tv2.setText(finalMin.toString())

            },
            year,month,day)
        Picker.datePicker.setMaxDate(Date().time)
        Picker.show()
    }

}