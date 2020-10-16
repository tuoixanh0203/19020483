package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Controller {
    @FXML
    private TextArea wordE;

    @FXML
    private TextArea wordV;

    private static Dictionary dic = new Dictionary();
    private static DictionaryManagement dicMan = new DictionaryManagement();

    static {
        try {
            dic = dicMan.insertFromFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void show() {
        ArrayList<Word> list = dic.getDic();
        String english = "";
        String vietnamese = "";
        /*for (Word i : list) {
            english += i.getWord_target() + "\n";
            vietnamese += i.getWord_explain() + "\n";
        }*/
        for (int i = 0; i < list.size(); i++) {
            english += (i + 1) + ". " + list.get(i).getWord_target() + "\n";
            vietnamese += (i + 1) + ". " + list.get(i).getWord_explain() + "\n";
        }
        wordE.setText(english);
        wordV.setText(vietnamese);
    }
}
