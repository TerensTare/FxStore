package widgets;

import javafx.scene.Scene;
import javafx.stage.Stage;

public class FlatScene {
    private String name;
    private Scene scene;

    public FlatScene(String name, Scene scene) {
        this.name = name;
        this.scene = scene;

        this.scene.getStylesheets().add(
                getClass().getResource("../res/style/flat.css")
                        .toExternalForm());
    }

    public String getName() {
        return name;
    }

    public Scene getScene() {
        return scene;
    }

    public void showOn(Stage stage) {
        stage.setScene(scene);
        stage.setTitle(name);
        stage.show();
    }
}