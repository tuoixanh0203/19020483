package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class FindController {
    @FXML
    public TextArea e;

    @FXML
    public TextArea v;

    public void SceneToMain(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(getClass().getResource("Main.fxml"));
        Scene scene = new Scene(parent);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    public void Speak(ActionEvent event) throws FileNotFoundException, UnsupportedEncodingException {
        ReadWordFromFile();
        try {
            Runtime.getRuntime().exec( "wscript computer_gender.vbs" );
        }
        catch( IOException e ) {
            System.out.println(e);
            System.exit(0);
        }
    }

    public void ReadWordFromFile() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter printWriter = new PrintWriter("computer_gender.vbs", "UTF-8");
        printWriter.append("CreateObject(\"SAPI.SpVoice\").Speak(\"" + e.getText() + "\")");
        printWriter.close();
    }
}
