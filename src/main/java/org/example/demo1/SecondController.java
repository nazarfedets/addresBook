package org.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SecondController {
    @FXML private Button cancelbtn;

    @FXML
    private void cancelButton(){
        Stage backWindow = (Stage) cancelbtn.getScene().getWindow();
        backWindow.close();
    }
}
