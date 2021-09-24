package com.aca.homeworks.week6.binaryFile;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

public class BinaryFile {
    public static void main(String[] args) throws IOException {

        File file = new File("C:\\Users\\Karen\\Desktop\\file.txt");
        PrintWriter printWriter = new PrintWriter(file);

        Random random = new Random();
        int n1 = random.nextInt(100);
        int n2 = random.nextInt(100);
        System.out.println(n1 + " " + n2);
        printWriter.println(Integer.toBinaryString(n1));
        printWriter.println(Integer.toBinaryString(n2));
        printWriter.close();

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        String s1 = bufferedReader.readLine();
        System.out.println(s1);
        String s2 = bufferedReader.readLine();
        System.out.println(s2);
        int number1 = Integer.parseInt(s1, 2);
        int number2 = Integer.parseInt(s2, 2);
        System.out.println(number1 + number2);
        bufferedReader.close();


        FileWriter fileWriter1 = new FileWriter(file, true);
        fileWriter1.write(String.valueOf(number1 + number2));
        fileWriter1.close();
    }
}
