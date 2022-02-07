package control;

import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Stream;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
// local imports
import models.User;

public class UserController implements Closeable {
    private static String fileName = "users.ser";
    private static UserController instance;

    private ObservableList<User> users;

    static {
        try {
            instance = new UserController();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private UserController() throws IOException, ClassNotFoundException {
        {
            File file = new File(fileName);
            file.createNewFile();
        }

        users = FXCollections.observableArrayList(
                new User(
                        "Terens", "Tare", "cadmin123",
                        LocalDate.of(2002, 10, 21),
                        "+355691234567",
                        "ttare20@epoka.edu.al", 0,
                        User.Role.ADMIN //
                ) //
        );

        try (FileInputStream fs = new FileInputStream(fileName);
                ObjectInputStream os = new ObjectInputStream(fs)) {
            ArrayList<User> tmp = (ArrayList<User>) os.readObject();
            users.addAll(tmp);
        } catch (EOFException e) {
            // do nothing
        }
    }

    public static void register(
            String name, String surname,
            String password, LocalDate birthday,
            String phone, String email,
            int salary, User.Role role) throws IOException {
        instance.users.add(
                new User(name, surname, password, birthday, phone, email, salary, role) //
        );
    }

    public static Stream<User> stream() {
        return instance.users.stream();
    }

    public static ObservableList<User> list() {
        return instance.users;
    }

    public static boolean valid(String name, String surname, String password) {
        return instance.users.stream()
                .anyMatch(new Predicate<User>() {
                    @Override
                    public boolean test(User u) {
                        return u.nameProperty().equals(name)
                                && u.surnameProperty().equals(surname)
                                && u.hasPass(password);
                    }
                });
    }

    public static User.Role roleOf(String name, String surname) {
        return instance.users.stream()
                .filter(new Predicate<User>() {
                    @Override
                    public boolean test(User u) {
                        return u.nameProperty().equals(name)
                                && u.surnameProperty().equals(surname);
                    }
                })
                .findFirst()
                .get()
                .roleProperty()
                .getValue();
    }

    @Override
    public void close() throws IOException {
        try (FileOutputStream fs = new FileOutputStream(fileName);
                ObjectOutputStream writer = new ObjectOutputStream(fs)) {
            users.remove(0); // do not save admin
            writer.writeObject(users);
        }
    }

}
