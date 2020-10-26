package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class AddController {
    @FXML
    Button exit;
    @FXML
    TextField e;
    @FXML
    TextField v;
    public void SceneToMain(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene scene = new Scene(parent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    public void AddW() {
        Word word = new Word(e.getText(), v.getText());
        Controller controller = new Controller();
        controller.dic.getDic().add(word);
        try {
            controller.dicMan.dictionaryExportToFile();
        } catch (IOException exception) {
            exception.getStackTrace();
        }
    }
}
