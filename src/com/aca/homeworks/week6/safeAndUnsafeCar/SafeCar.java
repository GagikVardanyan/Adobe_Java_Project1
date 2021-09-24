package com.aca.homeworks.week6.safeAndUnsafeCar;

public class SafeCar implements  Car{
    private final String[] passengers = new String[6];
    int size = 0;

    @Override
    public synchronized void add(String passengerName) {
        if (size >= 6) {
            System.out.println("there is no space left");
        }
        passengers[size++] = passengerName;
    }

    @Override
    public synchronized void printPassengerNames() {
        for (int i = 0; i < size; i++) {
            System.out.println(passengers[i]);
        }
    }
}
