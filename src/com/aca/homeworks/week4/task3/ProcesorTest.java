package com.aca.homeworks.week4.task3;

public class ProcesorTest {
    public static void main(String[] args) {
        Procesor procesor1 = new X86IntelProcessor();
        System.out.println(procesor1.calculateBinary(25884721));
        procesor1 = new X8664IntelProcessor();
        System.out.println(procesor1.calculateBinary(25884721));
        procesor1 = new ArmProcessor();
        System.out.println(procesor1.calculateBinary(25884721));

    }
}
