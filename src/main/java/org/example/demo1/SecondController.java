package org.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;



public class SecondController {
    @FXML private Button cancelbtn;
    @FXML private TextField txtpib;
    @FXML private TextField txtphone;
    @FXML private Button okButton;
    public Person person;
    private CollectionAdressBook adressBook;

    public void setPerson(Person person) {
        this.person = person;
        if (person != null) {
            txtpib.setText(person.getPib());
            txtphone.setText(person.getNumberphone());
        }
    }


    @FXML
    private void actionClose(ActionEvent event) {
        Node sourse = (Node) event.getSource();
        Stage stage = (Stage) sourse.getScene().getWindow();
        stage.close();
    }


    @FXML
    public void actionSave(ActionEvent event) {
        Person person = new Person(
                txtpib.getText(),
                txtphone.getText()
        );
        adressBook.getPersonList().add(person);
        actionClose(event);
    }
    public void setAddressBook(CollectionAdressBook adressBook) {
        this.adressBook = adressBook;
    }


}
