package widgets;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FlatScene {
    private String name;
    private Parent parent;
    private Scene scene;

    public FlatScene(String name, Parent parent) {
        this.name = name;
        this.parent = parent;
        this.scene = new Scene(parent);

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

    public Parent getParent() {
        return parent;
    }

    public void showOn(Stage stage) {
        stage.setScene(scene);
        stage.setTitle(name);
        stage.show();
    }
}