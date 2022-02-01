package views;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import widgets.FlatButton;
import widgets.FlatScene;

public class AdminView implements View {
    private BooleanProperty hasTabPane = new SimpleBooleanProperty(false);

    @Override
    public FlatScene view(Stage stage) {
        CheckMenuItem users = new CheckMenuItem("Users");
        CheckMenuItem stock = new CheckMenuItem("Stock");

        VBox vbox = new VBox();

        hasTabPane.bind(
                users.selectedProperty() //
                        .and(stock.selectedProperty()) //
        );

        hasTabPane.addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> obs, Boolean old, Boolean current) {
                TabPane pane = new TabPane();
                pane.getTabs().addAll(
                // new UsersView().view(stage),
                // new StockView().view(stage)
                );

                vbox.getChildren().add(pane);
            }
        });

        // MenuItem products = new MenuItem("Products");
        // MenuItem categories = new MenuItem("Categories");
        // MenuItem orders = new MenuItem("Orders");

        Menu view = new Menu("View");
        view.getItems().addAll(users, stock);

        Menu user = new Menu("User"); // manage personal data
        user.getItems().addAll(
        // TODO:
        // add profile picture + more options
        // new MenuItem(""),
        // new MenuItem("Change role") //
        );

        MenuBar menuBar = new MenuBar(view, user);

        return new FlatScene(
                "Manager",
                new VBox(menuBar, new FlatButton("Hi")) //
        );
    }
}
