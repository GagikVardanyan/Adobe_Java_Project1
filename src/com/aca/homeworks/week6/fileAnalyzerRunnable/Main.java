package com.aca.homeworks.week6.fileAnalyzerRunnable;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>(){{add("random 1"); add("random 2"); add("random 3"); add("random 4");}};
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10; i++) {
                    BufferedReader bufferedReader = null;
                    try {
                        bufferedReader = new BufferedReader(new FileReader("C:\\Users\\Karen\\Desktop\\file" + i + ".txt"));
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                    if (bufferedReader != null) {
                        List<String> collect = bufferedReader
                                .lines()
                                .filter(line -> {
                                    for (String s : list) {
                                        if (line.equals(s)) {
                                            return true;
                                        }
                                    }
                                    return false;
                                } )
                                .distinct().collect(Collectors.toList());
                        for (String s : collect) {
                            System.out.println("file " + i + " contains " + s);
                        }
                    } else {
                        throw new NullPointerException();
                    }
                }
            }
        });
        thread1.start();
    }
}
