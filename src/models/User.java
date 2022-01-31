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
}
