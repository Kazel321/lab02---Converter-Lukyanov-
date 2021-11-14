package com.example.lab02converterlukyanov;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import myspecial.functions.Unit;

public class MainActivity extends AppCompatActivity {

    Spinner l_from, l_to;
    EditText t_from;
    TextView t_to;
    RadioButton rbLenght, rbWeight, rbVolume;
    ArrayAdapter<Unit> adp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        l_from = findViewById(R.id.list_from);
        l_to = findViewById(R.id.list_to);
        t_from = findViewById(R.id.text_from);
        t_to = findViewById(R.id.text_to);

        rbLenght = findViewById(R.id.rBLength);
        rbWeight = findViewById(R.id.rBWeight);
        rbVolume = findViewById(R.id.rBVolume);

        adp = new ArrayAdapter<Unit>(this, android.R.layout.simple_list_item_1);



    }


    public void doConvertion(View v)
    {
        String s_from = t_from.getText().toString();
        double i_from;
        if (s_from.isEmpty())
        {
            Log.e("test", "text field is empty");
            Toast.makeText(this, "text field is empty", Toast.LENGTH_SHORT).show();
            return;
        }
        try
        {
            i_from = Double.parseDouble(s_from);
        }
        catch(Exception e)
        {
            Toast.makeText(this, "invalid numeric format", Toast.LENGTH_SHORT).show();
            return;
        }
        Unit s_unit_from = (Unit) l_from.getSelectedItem();
        Unit s_unit_to = (Unit) l_to.getSelectedItem();

        double f_result = (double) i_from / s_unit_from.coeff * s_unit_to.coeff;


        String s_result = String.valueOf(f_result);
        t_to.setText(s_result);

    }

    public void changeConvention(View v)
    {
        adp.clear();
        RadioButton rb = (RadioButton)v;
        switch (rb.getId())
        {
            case R.id.rBLength:
                adp.add(new Unit("mm", 1000.0f));
                adp.add(new Unit("cm", 100.0f));
                adp.add(new Unit("m", 1.0f));
                adp.add(new Unit("km", 0.001f));
                break;
            case R.id.rBWeight:
                adp.add(new Unit("mg", 1000000.0f));
                adp.add(new Unit("g", 1000.0f));
                adp.add(new Unit("kg", 1.0f));
                adp.add(new Unit("t", 0.001f));
                break;
            case R.id.rBVolume:
                adp.add(new Unit("ml", 1000.0f));
                adp.add(new Unit("l", 1.0f));
                adp.add(new Unit("m³", 0.001f));
                break;
        }
        l_from.setAdapter(adp);
        l_to.setAdapter(adp);
    }
}