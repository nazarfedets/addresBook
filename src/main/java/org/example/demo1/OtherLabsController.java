package org.example.demo1;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class OtherLabsController {
    @FXML private CheckBox cb1;
    @FXML private CheckBox cb2;
    @FXML private CheckBox cb3;
    @FXML private CheckBox cb4;
    @FXML private Label checkBoxResultLabel;
    @FXML private ChoiceBox<String> choiceBox;
    @FXML private Label choiceResultLabel;
    @FXML private ComboBox<String> comboBox;
    @FXML private Label comboBoxResultLabel;
    @FXML private ToggleGroup menuGroup;
    @FXML private Label radioResultLabel;


    @FXML
    private void initialize() {
        choiceBox.getItems().addAll("Так", "Ні");

        comboBox.getItems().addAll(
                "BorderPane",
                "AnchorPane",
                "GridPane",
                "VBox",
                "HBox"
        );

        hideAllResults();
    }

    private void hideAllResults() {
        checkBoxResultLabel.setVisible(false);
        choiceResultLabel.setVisible(false);
        comboBoxResultLabel.setVisible(false);
        radioResultLabel.setVisible(false);
    }

    @FXML
    private void checkCheckBox() {

        boolean correct =
                cb1.isSelected() &&
                        cb2.isSelected() &&
                        cb3.isSelected() &&
                        !cb4.isSelected();

        if (correct) {
            showResult(checkBoxResultLabel, "Правильно!", true);
        } else {
            showResult(checkBoxResultLabel, "Неправильно", false);
        }
    }

    @FXML
    private void checkChoice() {

        if (choiceBox.getValue() == null) return;

        if (choiceBox.getValue().equals("Ні")) {
            showResult(choiceResultLabel, "Правильно!", true);
        } else {
            showResult(choiceResultLabel, "Неправильно", false);
        }
    }

    @FXML
    private void checkCombo() {

        if (comboBox.getValue() == null) return;

        if (comboBox.getValue().equals("BorderPane")) {
            showResult(comboBoxResultLabel, "Правильно!", true);
        } else {
            showResult(comboBoxResultLabel, "Неправильно", false);
        }
    }

    @FXML
    private void checkRadio() {

        if (menuGroup.getSelectedToggle() == null) return;

        RadioButton selected =
                (RadioButton) menuGroup.getSelectedToggle();

        if (selected.getText().equals("Properties")) {
            showResult(radioResultLabel, "Правильно!", true);
        } else {
            showResult(radioResultLabel, "Неправильно", false);
        }
    }

    private void showResult(Label label, String text, boolean success) {
        label.setText(text);
        label.setStyle(success
                ? "-fx-text-fill: green;"
                : "-fx-text-fill: red;");
        label.setVisible(true);
    }
}
