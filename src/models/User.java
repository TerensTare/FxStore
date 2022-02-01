package models;

import java.io.Serializable;

public class User implements Serializable {
    public static final transient int CASHIER = 0;
    public static final transient int MANAGER = 1;
    public static final transient int ADMIN = 2;

    private String name;
    private String surname;
    private String pass;
    private int role;

    // public static final transient User Admin = new User("Admin", "Admin", "cadmin123", ADMIN);

    public User(String name, String surname, String pass, int role) {
        this.name = name;
        this.surname = surname;
        this.pass = pass;
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public boolean hasPass(String pass) {
        return this.pass.equals(pass);
    }

    public int getRole() {
        return role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setRole(int role) {
        this.role = role;
    }

}
