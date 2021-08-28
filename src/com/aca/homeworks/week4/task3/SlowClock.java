package com.aca.homeworks.week4.task3;

public class SlowClock implements Clock {
    @Override
    public void start() {
        int seconds = 0;
        long currentTime = System.currentTimeMillis();
        while(true){
            if(System.currentTimeMillis() - currentTime >= 500){
                System.out.println(++seconds);
            }
        }
    }
}
