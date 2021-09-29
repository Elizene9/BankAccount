import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

/* Charlene Creighton
 * Copyright September 29, 2021,
 * Simulation Bank Account App
 */

// Front Page of Application
public class Menu extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        var scene = new Scene(new Pane());
        ChangeScenes.stageScene(scene);

        // Load front page of application
        ChangeScenes.Change(ViewScenes.Menu);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
