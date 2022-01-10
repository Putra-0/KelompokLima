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

public class Train extends AppCompatActivity {

    Calendar myCalender;
    DatePickerDialog.OnDateSetListener date;

    Button btntrain;
    EditText ednik, ednama;
    TextView dateTrain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_train);

        dateTrain = findViewById(R.id.dateTrain);

        btntrain = findViewById(R.id.btntrain);
        ednik = findViewById(R.id.ednik);
        ednama = findViewById(R.id.ednama);

        myCalender = Calendar.getInstance();
        date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                myCalender.set(Calendar.YEAR, year);
                myCalender.set(Calendar.MONTH, monthOfYear);
                myCalender.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                TextView tanggal = findViewById(R.id.dateTrain);
                String myFormat = "dd-MMMM-yyyy";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                tanggal.setText(sdf.format(myCalender.getTime()));
            }
        };
        dateTrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(Train.this, date,
                        myCalender.get(Calendar.YEAR),
                        myCalender.get(Calendar.MONTH),
                        myCalender.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        btntrain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nik = ednik.getText().toString().trim();
                String nama = ednama.getText().toString().trim();

                if (TextUtils.isEmpty(nama)){
                    ednama.setError("Masukkan Nama Anda");
                }
                if (TextUtils.isEmpty(nik)){
                    ednik.setError("Masukkan NIK Anda");
                    return;
                }
                if (nik.length() == 16){
                    ednik.setError("NIK harus terdiri dari 16 angka");
                    return;
                }
            }
        });
    }
}