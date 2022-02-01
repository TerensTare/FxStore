package views;

import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import widgets.FlatButton;
import widgets.FlatScene;

public class ManagerView implements View {
    @Override
    public FlatScene view(Stage stage) {
        return new FlatScene(
                "Manager",
                new VBox(
                        new MenuBar(
                                new Menu("File"),
                                new Menu("Edit"),
                                new Menu("Help") //
                        ),
                        new FlatButton("Logout") //
                ) //
        );
    }
}
