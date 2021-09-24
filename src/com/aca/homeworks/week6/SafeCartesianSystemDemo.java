package com.aca.homeworks.week6;

public class SafeCartesianSystemDemo {
    public static void main(String[] args) throws InterruptedException {
        SafeCartesianSystem safeCartesianSystem = new SafeCartesianSystem();
        safeCartesianSystem.setCount(0);

        for ( int i = 0 ; i < 10 ; i++){

            Thread thread = new Thread(new Runnable() {
                @Override
                public   void run() {
                    for (int j = 1 ; j <= 1000 ; j++){
                        safeCartesianSystem.setXY(j , j);
                        safeCartesianSystem.setXY(-j , -j);
                        safeCartesianSystem.increment();
                        System.out.println(safeCartesianSystem.getPoint());
                    }
                }
            });
            thread.start();
        }
        Thread.sleep(1500);

        System.out.println(safeCartesianSystem.getCount());
    }
}
