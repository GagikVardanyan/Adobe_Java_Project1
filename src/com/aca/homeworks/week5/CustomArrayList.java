package com.aca.homeworks.week5;

import java.util.Arrays;

public class CustomArrayList<T extends Comparable<T>> {
    private final static int MAX_CAPACITY = 1000;
    private final static int DEFAULT_INITIAL_CAPACITY = 16;


    private int size;
    private Object[] obj;

    public CustomArrayList() {
        this(DEFAULT_INITIAL_CAPACITY);
    }

    public CustomArrayList(int capacity) {
        if (capacity > MAX_CAPACITY || capacity < 0) {
            throw new IllegalArgumentException("Illegal array capacity");
        }
        obj = new Object[capacity];
        size = 0;
    }

    private void ensureCapacity() {

        if (size >= obj.length) {
            int capacity = Math.min((obj.length * 3) / 2, MAX_CAPACITY);
            Object[] newObjects = new Object[capacity];
            System.arraycopy(obj, 0, newObjects, 0, obj.length);
            obj = newObjects;
        }
    }

    private boolean isArrayFull() {
        if (size == MAX_CAPACITY) {
            System.out.println("ArrayList is full");
            return true;
        }
        return false;
    }

    public boolean addFirst(T object) {
        if (isArrayFull()) {
            return false;
        }
        ensureCapacity();
        if (size < obj.length) {
            size++;
        }
        Object[] objects = new Object[obj.length];
        objects[0] = object;
        for (int i = 1; i < size; i++) {
            objects[i] = obj[i - 1];
        }
        obj = objects;
        return true;
    }

    public boolean add(T object, int index) {
        if (index > size) {
            throw new IllegalArgumentException("Wrong Input");
        }
        if (isArrayFull()) {
            return false;
        }
        ensureCapacity();
        size++;
        Object[] objects = new Object[obj.length];
        for (int i = 0; i < index; i++) {
            objects[i] = obj[i];
        }
        objects[index] = object;
        for (int i = index + 1; i < size; i++) {
            objects[i] = obj[i - 1];
        }
        obj = objects;
        return true;
    }


    /**
     * Adds the specified object to the end of the list.
     *
     * @param object specified object to be added at the end of list
     */
    public boolean add(T object) {
        if (isArrayFull()) {
            return false;
        }
        ensureCapacity();
        Object[] objects = new Object[obj.length];
        objects[size] = object;
        for (int i = 0; i < size; i++) {
            objects[i] = obj[i];
        }
        size++;
        obj = objects;
        return true;
    }

    public void findAndDelete(T object) {
        if (size == 0) {
            System.out.println("ArrayList is Empty");
            return;
        }

        Object[] objects = new Object[obj.length];
        int i = indexOf(object);
        if (i == -1) {
            System.out.println("There is no such object");
            return;
        }

        boolean a = false;
        for (int k = 0; k < i; k++) {
            objects[k] = obj[k];
        }

        for (int j = i; j < size; j++) {
            objects[j] = obj[j + 1];
        }
        obj = objects;
        return;
    }

    public void removeByGivenIndex(int index) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("Wrong Input");
        }
        Object[] objects = new Object[size - 1];
        for (int i = 0; i < index; i++) {
            objects[i] = obj[i];
        }
        for (int j = index + 1; j < size; j++) {
            objects[j - 1] = obj[j];
        }
        size--;
        obj = objects;
        return;
    }

    public int indexOf(T object) {
        for (int i = 0; i < size; i++) {
            if (obj[i] == object) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        return "CustomArrayList{" +
                "size=" + size +
                ", obj=" + Arrays.toString(obj) +
                '}';
    }

    public void quickSortIterative() {
        long startTime = System.currentTimeMillis();
        int l = 0;
        int h = size - 1;
        int[] stack = new int[h - l + 1];

        int top = -1;

        // push initial values of l and h to stack
        stack[++top] = l;
        stack[++top] = h;

        // Keep popping from stack while is not empty
        while (top >= 0) {
            h = stack[top--];
            l = stack[top--];

            // Set pivot element at its correct position
            // in sorted array
            int p = partition(obj, l, h);

            // If there are elements on left side of pivot,
            // then push left side to stack
            if (p - 1 > l) {
                stack[++top] = l;
                stack[++top] = p - 1;
            }

            // If there are elements on right side of pivot,
            // then push right side to stack
            if (p + 1 < h) {
                stack[++top] = p + 1;
                stack[++top] = h;
            }
        }
        System.out.println((System.currentTimeMillis() - startTime) + " milli seconds quickSortIterative execution");
    }

    //O(n)
    public int partition(Object[] arr, int start, int end) {
        T pivot = (T) arr[end];
        int pivotIndex = start;

        for (int i = start; i < end; i++) {
            SortClass<T> s = new SortClass<T>();

            if (s.compare((T) arr[i], pivot) < 0) {
                swap(i, pivotIndex);
                pivotIndex++;
            }
        }
        swap(end, pivotIndex);
        return pivotIndex;
    }


    private void swap(int i, int j) {
        Object temp = obj[i];
        obj[i] = obj[j];
        obj[j] = temp;
    }


    public void quickSortInPlace(T[] obj, int a, int b) {
        if (a >= b)
            return; // subarray is trivially sorted
        int left = a;
        int right = b - 1;
        T pivot = obj[b]; // using last as arbitrary pivot
        T temp; // temp object used for swapping
        SortClass<T> s = new SortClass<T>();

        while (left <= right) {
            // scan until reaching value equal or larger than pivot (or right marker)
            while (left <= right && s.compare(obj[left], pivot) < 0)
                left++;
            // scan until reaching value equal or smaller than pivot (or left marker)
            while (left <= right && s.compare(obj[right], pivot) > 0)
                right--;
            if (left <= right) { // indices did not strictly cross
                // so swap values and shrink range
                temp = obj[left];
                obj[left] = obj[right];
                obj[right] = temp;
                left++;
                right--;
            }
        } // put pivot into its final place (currently marked by left index)
        temp = obj[left];
        obj[left] = obj[b];
        obj[b] = temp;
        // make recursive calls quickSortInPlace(S, a, left - 1);
        quickSortInPlace(obj, left + 1, b);
    }

    public void bubbleSort() {

        long startTime = System.currentTimeMillis();

        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                SortClass<T> s = new SortClass<T>();
                if (s.compare((T) obj[j], (T) obj[i]) < 0) {
                    swap(i, j);
                }
            }
        }

        System.out.println((System.currentTimeMillis() - startTime) + " milli seconds bubbleSort execution");

    }

}


