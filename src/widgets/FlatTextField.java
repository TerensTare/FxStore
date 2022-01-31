package widgets;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.TextField;

public class FlatTextField extends TextField {
    private String match = "*";

    public FlatTextField(String hint) {
        super();
        getStyleClass().add("flat-text-field");
        setPromptText(hint);
    }

    public static FlatTextField withHint(String hint) {
        return new FlatTextField(hint);
    }

    public FlatTextField mustMatch(String pattern) {
        match = pattern;

        setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                if (!getText().matches(pattern)) {
                    setStyle("-fx-background-color: #f55050");
                } else {
                    setStyle("-fx-background-color: transparent");
                }
            }
        });

        return this;
    }

    public boolean isValid() {
        if (getText().matches(match)) {
            setStyle("-fx-background-color: transparent");
            return true;
        } else {
            setStyle("-fx-background-color: #f55050");
            return false;
        }
    }
}