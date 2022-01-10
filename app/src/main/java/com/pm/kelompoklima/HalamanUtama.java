package com.pm.kelompoklima;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class HalamanUtama extends AppCompatActivity {

   LinearLayout flight, hotel, train, topup, activities, intHotel, intFlight, budget;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_halaman_utama);

        flight = findViewById(R.id.flight_id);
        hotel = findViewById(R.id.hotel_id);
        train = findViewById(R.id.train_id);
        activities = findViewById(R.id.activity_id);
        intHotel = findViewById(R.id.intHotel_id);
        intFlight = findViewById(R.id.intFlight_id);
        topup = findViewById(R.id.topup_id);
        budget = findViewById(R.id.budget_id);

        flight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent flightIntent = new Intent(HalamanUtama.this,Flight.class);
                startActivity(flightIntent);
            }
        });

        hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent hotelIntent = new Intent(HalamanUtama.this,Hotel.class);
                startActivity(hotelIntent);
            }
        });

        train.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent trainIntent = new Intent(HalamanUtama.this,Train.class);
                startActivity(trainIntent);
            }
        });
    }
}