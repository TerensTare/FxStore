package widgets;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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

        focusedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean oldValue, Boolean newValue) {
                if (newValue == false) {
                    if (!getText().matches(pattern)) {
                        setStyle("-fx-background-color: #f55050");
                    } else {
                        setStyle("-fx-background-color: transparent");
                    }
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