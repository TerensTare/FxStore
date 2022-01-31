package widgets;

import javafx.scene.text.Text;

public class FlatErrorText extends Text {
    public FlatErrorText(String message) {
        super(message);
        getStyleClass().add("flat-error-text");
        setVisible(false);
    }
}
