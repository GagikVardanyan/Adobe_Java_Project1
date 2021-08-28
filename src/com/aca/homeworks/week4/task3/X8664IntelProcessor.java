package com.aca.homeworks.week4.task3;

public class X8664IntelProcessor implements Procesor {
    @Override
    public String calculateBinary(long decimal) {
        long currentTime = System.currentTimeMillis();
        while (System.currentTimeMillis() - currentTime <= 2000) {
        }
        return Long.toBinaryString(decimal);
    }

}
