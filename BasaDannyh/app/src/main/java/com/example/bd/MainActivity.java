package com.example.bd;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.LinkedList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    DBHelper dbHelper;
    TextView tvOut;
    EditText ename, esname, eyear;
    Button  btnDel, btnAdd, btnGet;

    @SuppressLint("CutPasteId")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dbHelper = new DBHelper(this);

        tvOut = findViewById(R.id.tvOut);

        ename = findViewById(R.id.editName);
        esname = findViewById(R.id.editSurname);
        eyear = findViewById(R.id.editYear);

        btnDel = findViewById(R.id.buttonDel);
        btnAdd = findViewById(R.id.buttonAdd);
        btnGet = findViewById(R.id.buttonGet);

        btnDel.setOnClickListener(this);
        btnAdd.setOnClickListener(this);
        btnGet.setOnClickListener(this);

    }
    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.buttonDel:
                dbHelper.DeleteAll();
                break;
            case R.id.buttonAdd:
                String name = ename.getText().toString();
                String sname = esname.getText().toString();
                int year = Integer.parseInt(eyear.getText().toString());

                Data data = new Data(name, sname, year);
                dbHelper.AddOne(data);
                break;
            case R.id.buttonGet:
                LinkedList<Data> list = dbHelper.GetAll();

                String text = "";
                for (Data d:list) text = text +(d.name)+ "  " +(d.surname)+ " "+ (d.year)+"\n";
                tvOut.setText(text.toString());
                break;
        }

    }
}