package org.example;

public class Ship {
    private String name;
    private int size,x,y;

    public Ship(String name, int size, int x, int y) {
        this.name = name;
        this.size = size;
        this.x = x;
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "Ship{" +
                "name='" + name + '\'' +
                ", size=" + size +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
