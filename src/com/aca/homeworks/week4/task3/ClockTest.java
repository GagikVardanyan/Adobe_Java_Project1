package com.aca.homeworks.week4.task3;

import java.util.Scanner;

public class ClockTest {
    public static void main(String[] args) {
        Clock clock;
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        if (num == 1) {
            clock = new FastClock();
            clock.start();
        } else if (num == 2) {
            clock = new SlowClock();
            clock.start();
        } else {
            throw new RuntimeException();
        }
    }
}
