package com.aca.homeworks.week6;

public class SafeCartesianSystem {
    private double x;
    private double y;
    private Point point;
    private int count ;

    public synchronized void setY(double y) {
        this.y = y;
    }

    public synchronized void setCount(int count) {
        this.count = count;
    }

    public synchronized int getCount() {
        return count;
    }



    public synchronized void setXY(double x , double y ) {
        this.x = x;
        this.y = y;
    }

    public synchronized double  getY() {
        return y;
    }

    public Point getPoint() {

        return new Point(x,y);
    }

    public synchronized double getX() {
        return x;
    }
    public synchronized void increment(){
        this.count += 1;
    }
    public  synchronized void printCoordinates(){
        System.out.println("( X is " + x + " , Y is " + y);
    }
}
