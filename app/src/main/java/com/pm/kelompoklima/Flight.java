package com.pm.kelompoklima;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

/*import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.datepicker.DateValidatorPointForward;
import com.google.android.material.datepicker.MaterialDatePicker;
import com.google.android.material.datepicker.MaterialPickerOnPositiveButtonClickListener;*/


import java.text.SimpleDateFormat;
import java.util.Calendar;
/*import java.util.Date;*/
import java.util.Locale;
/*import java.util.TimeZone;*/

public class Flight extends AppCompatActivity {

    Calendar myCalender;
    DatePickerDialog.OnDateSetListener date;

    RadioButton rb1, rb2;
    Button searchFlight, mButton;
    TextView dateFlight;
    /*TextView tanggal;*/
    /*DatePickerDialog pickerDialog,datePickerDialog;*/
    Spinner from, to, passengers, seat;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight);

        dateFlight = findViewById(R.id.dateFlight);

        rb1 = findViewById(R.id.radio1);
        rb1 = findViewById(R.id.radio2);
        /*tanggal = findViewById(R.id.tvTanggal);*/

        from = findViewById(R.id.spinnerFrom);
        to = findViewById(R.id.spinnerTo);
        passengers = findViewById(R.id.spinnerPssr);
        seat = findViewById(R.id.spinnerSeat);
        searchFlight = findViewById(R.id.btnCari);

        myCalender = Calendar.getInstance();
        date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                myCalender.set(Calendar.YEAR, year);
                myCalender.set(Calendar.MONTH, monthOfYear);
                myCalender.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                TextView tanggal = findViewById(R.id.dateFlight);
                String myFormat = "dd-MMMM-yyyy";
                SimpleDateFormat sdf = new SimpleDateFormat(myFormat, Locale.US);
                tanggal.setText(sdf.format(myCalender.getTime()));
            }
        };
        dateFlight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(Flight.this, date,
                        myCalender.get(Calendar.YEAR),
                        myCalender.get(Calendar.MONTH),
                        myCalender.get(Calendar.DAY_OF_MONTH)).show();
            }
        });



        /*Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        calendar.clear();

        final long today = MaterialDatePicker.todayInUtcMilliseconds();

        MaterialDatePicker.Builder builder = MaterialDatePicker.Builder.datePicker();
        builder.setTitleText("Pilih Tanggal");
        builder.setSelection(today);
        final MaterialDatePicker materialDatePicker = builder.build();

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                materialDatePicker.show(getSupportFragmentManager(), "DATE_PICKER");
            }
        });

        materialDatePicker.addOnPositiveButtonClickListener(new MaterialPickerOnPositiveButtonClickListener() {
            @Override
            public void onPositiveButtonClick(Object selection) {
                mTextView.setText("Selected Date : "+ materialDatePicker.getHeaderText());
            }
        });*/
    }
}

        /*setDate(tanggal);
        tanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar calendar = Calendar.getInstance();
                int day = calendar.get(Calendar.DAY_OF_MONTH);
                int month = calendar.get(Calendar.MONTH);
                int year = calendar.get(Calendar.YEAR);

                pickerDialog = new DatePickerDialog(Flight.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker , int year, int monthOfYear, int dayOfMonth) {
                                tanggal.setText(dayOfMonth + "/" + (monthOfYear+ 1) + "/" + year );
                            }
                        }, year, month, day);
                pickerDialog.getDatePicker().setMinDate(calendar.getTimeInMillis());

                pickerDialog.show();
            }
        });
    }

    private void setDate(TextView tanggal) {
        Date hrini = Calendar.getInstance().getTime();
        SimpleDateFormat format = new SimpleDateFormat("d MMMM yyyy");
        String date = format.format(hrini);
        tanggal.setText(date);

    }
}*/