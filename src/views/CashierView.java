package views;

import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import widgets.FlatButton;
import widgets.FlatScene;

public class CashierView implements View {
    @Override
    public FlatScene view(Stage stage) {
        return new FlatScene(
                "Cashier",
                new Scene(
                        new VBox(new FlatButton("Logout")) //
                ) //
        );
    }
}
