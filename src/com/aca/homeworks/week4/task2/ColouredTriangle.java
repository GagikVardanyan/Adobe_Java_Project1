package com.aca.homeworks.week4.task2;

import java.util.Objects;

public class ColouredTriangle extends Triangle {

        private final Colour colour;
        public ColouredTriangle(Point a, Point b, Point c , Colour colour) {
            super(a, b, c);
            this.colour = colour;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Triangle)){
                return false;
            }
            if (o instanceof ColouredTriangle){
                ColouredTriangle triangle = (ColouredTriangle) o;
                return super.equals(triangle) && Objects.equals(this.colour , triangle.colour);
            }
            Triangle triangle = (Triangle) o;
            return super.equals(triangle);
        }

        @Override
        public String toString() {
            return super.toString() + " , Colour - " + colour.toString();
        }

}
