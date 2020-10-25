package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import org.controlsfx.control.textfield.TextFields;

import java.io.IOException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Scanner;

public class Controller implements Initializable {
    @FXML
    private TextField search;

    @FXML
    private TextArea wordV;

    @FXML
    private TextField editEnglish;

    @FXML
    private TextField AddDeleteE;

    @FXML
    private TextField VN;


    private static Dictionary dic = new Dictionary();
    private static DictionaryManagement dicMan = new DictionaryManagement();

    static {
        try {
            dic = dicMan.insertFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < dic.getDic().size(); i++) {
            list.add(dic.getDic().get(i).getWord_target());
        }
        TextFields.bindAutoCompletion(search, list);
    }

    // tra từ
    /*public void Scene1(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("sample/Word.fxml"));
        Parent parent = null;
        try {
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(parent);
        stage.setScene(scene);
    }*/

    //thêm từ
    /*public void Scene2(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getClassLoader().getResource("sample/Word.fxml"));
        Parent parent = null;
        try {
            parent = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(parent);
        stage.setScene(scene);
    }*/

    //sửa từ
    public void Scene3() {

    }

    //xóa từ
    public void Scene4() {

    }

    public void findWord(KeyEvent e) {
        if (e.getCode() == KeyCode.ENTER) {
            for (Word i : dic.getDic()) {
                if (i.getWord_target().equals(search.getText())) {
                    search.setText(i.getWord_explain());
                }
            }
        }
    }

    public void AddWord() {
        String e = AddDeleteE.getText();
        String v = VN.getText();
        dic.getDic().add(new Word(e, v));
        try {
            dicMan.dictionaryExportToFile();
        } catch (IOException exception) {
            exception.getStackTrace();
        }
        System.out.println("đã thêm!");
    }

    public void DeleteWord() {
        String english = AddDeleteE.getText();
        Word word = null;
        for (Word i : dic.getDic()) {
            if (i.getWord_target().equals(english)) {
                word = i;
            }
        }
        dic.getDic().remove(word);
        try {
            dicMan.dictionaryExportToFile();
        } catch (IOException exception) {
            exception.getStackTrace();
        }
        System.out.println("Đã xóa");
    }

    public void EditWord() {
        String english = editEnglish.getText();
        String e = AddDeleteE.getText();
        String v = VN.getText();
        Word w = new Word(e, v);
        int cnt = 0, index = 0;
        for (Word i : dic.getDic()) {
            cnt ++;
            if (i.getWord_target().equals(english)) {
                index = cnt - 1;
            }
        }
        dic.getDic().set(index, w);
        try {
            dicMan.dictionaryExportToFile();
        } catch (IOException exception) {
            exception.getStackTrace();
        }
        System.out.println("Đã sửa");
    }
}
