package com.example.mission13;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    double a, b, c;
    Random rnd = new Random();
    EditText eT, eT2, eT3;
    Button btn, btn2;
    double x1 , x2 ;
    int count = 0;
    int count2 = 0;
    String Error ;
    int count3=0;
    double number = 0, number2 = 0, number3 = 0;
    TextView tV8 , tV9 , tV7 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.btn);
        btn2 = findViewById(R.id.btn2);
        eT = findViewById(R.id.eT);
        eT2 = findViewById(R.id.eT2);
        eT3 = findViewById(R.id.eT3);
        tV7 = findViewById(R.id.tV7);
        tV8 = findViewById(R.id.tV8);
        tV9 = findViewById(R.id.tV9);




    }
    public void enter_a(View view)
    {

        eT.setHint("enter a");
    }
    public void enter_b(View view)
    {

        eT2.setHint("enter b");
    }
    public void enter_c(View view)
    {

        eT3.setHint("enter c");
    }

    public void clicked(View view) {
        a = rnd.nextInt(200) -100;
        eT.setText(String.valueOf(a));

        b = rnd.nextInt(200) -100;
        eT2.setText(String.valueOf(b));

        c = rnd.nextInt(200) -100;
        eT3.setText(String.valueOf(c));
        count2++;

    }

    public void go(View view) {

        String a = eT.getText().toString();
        String b = eT2.getText().toString();
        String c = eT3.getText().toString();

        if (a.isEmpty() | a.equals("-") | a.equals("-.") | a.equals("+") | a.equals("+.") | b.isEmpty() | b.equals("-") | b.equals("-.") | b.equals("+") | b.equals("+.") | c.isEmpty() | c.equals("-") | c.equals("-.") | c.equals("+") | c.equals("+."))
            Toast.makeText(this, "Invalid input", Toast.LENGTH_SHORT).show();
        else if (Double.parseDouble(a) == 0)
            Toast.makeText(this, "Invalid input, 'a' can't be 0", Toast.LENGTH_SHORT).show();
        else
        {


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
