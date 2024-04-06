package com.example.mission13;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class abcActivity2 extends AppCompatActivity {
    double a , b , c ;
    TextView tV , tV2 , tV3 ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_abc2);
        tV = findViewById(R.id.tV);
        tV2 = findViewById(R.id.tV2);
        tV3 = findViewById(R.id .tV3);

        Intent gi = getIntent();
        a = gi.getDoubleExtra("result", -1);
        b = gi.getDoubleExtra("result2", -1);
        c = gi.getDoubleExtra("result3", -1);

        tV.setText(String.valueOf(a));
        tV2.setText(String.valueOf(b));
        tV3.setText(String.valueOf(c));

    }

        public void go_back(View view) {

        finish();
    }

    }

