import javafx.application.Application;
import javafx.stage.Stage;
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

        FlatScene loginView = new LoginView().view(stage);
        loginView.showOn(stage);
    }
}
