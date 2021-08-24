package com.aca.homeworks.week4.task1;

public class User {
    private String firstName;
    private String lastName;
    private String userName;
    private String email;

    public User(){

    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", userName='" + userName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public User(String firstName, String lastName, String userName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
    }

    public User(User user) {
        this.copy(user);
    }

    private final void copy(User user){
        this.firstName = user.firstName;
        this.lastName = user.lastName;
        this.userName = user.userName;
        this.email = user.email;
    }
}
