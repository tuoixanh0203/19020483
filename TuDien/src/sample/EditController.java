package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class EditController {
    @FXML
    TextField editW;
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

    public void EditW() {
        Controller controller = new Controller();
        Word w = new Word(e.getText(), v.getText());
        int cnt = 0, index = 0;
        for (Word i : controller.dic.getDic()) {
            cnt ++;
            if (i.getWord_target().equals(editW.getText())) {
                index = cnt - 1;
            }
        }
        controller.dic.getDic().set(index, w);
        try {
            controller.dicMan.dictionaryExportToFile();
        } catch (IOException exception) {
            exception.getStackTrace();
        }
        System.out.println("Đã sửa");
    }
}
