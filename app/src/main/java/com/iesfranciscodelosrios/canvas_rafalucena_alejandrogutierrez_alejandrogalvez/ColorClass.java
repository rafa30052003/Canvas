package com.iesfranciscodelosrios.canvas_rafalucena_alejandrogutierrez_alejandrogalvez;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class ColorClass extends View {

    private Paint paint;
    private int[] coloresLapiz = {Color.BLACK, Color.RED, Color.GREEN, Color.BLUE};
    private int indiceColorActual = 0;

    public ColorClass(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ColorClass(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    public ColorClass(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init();
    }

    private void init() {
        // Configurar el Paint
        paint = new Paint();
        actualizarColorLapiz();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
    }

    // Resto de tus métodos...

    public void cambiarColorLapiz() {
        indiceColorActual = (indiceColorActual + 1) % coloresLapiz.length;
        actualizarColorLapiz();
        invalidate();
    }

    private void actualizarColorLapiz() {
        paint.setColor(coloresLapiz[indiceColorActual]);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // Ejemplo: Dibuja un círculo
        canvas.drawCircle(getWidth() / 2, getHeight() / 2, 50, paint);
    }
}
