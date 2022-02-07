package widgets;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javafx.scene.control.DatePicker;
import javafx.util.StringConverter;

public class FlatDatePicker extends DatePicker {
    public FlatDatePicker(String hint) {
        getStyleClass().add("flat-date-picker");

        setPromptText(hint);

        setConverter(new StringConverter<LocalDate>() {
            private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("d/M/yyyy");

            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return fmt.format(date);
                } else {
                    return "";
                }
            }

            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, fmt);
                } else {
                    return null;
                }
            }
        });
    }

    public FlatDatePicker() {
        this("d/M/yyyy");
    }

    public static FlatDatePicker withHint(String hint) {
        return new FlatDatePicker(hint);
    }
}
