package ctrl;

import java.util.ArrayList;
import java.util.Arrays;

import models.User;

public class UserController {
    private static UserController instance = new UserController();

    private ArrayList<User> users = new ArrayList<>(
            Arrays.asList(new User("Admin", "Admin", "cadmin123", User.ADMIN)) //
    );

    private UserController() {
    }

    public static boolean valid(String name, String surname, String password) {
        return instance.users.stream()
                .anyMatch(u -> {
                    return u.getName().equals(name)
                            && u.getSurname().equals(surname)
                            && u.hasPass(password);
                });
    }

    public static int roleOf(String name, String surname) {
        return instance.users.stream()
                .filter(u -> {
                    return u.getName().equals(name)
                            && u.getSurname().equals(surname);
                })
                .findFirst()
                .get()
                .getRole();
    }
}
