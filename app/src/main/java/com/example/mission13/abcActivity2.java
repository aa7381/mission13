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
    TextView tV , tV2 , tV3 ,tV4 , tV5,tV6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_abc2);
        tV = findViewById(R.id.tV);
        tV2 = findViewById(R.id.tV2);
        tV3 = findViewById(R.id .tV3);
        tV4 = findViewById(R.id.tV4);
        tV5 = findViewById(R.id.tV5);
        tV6 = findViewById(R.id.tV6);

        Intent gi = getIntent();
        a = gi.getDoubleExtra("result", -1);
        b = gi.getDoubleExtra("result2", -1);
        c = gi.getDoubleExtra("result3", -1);

        tV.setText(String.valueOf(a));
        tV2.setText(String.valueOf(b));
        tV3.setText(String.valueOf(c));




        CHECK( a,  b,  c,  tV4, tV5);


        }

    public static void CHECK(double a, double b, double c, TextView tV4, TextView tV5) {
        double x1 = 0, x2 = 0;
        double delta = b * b - 4 * a * c;

        if (delta > 0) {
            tV4.setText("x2 = " + calculate_x(true, a, b , c));
            tV5.setText("x1 = " + calculate_x(false, a, b, c));
        } else if (delta == 0) {
            tV4.setText("x2 = " + calculate_x(true, a, b, c));
        } else {
            tV5.setText("ERROR");
        }
    }

    public static double calculate_x(boolean plus_min,double a , double b , double c) {
        double x1 = Math.sqrt(b * b - 4 * a * c);
        if (plus_min) {
            x1 = -b + x1;

        } else {
            x1 = -b - x1;

        }

        x1 = x1 / 2;
        return x1;
    }


        public void go_back(View view) {

        finish();
    }

    }

