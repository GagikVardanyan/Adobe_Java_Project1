package com.aca.homeworks.week6.simpleList;

import java.util.ArrayList;

public class UnsafeSimpleList<T> implements SimpleList<T>{
    private Object [] objects = new Object[10000];
    private int size = 0;
    @Override
    public void add(T o) {
    if(size == 10000){
        throw new RuntimeException("List is full");
    }
    objects[size++] = o;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public T get(int index) {
        if(index > size || index < 0){
            throw new ArrayIndexOutOfBoundsException("no such elements");
        }
        return ((T)objects[index]);
    }
}
