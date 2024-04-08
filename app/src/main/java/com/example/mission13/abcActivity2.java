package com.example.mission13;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class abcActivity2 extends AppCompatActivity {
    double a , b , c ;
    TextView tV , tV2 , tV3 ,tV4 , tV5,tV6;
    Button btn4;
    double x1 , x2;
    String error = "";
    int count =0;
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
        btn4 = findViewById(R.id.btn4);

        Intent gi = getIntent();
        a = gi.getDoubleExtra("result", -1);
        b = gi.getDoubleExtra("result2", -1);
        c = gi.getDoubleExtra("result3", -1);

        tV.setText("a= "+ String.valueOf(a));
        tV2.setText("b= "+String.valueOf(b));
        tV3.setText("c= "+String.valueOf(c));




        CHECK( a,  b,  c,  tV4, tV5,x1,x2,count);


        }

    public static void CHECK(double a, double b, double c, TextView tV4, TextView tV5,double x1 , double x2,int count) {

        double delta = b * b - 4 * a * c;

        if (delta > 0) {
            tV4.setText("x2 = " + calculate_x(true, a, b , c));
            x1 = calculate_x(true, a, b , c);
            tV5.setText("x1 = " + calculate_x(false, a, b, c));
            x2 = calculate_x(true, a, b , c);
            count =+1;

        } else if (delta == 0) {
            tV4.setText("x2 = " + calculate_x(true, a, b, c));
            x1 = calculate_x(true, a, b , c);

        count =+2;
        } else {
            tV5.setText("ERROR");
            String error = "error";
            count=+3;
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
            Intent si = new Intent(this, MainActivity.class);
            si.putExtra("result", x1);
            si.putExtra("result2", x2);
            si.putExtra("result3",error);
            si.putExtra("results4",count);
            startActivity(si);
            count = 0 ;
    }

    }

