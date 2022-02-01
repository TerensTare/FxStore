package views;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
// local imports
import models.User;
import widgets.FlatButton;
import widgets.FlatScene;
import widgets.FlatTable;
import widgets.FlatTextField;

public class UsersView implements View {
    @Override
    public FlatScene view(Stage stage) {
        FlatTable<User> table = new FlatTable<>(
                "Name",
                "Surname",
                "" //
        );
        table.setEditable(true);

        FlatButton add = new FlatButton("Add");
        add.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                // TODO:
                // add a view that allows to add a new user
                // add more fields here
                VBox vbox = new VBox(
                        FlatTextField.withHint("Name").mustMatch("[A-Z][a-zA-Z]+"),
                        FlatTextField.withHint("Surname").mustMatch("[A-Z][a-zA-Z]+"),
                        FlatTextField.withHint("Password").mustMatch("[a-zA-Z0-9]{8,}") //
                );

                FlatScene scene = new FlatScene("Register", vbox);
                scene.showOn(new Stage());
            }
        });

        return new FlatScene(
                "Users",
                new VBox(table, add) //
        );
    }
}
