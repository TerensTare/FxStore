package views;

import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

// local imports
import models.User;
import ctrl.UserController;
import widgets.FlatButton;
import widgets.FlatCheckBox;
import widgets.FlatErrorText;
import widgets.FlatPasswordField;
import widgets.FlatTextField;
import widgets.FlatScene;

public class LoginView implements View {
    private FlatTextField name;
    private FlatTextField surname;
    private FlatPasswordField password;
    private FlatCheckBox showPassword;
    private FlatButton login;

    public LoginView() {
        name = FlatTextField.withHint("Name").mustMatch("[A-Z][a-zA-Z]+");
        surname = FlatTextField.withHint("Surname").mustMatch("[A-Z][a-zA-Z]+");
        password = FlatPasswordField.withHint("Password").mustMatch("[a-zA-Z0-9]{8,}");

        showPassword = new FlatCheckBox("Show password");
        showPassword.selectedProperty().addListener((obs, old, selected) -> {
            password.setCensored(!selected);
        });

        login = new FlatButton("Login");
    }

    @Override
    public FlatScene view(Stage stage) {

        HBox fullName = new HBox(name, surname);
        fullName.setSpacing(20);

        FlatErrorText error = new FlatErrorText("Invalid credentials");

        login.setOnMouseClicked(e -> {
            if (isValid() && UserController.valid(
                    name.getText(),
                    surname.getText(),
                    password.getText())) {
                error.setVisible(false);

                switch (UserController.roleOf(name.getText(), surname.getText())) {
                    case User.CASHIER:
                        new CashierView().view(stage).showOn(stage);
                        break;

                    case User.ADMIN:
                        new AdminView().view(stage).showOn(stage);
                        break;

                    case User.MANAGER:
                        new ManagerView().view(stage).showOn(stage);
                        break;
                }
            } else {
                error.setVisible(true);
            }
        });

        VBox root = new VBox(
                fullName,
                password.widget(),
                showPassword,
                login,
                error //
        );

        return new FlatScene(
            "Login",
            new Scene(root) //
        );
    }

    private boolean isValid() {
        return name.isValid() && surname.isValid() && password.isValid();
    }
}