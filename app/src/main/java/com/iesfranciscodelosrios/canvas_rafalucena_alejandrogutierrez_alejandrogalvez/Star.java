package com.iesfranciscodelosrios.canvas_rafalucena_alejandrogutierrez_alejandrogalvez;

public class Star {
    private float centerX;
    private float centerY;
    private int numPuntas;
    private float radius;

    public Star(float centerX, float centerY, int numPuntas, float radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.numPuntas = numPuntas;
        this.radius = radius;
    }

    public float getCenterX() {
        return centerX;
    }

    public void setCenterX(float centerX) {
        this.centerX = centerX;
    }

    public float getCenterY() {
        return centerY;
    }

    public void setCenterY(float centerY) {
        this.centerY = centerY;
    }

    public int getNumPuntas() {
        return numPuntas;
    }

    public void setNumPuntas(int numPuntas) {
        this.numPuntas = numPuntas;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }
}
