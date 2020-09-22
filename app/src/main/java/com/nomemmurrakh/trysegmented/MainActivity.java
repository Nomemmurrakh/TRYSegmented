package com.nomemmurrakh.trysegmented;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<ToggleButton> buttons = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            buttons.add(new ToggleButton(this));

        }
        Segmented segmented = findViewById(R.id.segmented);
        segmented.addButtonsToContainer(buttons, 0.5f);
        segmented.setOnIndexChangedListener(new Segmented.OnIndexChangedListener() {
            @Override
            public void onIndexChanged(int index) {
                Toast.makeText(getApplicationContext(), "Button Selected " + index, Toast.LENGTH_LONG).show();
            }
        });
    }
}