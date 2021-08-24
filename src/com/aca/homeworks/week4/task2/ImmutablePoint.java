package com.aca.homeworks.week4.task2;

public final class ImmutablePoint implements Point {
    private double x;
    private double y;


    public ImmutablePoint() {

    }

    public ImmutablePoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public ImmutablePoint(ImmutablePoint immutablePoint) {
        this.x = immutablePoint.getX();
        this.y = immutablePoint.getY();
    }

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }

    public ImmutablePoint shiftLeft() {
        ImmutablePoint immutablePoint = new ImmutablePoint();
        immutablePoint.x = this.x - 1;
        immutablePoint.y = this.y;
        return immutablePoint;
    }

    public ImmutablePoint shiftRight() {
        ImmutablePoint immutablePoint = new ImmutablePoint();
        immutablePoint.x = this.x + 1;
        immutablePoint.y = this.y;
        return immutablePoint;
    }

    public ImmutablePoint shiftUp() {
        ImmutablePoint immutablePoint = new ImmutablePoint();
        immutablePoint.x = this.x;
        immutablePoint.y = this.y + 1;
        return immutablePoint;
    }

    public ImmutablePoint shiftDown() {
        ImmutablePoint immutablePoint = new ImmutablePoint();
        immutablePoint.x = this.x;
        immutablePoint.y = this.y - 1;
        return immutablePoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ImmutablePoint)) {
            return false;
        }
        ImmutablePoint immutablePoint = (ImmutablePoint) o;
        return x == immutablePoint.x && y == immutablePoint.y;
    }

    @Override
    public String toString() {
        return "ImmutablePoint coordinates: (" + x + "," + y + ")";
    }

}
