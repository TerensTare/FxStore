package widgets;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.StackPane;

public class FlatPasswordField extends PasswordField {
    private FlatTextField text;
    private StackPane pane;
    private String match = "*";

    public FlatPasswordField(String hint) {
        super();
        getStyleClass().add("flat-text-field");
        setPromptText(hint);

        text = new FlatTextField(hint);
        text.textProperty().bindBidirectional(textProperty());
        text.setVisible(false);

        pane = new StackPane(this, text);
    }

    public void setCensored(boolean censored) {
        if (censored) {
            setVisible(true);
            text.setVisible(false);
        } else {
            setVisible(false);
            text.setVisible(true);
        }
    }

    public static FlatPasswordField withHint(String hint) {
        return new FlatPasswordField(hint);
    }

    public FlatPasswordField mustMatch(String pattern) {
        match = pattern;

        setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                if (!getText().matches(pattern)) {
                    setStyle("-fx-background-color: #f55050");
                    text.setStyle("-fx-background-color: #f55050");
                } else {
                    setStyle("-fx-background-color: transparent");
                    text.setStyle("-fx-background-color: transparent");
                }
            }
        });

        text.mustMatch(pattern);

        return this;
    }

    public boolean isValid() {
        if (getText().matches(match)) {
            setStyle("-fx-background-color: transparent");
            text.setStyle("-fx-background-color: transparent");
            return true;
        } else {
            setStyle("-fx-background-color: #f55050");
            text.setStyle("-fx-background-color: #f55050");
            return false;
        }
    }

    public StackPane widget() {
        return pane;
    }
}
