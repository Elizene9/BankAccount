/* Charlene Creighton
 * Copyright October 13, 2021,
 * Simulation Bank Account App
 */

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

// This class loads another scene simultaneously to another
public class MultipleScenes {

    // Gets filename from another class and loads that file on a "substage"
    MultipleScenes(ViewScenes name) throws IOException {

        Stage sub = new Stage();
        Parent root = FXMLLoader.load(Objects.requireNonNull(ChangeScenes.class.getResource(name.getFile())));
        Scene scene = new Scene(root);
        sub.setScene(scene);
        sub.show();
    }
}
