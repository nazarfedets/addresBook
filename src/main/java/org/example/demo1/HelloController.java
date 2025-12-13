package org.example.demo1;

import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.Optional;

public class HelloController {
    @FXML private Button btnOpen;
    @FXML private Button btnAdd;
    @FXML private Button btnDelete;
    @FXML private Label label;
    @FXML private Button exitbtn;
    @FXML private  Button otherLabs;
    @FXML private TableColumn<Person,String> columPip;
    @FXML private  TableColumn<Person,String> columPhone;
    @FXML private TableView<Person> tableview;
    @FXML private Label lableCount;
    private Stage newStage;
    @FXML private TextField searchField;


    private CollectionAdressBook adressBookImpl = new CollectionAdressBook();

    @FXML
    public void initialize() {
        columPip.setCellValueFactory(new PropertyValueFactory<Person,String>("pib"));
        columPhone.setCellValueFactory(new PropertyValueFactory<Person,String>("numberphone"));
        adressBookImpl.getPersonList().addListener(new ListChangeListener<Person>() {
            @Override
            public void onChanged(Change<? extends Person> c) {
                updateCountLabel();
            }
        });
        adressBookImpl.testData();
        tableview.setItems(adressBookImpl.getPersonList());
    }

    private void updateCountLabel() {
        lableCount.setText("Кількість записів: " + adressBookImpl.getPersonList().size());
    }
    @FXML
    private void openDialog() {
        Person selected = tableview.getSelectionModel().getSelectedItem();

        if (selected == null) {
            label.setText("Запис не вибрано!");
            return;
        }

        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Second.fxml"));
            Parent root = fxmlLoader.load();

            SecondController controller = fxmlLoader.getController();
            controller.setAddressBook(adressBookImpl);

            controller.setPerson(selected);

            Stage stage = new Stage();
            stage.setTitle("Редагування запису");
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
        Person selected = tableview.getSelectionModel().getSelectedItem();
        if (selected == null) {
            label.setText("Запис не вибрано!");
            return;
        }

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Видалення запису");
        alert.setHeaderText("Підтвердження видалення");
        alert.setContentText("Ви впевнені, що хочете видалити цей запис?");

        Optional<ButtonType> result = alert.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            adressBookImpl.delete(selected);
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

    @FXML
    private void handleSearch() {
        String query = searchField.getText().toLowerCase();

        if (query.isEmpty()) {
            tableview.setItems(adressBookImpl.getPersonList());
            label.setText("Пошук скасовано");
            return;
        }

        ObservableList<Person> filtered = FXCollections.observableArrayList();

        for (Person p : adressBookImpl.getPersonList()) {
            if (p.getPib().toLowerCase().contains(query) ||
                    p.getNumberphone().toLowerCase().contains(query)) {
                filtered.add(p);
            }
        }

        tableview.setItems(filtered);
        label.setText("Знайдено збігів: " + filtered.size());
    }




}
