package com.example.mission13;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class abcActivity2 extends AppCompatActivity {
    String a, b, c;
    TextView tV, tV2, tV3, tV4, tV5, tV6;
    Button btn4;
    double x1, x2;
    String error = "";
    int count = 0;

    ImageView iV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abc2);
        tV = findViewById(R.id.tV);
        tV2 = findViewById(R.id.tV2);
        tV3 = findViewById(R.id.tV3);
        tV4 = findViewById(R.id.tV4);
        tV5 = findViewById(R.id.tV5);
        tV6 = findViewById(R.id.tV6);
        btn4 = findViewById(R.id.btn4);
        iV =(ImageView) findViewById(R.id.iV);



        Intent gi = getIntent();
        a = gi.getStringExtra("result");
        b = gi.getStringExtra("result2");
        c = gi.getStringExtra("result3" );

        tV.setText("a= " + String.valueOf(a));
        tV2.setText("b= " + String.valueOf(b));
        tV3.setText("c= " + String.valueOf(c));

        double A = Double.parseDouble(a);
        double B = Double.parseDouble(b);
        double C = Double.parseDouble(c);

        x1 = 0;
        x2 = 0;

        CHECK( tV4, tV5, tV6, x1, x2, count,iV,A,B,C);
    }

    public static void CHECK( TextView tV4, TextView tV5, TextView tV6, double x1, double x2, int count,ImageView iV,double A , double B ,double C)
    {

        double delta = B * B - 4 * A * C;

        if (delta > 0) {
            x2 = calculate_x(true, A, B, C);
            tV4.setText("x2 = " + x2);
            x1 = calculate_x(false, A, B, C);
            tV5.setText("x1 = " + x1);

            if(x2 <0 && x1<0 &&   A>0&& B>0)
            {
                iV.setImageResource(R.drawable.screenshot_5);
            }


            else if(x2 <0 && x1<0 &&   A<0&& C<0)
            {
                iV.setImageResource(R.drawable.screenshot_6);
            } else if (x1 > 0 && x2 > 0 && B < 0 && A> 0)
            {
                iV.setImageResource(R.drawable.screenshot_7);
            }
            else if(x1<0 && x2>0 && A<0 && B>0&&C>0) {
                iV.setImageResource(R.drawable.screenshot_8);
            }
            else if(x1>0 && x2<0 && A<0 && B>0 && C<0)
            {
                iV.setImageResource(R.drawable.screenshot_9);
            }
            else if(x1<0 && x2<0 && A<0 && B<0 && C<0)
            {
                iV.setImageResource(R.drawable.screenshot_17);
            }
            else if(x1>0 && x2>0 && A<0 && B<0 && C<0)
            {
                iV.setImageResource(R.drawable.screenshot_17);
            }


        } else if (delta == 0) {
            x1 = calculate_x(true, A, B, C);
            tV4.setText("x1 = " + x1);
            if(x1 == 0&&A>0)
            {
            iV.setImageResource(R.drawable.screenshot_10);
            }
            else if(x1 == 0&&A<0&&C<0)
            {
                iV.setImageResource(R.drawable.screenshot_11);
            } else if(x1 == 0&&A<0&&C>0)
            {
                iV.setImageResource(R.drawable.screenshot_12);
            }
            else if(x1 == 0&&A>0&&C==0)
            {
                iV.setImageResource(R.drawable.screenshot_13);
            }
            else if(x1<0 && B>0 && A>0 &&C>0)
            {
                iV.setImageResource(R.drawable.screenshot_14);
            }
            else if(x1>0 && B<0 && A>0 &&C>0)
            {
                iV.setImageResource(R.drawable.ic_launcher_background);
            }
            else if(x1<0 && A<0 && B<0 &&C<0 )
            {
                iV.setImageResource(R.drawable.screenshot_16);
            }
            else if(x1>0 && B>0 && C<0 && A<0)
            {
                iV.setImageResource(R.drawable.screenshot_18);
            }
        } else {
            tV6.setText("ERROR");

        }
    }

    public static double calculate_x(boolean plus_min, double A, double B, double C) {
        double x1 = Math.sqrt(B * B - 4 * A * C);
        if (plus_min) {
            if(B<0)
            {
                x1=B+x1;
            }
            else {
                x1 = -B + x1;
            }
        } else {
            if(B<0)
            {
                x1=B-x1;
            }else {
                x1 = -B - x1;
            }
        }
        double helock = A *2;
        x1 = x1 / helock;
        return x1;
    }

    public void go_back(View view)
    {
        Intent si = new Intent(this, MainActivity.class);
        si.putExtra("x1", x1);
        si.putExtra("x2", x2);
        si.putExtra("error", error);
        startActivity(si);
        finish();
    }
}
