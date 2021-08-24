package com.aca.homeworks.week4.task1;

public class UserGroup implements Cloneable {
    public static final int MAX_LENGTH = 10;
    private User[] users;
    private int size;

    public UserGroup(User[] arr) {
        if (arr.length > MAX_LENGTH) {
            throw new IllegalArgumentException("Input array length must not be greater than " + MAX_LENGTH);
        }
        this.users = new User[MAX_LENGTH];
        for (int i = 0; i < arr.length; i++) {
            this.users[i] = new User(arr[i]);
        }
        size = arr.length;
    }

    public void addUser(User user) {
        if (size > MAX_LENGTH) {
            System.out.println("users array is full");
            return;
        }
        users[size++] = user;
    }

    @Override
    public UserGroup clone() throws CloneNotSupportedException {
        int length = this.size;
        UserGroup userGroup = (UserGroup) super.clone();
        userGroup.users = new User[length];
        for (int i = 0; i < length; i++) {
            userGroup.users[i] = new User(users[i]);
        }
        return userGroup;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("users = ");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(users[i].toString());
        }
        stringBuilder.append(" , size = ").append(size);
        return stringBuilder.toString();
    }
}
