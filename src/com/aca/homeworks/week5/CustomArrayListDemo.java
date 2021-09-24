package com.aca.homeworks.week5;

public class CustomArrayListDemo {
    public static void main(String[] args) {
        CustomArrayList<Integer> customArrayList = new CustomArrayList();
        customArrayList.addFirst(7);


        customArrayList.add(5);
        customArrayList.add(9);
        customArrayList.findAndDelete(7);
        System.out.println(customArrayList);






    }
}
