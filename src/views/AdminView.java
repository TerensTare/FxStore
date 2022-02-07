package views;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TabPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import widgets.FlatScene;

// TODO(maybe):
// convert check menu items to normal menu items
// which just focus the corresponding tab when clicked

public class AdminView implements View {
    @Override
    public FlatScene view(Stage stage) {
        TabPane tabs = new TabPane();

        CheckMenuItem users = new CheckMenuItem("Users");
        FlatScene usersView = new UsersView().view(stage);

        users.selectedProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable arg0) {
                if (users.isSelected()) {
                    tabs.getTabs().add(usersView.getTab());
                } else {
                    tabs.getTabs().remove(0);
                }
            }
        });

        CheckMenuItem stock = new CheckMenuItem("Stock");
        // FlatScene stockView = new StockView().view(stage);

        stock.selectedProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable arg0) {
                // if (stock.isSelected()) {
                // FlatScene stockView = new StockView().view(stage);
                // tabs.getTabs().add(stockView.getTab());
                // } else {
                // tabs.getTabs().remove(0);
                // }
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
                new VBox(menuBar, tabs) //
        );
    }
}
