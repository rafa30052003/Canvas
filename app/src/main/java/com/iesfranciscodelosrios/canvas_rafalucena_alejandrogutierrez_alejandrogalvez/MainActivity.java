package com.iesfranciscodelosrios.canvas_rafalucena_alejandrogutierrez_alejandrogalvez;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {
    private Star star;
    private StarView starView;
    private LinearLayout linearLayoutButtons;
    private LinearLayout linearLayoutEditText;
    private EditText editTextNumPuntas;
    private EditText editTextRadio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        star = new Star(1000, 1000, 10, 100);
        linearLayoutButtons = findViewById(R.id.linear_layout_buttons);
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
                starView = new StarView(MainActivity.this);
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


        Button buttonChangeColor = findViewById(R.id.botonCambiarColor);
        buttonChangeColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                starView.changeColor();
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
        private int colorIndex = 0;
        private int[] colors = {Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW};

        public StarView(MainActivity context) {
            super(context);
            paint = new Paint();
            paint.setColor(colors[colorIndex]);
            paint.setStyle(Paint.Style.STROKE);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            drawStar(canvas, paint);
        }

        private void drawStar(Canvas canvas, Paint paint) {
            float centerX = getWidth() / 2;
            float centerY = getHeight() / 2;
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


        public void changeColor() {
            colorIndex = (colorIndex + 1) % colors.length;
            paint.setColor(colors[colorIndex]);
            invalidate();
        }
    }
}
