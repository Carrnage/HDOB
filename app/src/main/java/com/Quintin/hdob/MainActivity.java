package com.Quintin.hdob;

import androidx.appcompat.app.AppCompatActivity;

import android.app.LauncherActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void OnConverterClick(View view){
        Intent converterIntent = new Intent(MainActivity.this, Converter.class);
        startActivity(converterIntent);
    }

}