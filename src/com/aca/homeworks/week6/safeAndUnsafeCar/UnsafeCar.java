package com.aca.homeworks.week6.safeAndUnsafeCar;

public class UnsafeCar implements Car {
    public static void main(String[] args) {
        Car unsafeCar = new UnsafeCar();
        for ( int i = 0 ; i < 10 ; i++){
            final int j = i;
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    unsafeCar.add("Name" + j);
                    unsafeCar.printPassengerNames();

                }
            });
            thread.start();
        }
    }
    private final String[] passengers = new String[6];
    int size = 0;

    @Override
    public void add(String passengerName) {
        if (size >= 6) {
            System.out.println("there is no space left");
        }
        passengers[size++] = passengerName;
    }

    @Override
    public void printPassengerNames() {
        for (int i = 0; i < size; i++) {
            System.out.println(passengers[i]);
        }
    }

}
