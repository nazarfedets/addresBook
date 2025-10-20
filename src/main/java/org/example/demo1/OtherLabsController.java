package org.example.demo1;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class OtherLabsController {
    @FXML private ImageView imageView;
    @FXML private Button yesBtn;
    @FXML private Label text;

    Image image = new Image(getClass().getResourceAsStream("/imagen/images2.jpg"));

    @FXML
    private void changeLable(ActionEvent event) {
        imageView.setImage(image);
        text.setText("Ви успішно змінили фото");
        yesBtn.setDisable(true);
    }


}
