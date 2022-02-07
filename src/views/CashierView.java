package views;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import widgets.FlatButton;
import widgets.FlatScene;

public class CashierView implements View {
    @Override
    public FlatScene view(Stage stage) {
        return new FlatScene(
                "Cashier",
                new VBox(new FlatButton("Logout")) //
        );
    }
}
