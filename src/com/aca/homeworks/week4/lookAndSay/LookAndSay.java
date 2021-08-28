package com.aca.homeworks.week4.lookAndSay;

public class LookAndSay {
    public static long lookAndSayNumber(long number){
        long result = 0;
        int resultLength = 0;
        int count = 1;
        long current = number % 10;
        while(number != 0){
            long temp;
            if((number / 10) % 10 == current){
                count++;
            }else{
                temp = count * 10 + current;
                current = (number / 10) % 10;
                for (int i = 0 ; i < resultLength ; i++){
                    temp *= 10;
                }
                result += temp;
                resultLength += 2;
                count = 1;

            }
            number = number/10;
        }

        return result;
    }
    public static long lookAndSay(int n){
        long[] array = new long[n];
        array[0] = 1;
        for(int i = 1 ; i < n ; i++){
            array[i] = lookAndSayNumber(array[i-1]);
        }
        return array[n-1];
    }

    public static void main(String[] args) {
        System.out.println(lookAndSay(5));



    }
}
