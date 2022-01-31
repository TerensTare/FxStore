package widgets;

import javafx.scene.Node;
import javafx.scene.control.Button;

public class FlatButton extends Button {
    public FlatButton(String text) {
        super(text.toUpperCase());

        getStyleClass().add("flat-button");
    }

    public FlatButton(Node node) {
        super("", node);

        getStyleClass().add("flat-button");
    }
}
