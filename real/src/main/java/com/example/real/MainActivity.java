package com.example.real;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_result = findViewById(R.id.btn);
        btn_result.setOnClickListener(this::onClick);
    }

    @SuppressLint("SetTextI18n")
    private void onClick(View v) {
        TextView tv = findViewById(R.id.result);
        EditText volume = findViewById(R.id.volume);
        int vol = Integer.parseInt(String.valueOf(volume.getText()));
        EditText prut = findViewById(R.id.length);
        int prut1 = Integer.parseInt(String.valueOf(prut.getText())) + 50;
        String prutok = String.valueOf(prut1);
        EditText cut = findViewById(R.id.cut);
        int cutting = Integer.parseInt(String.valueOf(cut.getText()));
        EditText len = findViewById(R.id.length_detail);
        int det = Integer.parseInt(String.valueOf(len.getText()));
        double mid = (double) ((det + cutting) * vol) / prut1;
        double single = (det + cutting) * vol + 50;
        int res = Math.toIntExact((long) Math.ceil(mid));
        String result = String.valueOf(res);
        if (mid < 1) tv.setText("Нужен 1 пруток длиной " + single + " мм");
        else tv.setText("Необходимо: " + result + " прутков длиной " + prutok + " мм " + "(" + mid + ")");
    }
}