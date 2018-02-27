package com.javarush.task.task24.task2413;

public class Canvas {
    private int width, height;

    public int getWidth() {
        return width;
    }

    void setPoint(double x, double y, char c) {
        if (x < 0 || y < 0 || y > matrix.length || x > matrix[0].length) return;
        int intX = (int) Math.round(x);
        int intY = (int) Math.round(y);
        matrix[intY][intX] = c;
    }

    void drawMatrix(double x, double y, int[][] matrix, char c) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] != 0) setPoint(x + j, y + i, c);
            }
        }
    }

    void clear() {
        this.matrix = new char[height + 2][width + 2];
    }
    void print(){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j]);
            }
            System.out.println();
        }
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public char[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(char[][] matrix) {
        this.matrix = matrix;
    }

    private char[][] matrix;

    public Canvas(int width, int height) {
        this.width = width;
        this.height = height;
        this.matrix = new char[height + 2][width + 2];
    }
}
