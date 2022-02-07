package views;

import javafx.event.EventHandler;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
// local imports
import control.UserController;
import models.User;
import widgets.FlatButton;
import widgets.FlatDatePicker;
import widgets.FlatPasswordField;
import widgets.FlatScene;
import widgets.FlatTextField;

public class RegisterView implements View {
    private FlatTextField name;
    private FlatTextField surname;
    private FlatPasswordField password;
    private FlatDatePicker birthday;
    private FlatTextField phone;
    private FlatTextField email;
    private FlatTextField salary;
    private ComboBox<User.Role> role;
    private FlatButton register;

    private FlatScene scene;

    public RegisterView() {
        name = FlatTextField.withHint("Name").mustMatch("[A-Z][a-zA-Z]+");
        surname = FlatTextField.withHint("Surname").mustMatch("[A-Z][a-zA-Z]+");
        password = FlatPasswordField.withHint("Password").mustMatch("[a-zA-Z0-9]{8,}");
        birthday = FlatDatePicker.withHint("Birthday");
        phone = FlatTextField.withHint("Phone").mustMatch("+3556[7-9][0-9]{7}");
        email = FlatTextField.withHint("Email").mustMatch("[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+");
        salary = FlatTextField.withHint("Salary").mustMatch("[0-9]+");

        role = new ComboBox<>();
        role.getItems().addAll(User.Role.CASHIER, User.Role.MANAGER);

        register = new FlatButton("Register");
        register.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent arg0) {
                if (isValid()) {
                    int salary = 0;

                    try {
                        salary = Integer.parseInt(RegisterView.this.salary.getText());
                    } catch (NumberFormatException e) {
                        e.printStackTrace();
                    }

                    try {
                        UserController.register(
                                name.getText(),
                                surname.getText(),
                                password.getText(),
                                birthday.getValue(),
                                phone.getText(),
                                email.getText(),
                                salary,
                                User.Role.CASHIER // TODO: change this
                        );
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        scene = new FlatScene(
                "Register",
                new VBox(
                        name,
                        surname,
                        password,
                        birthday,
                        phone,
                        email,
                        salary,
                        register //
                ) //
        );
    }

    @Override
    public FlatScene view(Stage stage) {
        return scene;
    }

    private boolean isValid() {
        return name.isValid() &&
                surname.isValid() &&
                password.isValid() &&
                phone.isValid() &&
                email.isValid() &&
                salary.isValid();
    }
}