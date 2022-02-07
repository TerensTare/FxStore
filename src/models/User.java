package models;

import java.io.Serializable;
import java.time.LocalDate;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.Property;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User implements Serializable {

    public enum Role {
        CASHIER,
        MANAGER,
        ADMIN
    }

    private StringProperty name;
    private StringProperty surname;
    private StringProperty pass;
    private ObjectProperty<LocalDate> birthday;
    private StringProperty phone;
    private StringProperty email;
    private IntegerProperty salary;
    private ObjectProperty<Role> role;

    public User(String name, String surname, String pass, LocalDate birthday, String phone, String email, int salary, Role role) {
        this.name = new SimpleStringProperty(name);
        this.surname = new SimpleStringProperty(surname);
        this.pass = new SimpleStringProperty(pass);
        this.birthday = new SimpleObjectProperty<LocalDate>(birthday);
        this.phone = new SimpleStringProperty(phone);
        this.email = new SimpleStringProperty(email);
        this.salary = new SimpleIntegerProperty(salary);
        this.role = new SimpleObjectProperty<Role>(role);
    }

    public StringProperty nameProperty() {
        return name;
    }

    public StringProperty surnameProperty() {
        return surname;
    }

    public StringProperty passProperty() {
        return pass;
    }

    public ObjectProperty<LocalDate> birthdayProperty() {
        return birthday;
    }

    public StringProperty phoneProperty() {
        return phone;
    }

    public StringProperty emailProperty() {
        return email;
    }

    public IntegerProperty salaryProperty() {
        return salary;
    }

    public ObjectProperty<Role> roleProperty() {
        return role;
    }

    public boolean hasPass(String pass) {
        return this.pass.get().equals(pass);
    }
}
