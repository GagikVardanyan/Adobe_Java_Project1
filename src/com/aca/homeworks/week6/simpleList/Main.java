package com.aca.homeworks.week6.simpleList;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        SimpleList<Integer> unsafeList = new UnsafeSimpleList<>();
        SimpleList<Integer> safeList = new SafeSimpleList<Integer>();
        for(int i = 0 ; i < 20 ; i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int i = 0 ; i < 500 ; i++){
                        safeList.add(i);
                        safeList.get(i);
                        unsafeList.add(i);
                        unsafeList.get(i);
                    }
                }
            });
            thread.start();


        }
        Thread.sleep(4000);
        System.out.println(safeList.getSize());
        System.out.println(unsafeList.getSize());


    }
}
