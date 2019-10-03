package ru.xsd.javaist.android.weather;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class CityActivity extends AppCompatActivity {
    private static final String TAG = "CityActivity";

    private TextView cityTitleText;
    private TableRow temperatureRow, humidityRow, pressureRow, windRow;
    private TextView temperatureValue, humidityValue, pressureValue, windValue;
    private boolean action;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city);
        initViews();
        performSearch();
    }

    private void performSearch() {
        String searchString = getIntent().getStringExtra(MainActivity.cityTitleKey);
        if  (searchString.toLowerCase().contains("петербург") || searchString.toLowerCase().contains("petersburg")) {
            showData("Петербург", 6, 87, 755, 2.5);
        } else if (searchString.toLowerCase().contains("москва") || searchString.toLowerCase().contains("moscow")) {
            showData("Москва", 12, 83, 756, 0.8);
        } else {
            showData(null, 0, 0, 0, 0);
        }
    }

    private void showData(String cityName, int temperature, int humidity, int pressure, double wind) {
        if (cityName == null) {
            cityTitleText.setText("Не найден");
            temperatureRow.setVisibility(View.GONE);
            humidityRow.setVisibility(View.GONE);
            pressureRow.setVisibility(View.GONE);
            windRow.setVisibility(View.GONE);
        } else {
            cityTitleText.setText(cityName);
//            Температура
            temperatureRow.setVisibility(View.VISIBLE);
            String textTemperatureValue = String.format(Locale.ENGLISH, "%d%s", temperature, " C");
            temperatureValue.setText(textTemperatureValue);
//            Влажность
            if (getIntent().getBooleanExtra(MainActivity.humiditySwitchKey, false)) {
                humidityRow.setVisibility(View.VISIBLE);
                String textValue = String.format(Locale.ENGLISH, "%d%s", humidity, "%");
                humidityValue.setText(textValue);
            } else {
                humidityRow.setVisibility(View.GONE);
            }
//            Давление
            if (getIntent().getBooleanExtra(MainActivity.pressureSwitchKey, false)) {
                pressureRow.setVisibility(View.VISIBLE);
                String textValue = String.format(Locale.ENGLISH, "%d%s", pressure, " мм.р.с.");
                pressureValue.setText(textValue);
            } else {
                pressureRow.setVisibility(View.GONE);
            }
//            Ветер
            if (getIntent().getBooleanExtra(MainActivity.windSwitchKey, false)) {
                windRow.setVisibility(View.VISIBLE);
                String textValue = String.format(Locale.ENGLISH, "%s%s", wind, " м/с");
                windValue.setText(textValue);
            } else {
                windRow.setVisibility(View.GONE);
            }

        }

    }

    private void initViews() {
        cityTitleText = findViewById(R.id.cityTitleText);
        temperatureRow = findViewById(R.id.temperatureRow);
        temperatureValue = findViewById(R.id.textTemperatureValue);
        humidityRow = findViewById(R.id.humidityRow);
        humidityValue = findViewById(R.id.textHumidityValue);
        pressureRow = findViewById(R.id.pressureRow);
        pressureValue = findViewById(R.id.textPressureValue);
        windRow = findViewById(R.id.windRow);
        windValue = findViewById(R.id.textWindValue);
    }


    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(getBaseContext(), "onStart", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(getBaseContext(), "onResume", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(getBaseContext(), "onPause", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(getBaseContext(), "onStop", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(getBaseContext(), "onDestroy", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onDestroy");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(getBaseContext(), "onRestart", Toast.LENGTH_SHORT).show();
        Log.d(TAG, "onRestart");
    }

}
