package com.example.mission13;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    double a, b, c;
    Random rnd = new Random();
    EditText eT, eT2, eT3;
    Button btn, btn2;

    int count = 0;
    int count2 = 0;
    double number = 0, number2 = 0, number3 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        btn2 = findViewById(R.id.btn2);
        eT = findViewById(R.id.eT);
        eT2 = findViewById(R.id.eT2);
        eT3 = findViewById(R.id.eT3);
    }
    public void enter_a(View view)
    {

    }
    public void enter_b(View view)
    {

    }
    public void enter_c(View view)
    {

    }

    public void clicked(View view) {
        a = rnd.nextInt(100) + 1;
        eT.setText(String.valueOf(a));

        b = rnd.nextInt(100) + 1;
        eT2.setText(String.valueOf(b));

        c = rnd.nextInt(100) + 1;
        eT3.setText(String.valueOf(c));
        count2++;
    }

    public void go(View view) {

        String text = eT.getText().toString();
        if (!text.isEmpty()) {
            a = Double.parseDouble(text);
            count++;
        }
        String text2= eT2.getText().toString();
        if (!text2.isEmpty()) {
            b = Double.parseDouble(text2);
            count++;
        }
        String text3 = eT3.getText().toString();
        if (!text3.isEmpty()) {
            c = Double.parseDouble(text3);
            count++;
        }

        if (count == 3 || count2 > 0) {
            Intent si = new Intent(this, abcActivity2.class);
            si.putExtra("result", a);
            si.putExtra("result2", b);
            si.putExtra("result3", c);
            startActivity(si);
            count = 0;
            count2 = 0;
        }
    }
}
