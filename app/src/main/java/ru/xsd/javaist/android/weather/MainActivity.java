package ru.xsd.javaist.android.weather;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private Spinner cityName;
    private Button searchButton;
    private Switch humiditySwitch, pressureSwitch, windSwitch;

    static String cityTitleKey = "cityTitleKey";
    static String humiditySwitchKey = "humiditySwitchKey";
    static String pressureSwitchKey = "pressureSwitchKey";
    static String windSwitchKey = "windSwitchKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        setOnSearchButtonClick();

        Toast.makeText(getBaseContext(), "onCreate", Toast.LENGTH_SHORT).show();
    }

    private void setOnSearchButtonClick() {
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CityActivity.class);
                Log.d(TAG, cityName.getSelectedItem().toString());
                String cityTitle = cityName.getSelectedItem().toString();
                intent.putExtra(cityTitleKey, cityTitle);
                boolean humiditySwitchValue = humiditySwitch.isChecked();
                intent.putExtra(humiditySwitchKey, humiditySwitchValue);
                boolean pressureSwitchValue = pressureSwitch.isChecked();
                intent.putExtra(pressureSwitchKey, pressureSwitchValue);
                boolean windSwitchValue = windSwitch.isChecked();
                intent.putExtra(windSwitchKey, windSwitchValue);
                startActivity(intent);
            }
        });
    }

    private void initViews() {
        searchButton = findViewById(R.id.searchButton);
        cityName = findViewById(R.id.citySpinner);
        humiditySwitch = findViewById(R.id.humiditySwitch);
        pressureSwitch = findViewById(R.id.pressureSwitch);
        windSwitch = findViewById(R.id.windSwitch);
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
