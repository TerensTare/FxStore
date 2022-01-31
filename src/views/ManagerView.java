package views;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import widgets.FlatButton;
import widgets.FlatScene;

public class ManagerView implements View {
    @Override
    public FlatScene view(Stage stage) {
        return new FlatScene(
                "Manager",
                new Scene(
                        new VBox(new FlatButton("Logout")) //
                ) //
        );
    }
}
