package com.iesfranciscodelosrios.canvas_rafalucena_alejandrogutierrez_alejandrogalvez;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    private ColorClass miCanvas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        miCanvas = findViewById(R.id.miCanvas);

        findViewById(R.id.botonCambiarColor).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Al hacer clic en el botón, se llama al método cambiarColorLapiz en ColorClass
                miCanvas.cambiarColorLapiz();
            }
        });
    }

}