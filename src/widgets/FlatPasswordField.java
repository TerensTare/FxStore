package widgets;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.PasswordField;
import javafx.scene.control.skin.TextFieldSkin;

class FlatPasswordFieldSkin extends TextFieldSkin {
    public FlatPasswordFieldSkin(PasswordField passwordField) {
        super(passwordField);
    }

    @Override
    protected String maskText(String text) {
        FlatPasswordField widget = (FlatPasswordField) getSkinnable();

        if (widget.isCensored()) {
            if (text != null) {
                int n = text.length();
                StringBuilder sb = new StringBuilder(n);
                for (int i = 0; i < n; i++) {
                    sb.append('\u2022');
                }

                return sb.toString();
            } else {
                return "";
            }
        } else {
            return text;
        }
    }

    public void remask() {
        FlatPasswordField widget = (FlatPasswordField) getSkinnable();
        String text = widget.getText();
        widget.setText(null);
        widget.setText(text);
    }
}

public class FlatPasswordField extends PasswordField {
    private boolean censored = true;
    private String match = "*";

    public FlatPasswordField() {
        super();
        getStyleClass().add("flat-text-field");
        setSkin(new FlatPasswordFieldSkin(this));
    }

    public static FlatPasswordField withHint(String hint) {
        FlatPasswordField field = new FlatPasswordField();
        field.setPromptText(hint);
        return field;
    }

    public void setCensored(boolean censored) {
        this.censored = censored;
        ((FlatPasswordFieldSkin) getSkin()).remask();
    }

    public boolean isCensored() {
        return censored;
    }

    public FlatPasswordField mustMatch(String pattern) {
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