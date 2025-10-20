package org.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

public class HelloController {
    @FXML private Button btnOpen;
    @FXML private Button btnAdd;
    @FXML private Button btnDelete;
    @FXML private Label label;
    @FXML private Button exitbtn;
    @FXML private  Button otherLabs;

    @FXML
    private void openDialog() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Second.fxml"));
            Parent root = fxmlLoader.load();

            Stage stage =new Stage();
            stage.setTitle("Вікно редагування");
            stage.setScene(new Scene(root));

            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(btnOpen.getScene().getWindow());

            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    @FXML
    private void handleDelete() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Видалення запису");
        alert.setHeaderText("Підтвердження видалення");
        alert.setContentText("Ви впевнені, що хочете видалити запис?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            label.setText("Запис видалено!");
        } else {
            label.setText("Видалення відмінено!");
        }

    }

    @FXML
    private void closeWindow() {
        Stage stage = (Stage) exitbtn.getScene().getWindow();
        stage.close();
        System.exit(0);
    }

    @FXML
    private void openOtherLabs() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("other-labs.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Інше вікно — зміна зображення");
            stage.setScene(new Scene(loader.load()));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(otherLabs.getScene().getWindow());
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
