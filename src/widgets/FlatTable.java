package widgets;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.StringConverter;
import javafx.util.converter.DefaultStringConverter;

public class FlatTable<T> extends TableView<T> {
    public FlatTable(String... columns) {
        super();
        setEditable(true);

        for (String col : columns) {
            TableColumn<T, String> column = new TableColumn<>(col);
            column.setCellValueFactory(
                    new PropertyValueFactory<>(col) //
            );
            column.setCellFactory(TextFieldTableCell.forTableColumn());

            getColumns().add(column);
        }
    }

    public FlatTable() {
        super();
        setEditable(true);
    }

    public <U> FlatTable<T> withColumn(String name, StringConverter<U> conv) {
        TableColumn<T, U> column = new TableColumn<>(name);

        String prop = name.toLowerCase();
        column.setCellValueFactory(
                new PropertyValueFactory<>(prop) //
        );
        column.setCellFactory(TextFieldTableCell.forTableColumn(conv));

        getColumns().add(column);
        return this;
    }

    public <U> FlatTable<T> withColumn(String name) {
        return withColumn(name, new DefaultStringConverter());
    }

    public FlatTable<T> withStrColumn(String name) {
        return withColumn(name, new DefaultStringConverter());
    }

    public FlatTable<T> bindWith(ObservableList<T> list) {
        setItems(list);
        return this;
    }
}
