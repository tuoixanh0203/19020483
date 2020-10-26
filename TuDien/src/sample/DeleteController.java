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

public class DeleteController {
    @FXML
    TextField word;
    @FXML
    Button exit;
    public void SceneToMain(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene scene = new Scene(parent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    public void DeleteW() {
        String w = word.getText();
        Word del = null;
        Controller controller = new Controller();
        for (Word i : controller.dic.getDic()) {
            if (i.getWord_target().equals(w)) {
                del = i;
            }
        }
        controller.dic.getDic().remove(del);
        try {
            controller.dicMan.dictionaryExportToFile();
        } catch (IOException exception) {
            exception.getStackTrace();
        }
    }
}
