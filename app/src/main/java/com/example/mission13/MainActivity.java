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

    boolean A = false;
    boolean B = false;
    boolean C = false;
    int count =0;

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
        if(eT.getText().toString().isEmpty()) {
            String textValue1 = eT.getText().toString();
            a = Double.parseDouble(textValue1);
            count ++;
        }else if(!eT.getText().toString().isEmpty())
    {
        count++;
    }
    }

    public void enter_b(View view)
    {
        if(eT.getText().toString().isEmpty()) {
            String textValue1 = eT.getText().toString();
            b = Double.parseDouble(textValue1);
            count ++;
        }else if(!eT.getText().toString().isEmpty())
        {
            count++;
        }
    }
    public void enter_c(View view)
    {
        if(eT.getText().toString().isEmpty()) {
            String textValue1 = eT.getText().toString();
            c = Double.parseDouble(textValue1);
            count ++;
        }else if(!eT.getText().toString().isEmpty())
        {
            count++;
        }
    }
    public void clicked(View view) {
        a = rnd.nextInt(100) + 1;
        eT.setText(String.valueOf(a));

        b = rnd.nextInt(100) + 1;
        eT2.setText(String.valueOf(b));

        c = rnd.nextInt(100) + 1;
        eT3.setText(String.valueOf(c));

    }

    public void go(View view) {





            Intent si = new Intent(this, abcActivity2.class);
            si.putExtra("result", a);
            si.putExtra("result2", b);
            si.putExtra("result3", c);
            startActivity(si);

    }
}
