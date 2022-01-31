package widgets;

import javafx.scene.control.CheckBox;

public class FlatCheckBox extends CheckBox {
    public FlatCheckBox(String hint) {
        super();
        getStyleClass().add("flat-check-box");
        setText(hint);
    }
}
