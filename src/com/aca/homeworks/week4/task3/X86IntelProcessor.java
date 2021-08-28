package com.aca.homeworks.week4.task3;

public class X86IntelProcessor implements Procesor {
    @Override
    public String calculateBinary(long decimal) {
        long currentTime = System.currentTimeMillis();
        while(System.currentTimeMillis() - currentTime <= 4000){
        }
        return Long.toBinaryString(decimal);
    }
}
