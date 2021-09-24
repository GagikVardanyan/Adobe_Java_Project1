package com.aca.homeworks.week6;

import java.io.File;

public class RunnableImplDemo {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Karen\\Desktop\\file.txt");
        Thread thread = new Thread(new RunnableImpl(file));
        thread.start();
        for(int i = 0 ; i < 10 ; i++){
            File currentFile = new File("C:\\Users\\Karen\\Desktop\\file" + i + ".txt" );
            new Thread(new RunnableImpl(currentFile)).start();
        }

    }
}
