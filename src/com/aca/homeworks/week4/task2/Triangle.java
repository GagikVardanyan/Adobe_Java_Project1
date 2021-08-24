package com.aca.homeworks.week4.task2;

import java.util.Objects;

public class Triangle {
    private final Point a;
    private final Point b;
    private final Point c;

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (!(o instanceof  Triangle)){
            return false;
        }
        Triangle triangle = (Triangle) o;
        return Objects.equals(a, triangle.a) && Objects.equals(b, triangle.b) && Objects.equals(c, triangle.c);
    }

    @Override
    public String toString() {
        return "Triangle points are {" +
                "a=" + a +
                ", b=" + b +
                ", c=" + c +
                '}';
    }

    public Triangle(Point a  , Point b , Point c){
        AssertionUtils.assertNotNull(a);
        AssertionUtils.assertNotNull(b);
        AssertionUtils.assertNotNull(c);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public Triangle (Triangle triangle){
        this(triangle.getA(), triangle.getB(), triangle.getC());
    }

    public Point getC() {
        return c;
    }

    public Point getB() {
        return b;
    }

    public Point getA() {
        return a;
    }
}
