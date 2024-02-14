package com.iesfranciscodelosrios.canvas_rafalucena_alejandrogutierrez_alejandrogalvez;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;



public class MainActivity extends AppCompatActivity {
    private Star star;
    private LinearLayout linearLayoutButtons;
    private LinearLayout linearLayoutEditText;
    private EditText editTextNumPuntas;
    private EditText editTextRadio;

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

        star = new Star(1000, 1000, 10, 100);
        linearLayoutButtons = findViewById(R.id.linear_layout_buttons);
        linearLayoutEditText = findViewById(R.id.linear_layout_edittext);
        editTextNumPuntas = findViewById(R.id.editTextNumPuntas);
        editTextRadio = findViewById(R.id.editTextRadio);


        Button buttonDrawStar = findViewById(R.id.buttonDrawStar);
        buttonDrawStar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int numPuntas = Integer.parseInt(editTextNumPuntas.getText().toString());
                int radio = Integer.parseInt(editTextRadio.getText().toString());
                star.setNumPuntas(numPuntas);
                star.setRadius(radio);
                StarView starView = new StarView(MainActivity.this);
                LinearLayout llCanvas = findViewById(R.id.llCanvas);
                llCanvas.removeAllViews();
                llCanvas.addView(starView);
            }
        });

        Button buttonClearCanvas = findViewById(R.id.buttonClearCanvas);
        buttonClearCanvas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clearCanvas();
            }
        });
    }


    private void clearCanvas() {
        LinearLayout llCanvas = findViewById(R.id.llCanvas);
        llCanvas.removeAllViews();
        llCanvas.setBackgroundColor(Color.WHITE);
    }

    class StarView extends View {
        private Paint paint;

        public StarView(MainActivity context) {
            super(context);
            paint = new Paint();
            paint.setColor(Color.RED);
            paint.setStyle(Paint.Style.STROKE);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            drawStar(canvas, paint);
        }

        private void drawStar(Canvas canvas, Paint paint) {
            float centerX = star.getCenterX()/2;
            float centerY = star.getCenterY()/2;
            int numPoints = star.getNumPuntas() * 2;
            float radius = star.getRadius();

            float angle = (float) (2 * Math.PI / numPoints);
            float rotation = (float) (Math.PI / 2);

            Path path = new Path();
            for (int i = 0; i < numPoints * 2; i++) {
                float currentRadius = (i % 2 == 0) ? radius : radius / 2;
                float x = (float) (centerX + currentRadius * Math.cos(rotation + angle * i));
                float y = (float) (centerY + currentRadius * Math.sin(rotation + angle * i));
                if (i == 0) {
                    path.moveTo(x, y);
                } else {
                    path.lineTo(x, y);
                }
            }
            path.close();
            canvas.drawPath(path, paint);
        }
    }

}