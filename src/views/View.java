package views;

import javafx.stage.Stage;
import widgets.FlatScene;

public interface View {
    public abstract FlatScene view(Stage stage);
}
