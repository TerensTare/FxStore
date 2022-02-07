import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import views.AdminView;
import views.LoginView;
import widgets.FlatScene;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    // bill number format
    // 22010111
    // 22-01-01,11:11

    @Override
    public void start(Stage stage) {
        stage.setResizable(false);
        stage.setWidth(800);
        stage.setHeight(600);
        stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent arg0) {
                System.exit(0);
            }
        });

        // FlatScene view = new LoginView().view(stage);
        FlatScene view = new AdminView().view(stage);
        view.showOn(stage);
    }
}
