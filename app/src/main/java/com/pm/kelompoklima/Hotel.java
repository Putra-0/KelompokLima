package com.pm.kelompoklima;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Hotel extends AppCompatActivity {

    Calendar myCalender;
    DatePickerDialog.OnDateSetListener date,date2;

    TextView hotelDatein,hotelDateOut;

    Button btnrsv;
    EditText ednik,ednama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);

        hotelDatein = findViewById(R.id.hotelDatein);
        hotelDateOut = findViewById(R.id.hotelDateOut);


        myCalender = Calendar.getInstance();
        date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                myCalender.set(Calendar.YEAR, year);
                myCalender.set(Calendar.MONTH, monthOfYear);
                myCalender.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                TextView tanggal = findViewById(R.id.hotelDatein);
                String myFormat = "dd-MMMM-yyyy";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                tanggal.setText(sdf.format(myCalender.getTime()));
            }
        };
        hotelDatein.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(Hotel.this, date,
                        myCalender.get(Calendar.YEAR),
                        myCalender.get(Calendar.MONTH),
                        myCalender.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        date2 = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                myCalender.set(Calendar.YEAR, year);
                myCalender.set(Calendar.MONTH, monthOfYear);
                myCalender.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                TextView tanggal2 = findViewById(R.id.hotelDateOut);
                String myFormat = "dd-MMMM-yyyy";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                tanggal2.setText(sdf.format(myCalender.getTime()));
            }
        };
        hotelDateOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(Hotel.this,date2,
                        myCalender.get(Calendar.YEAR),
                        myCalender.get(Calendar.MONTH),
                        myCalender.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        btnrsv = findViewById(R.id.btnrsv);
        ednik = findViewById(R.id.ednik);
        ednama = findViewById(R.id.ednama);

        btnrsv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nik = ednik.getText().toString().trim();
                String nama = ednama.getText().toString().trim();

                if (TextUtils.isEmpty(nama)){
                    ednama.setError("Masukkan Nama Anda");
                }

                if (TextUtils.isEmpty(nik)){
                    ednik.setError("Masukan NIK Anda");
                    return;
                }
                if (nik.length() == 16) {
                    ednik.setError("NIK harus terdiri dari 16 angka");
                    return;
                }
            }


        });
    }

}