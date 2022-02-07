package views;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.function.Consumer;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;
// local imports
import control.UserController;
import models.User;
import widgets.FlatButton;
import widgets.FlatScene;
import widgets.FlatTable;

public class UsersView implements View {

    @Override
    public FlatScene view(Stage stage) {
        FlatTable<User> table = new FlatTable<User>()
                // columns
                .withStrColumn("Name")
                .withStrColumn("Surname")
                .<Date>withColumn("Birthday", new DateParser())
                .withStrColumn("Phone")
                .withStrColumn("Email")
                .<Integer>withColumn("Salary", new IntParser()) //
                .<User.Role>withColumn("Role", new RoleParser())
                // data
                .bindWith(UserController.list());

        FlatButton add = new FlatButton("Add");
        add.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent e) {
                Stage newStage = new Stage();

                FlatScene scene = new RegisterView().view(newStage);
                scene.showOn(newStage);
            }
        });

        return new FlatScene(
                "Users",
                new VBox(table, add) //
        );
    }
}

final class IntParser extends StringConverter<Integer> {
    @Override
    public String toString(Integer object) {
        return object.toString();
    }

    @Override
    public Integer fromString(String string) {
        return Integer.parseInt(string);
    }
}

final class RoleParser extends StringConverter<User.Role> {
    @Override
    public String toString(User.Role object) {
        return object.toString();
    }

    @Override
    public User.Role fromString(String string) {
        return User.Role.valueOf(string);
    }
}

final class DateParser extends StringConverter<Date> {
    private static SimpleDateFormat fmt = new SimpleDateFormat("d/M/yyyy");

    @Override
    public String toString(Date object) {
        return fmt.format(object);
    }

    @Override
    public Date fromString(String string) {
        try {
            return fmt.parse(string);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}