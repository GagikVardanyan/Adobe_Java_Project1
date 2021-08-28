package com.aca.homeworks.week4.task3;

public class ArmProcessor implements Procesor{
    @Override
    public String calculateBinary(long decimal) {
        long currentTime = System.currentTimeMillis();
        while(System.currentTimeMillis() - currentTime <= 1000){
        }
        return Long.toBinaryString(decimal);
    }
}
