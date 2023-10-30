package com.example.avtosalonn;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Cars> cars = new ArrayList<Cars>();
    ListView carsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // начальная инициализация списка
        setInitialData();
        // получаем элемент ListView
        carsList = findViewById(R.id.carsList);
        // создаем адаптер
        CarsAdapter stateAdapter = new CarsAdapter(this, R.layout.list_item, cars);
        // устанавливаем адаптер
        carsList.setAdapter(stateAdapter);
        // слушатель выбора в списке
        AdapterView.OnItemClickListener itemListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {

                // получаем выбранный пункт
                Cars selectedState = (Cars)parent.getItemAtPosition(position);
                Toast.makeText(getApplicationContext(), "Был выбран пункт " + selectedState.getName(),
                        Toast.LENGTH_SHORT).show();
            }
        };
        carsList.setOnItemClickListener(itemListener);
    }
    private void setInitialData() {

        cars.add(new Cars("Acura", "Бразилиа", R.drawable.acura1));
        cars.add(new Cars("Astomartin", "Буэнос-Айрес", R.drawable.astonmartin3));
        cars.add(new Cars("Audi", "Богота", R.drawable.audi4));

    }
}