package sample;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.TextFields;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    private TextField search;
    public static Dictionary dic = new Dictionary();
    public static DictionaryManagement dicMan = new DictionaryManagement();

    static {
        try {
            dic = dicMan.insertFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void SceneToFind(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("sample/Find.fxml"));
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent parent = null;
        try {
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(parent);
        FindController f = loader.getController();
        for (Word i : dic.getDic()) {
            if (i.getWord_target().equals(search.getText())) {
                f.e.setText(i.getWord_target());
                f.v.setText(i.getWord_explain());
            }
        }
        window.setScene(scene);
    }

    public void SceneToAdd(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("sample/Add.fxml"));
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent parent = null;
        try {
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(parent);
        window.setScene(scene);
    }

    public void SceneToEdit(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("sample/Edit.fxml"));
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent parent = null;
        try {
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(parent);
        window.setScene(scene);
    }

    public void SceneToDelete(ActionEvent event) {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("sample/Delete.fxml"));
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Parent parent = null;
        try {
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Scene scene = new Scene(parent);
        window.setScene(scene);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < dic.getDic().size(); i++) {
            list.add(dic.getDic().get(i).getWord_target());
        }
        TextFields.bindAutoCompletion(search, list);
    }
}
