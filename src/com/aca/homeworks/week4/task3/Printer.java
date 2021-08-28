package com.aca.homeworks.week4.task3;

import com.aca.homeworks.week4.task1.User;
import com.aca.homeworks.week4.task1.UserGroup;
import com.aca.homeworks.week4.task2.Colour;
import com.aca.homeworks.week4.task2.ColouredTriangle;
import com.aca.homeworks.week4.task2.ImmutablePoint;
import com.aca.homeworks.week4.task2.Triangle;

public class Printer {
    public static void main(String[] args) {
        User user1 = new User("a" , "b" , "c" , "d");
        User user2 = new User("aa" , "bb" , "cc" , "dd");
        specialPrint(user1);
        UserGroup userGroup = new UserGroup(new User[]{user1 , user2});
        specialPrint(userGroup);
        ImmutablePoint immutablePoint1 = new ImmutablePoint(0,0);
        specialPrint(immutablePoint1);
        ImmutablePoint immutablePoint2 = new ImmutablePoint(1,0);
        ImmutablePoint immutablePoint3 = new ImmutablePoint(0,1);
        Triangle triangle = new Triangle(immutablePoint1 , immutablePoint2 , immutablePoint3);
        specialPrint(triangle);
        ColouredTriangle coloredTriangle = new ColouredTriangle(immutablePoint1 , immutablePoint2 , immutablePoint3 , Colour.GREEN);
        specialPrint(coloredTriangle);

    }
    public static void specialPrint(Object object){
        System.out.println("     *********************     ");
        System.out.println(object.toString());
        System.out.println("     *********************     ");
    }
}
