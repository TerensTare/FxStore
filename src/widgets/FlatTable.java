package widgets;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class FlatTable<T> extends TableView<T> {
    public FlatTable(String... columns) {
        super();

        for (String col : columns) {
            TableColumn<T, String> column = new TableColumn<>(col);
            column.setCellValueFactory(
                    new PropertyValueFactory<>(col) //
            );

            getColumns().add(column);
        }
    }
}
