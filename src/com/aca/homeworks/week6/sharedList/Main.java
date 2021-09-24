package com.aca.homeworks.week6.sharedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        List<Integer> sharedList = Collections.synchronizedList(new ArrayList<Integer>());
        for (int i = 0; i < 100; i++) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {

                    for (int j = 1; j <= 500; j++) {
                        synchronized (sharedList) {
                            sharedList.add(j);

                        }

                    }
                }
            });
            thread.start();

        }
        Thread.sleep(2000);
        System.out.println(sharedList.size());
    }

}


