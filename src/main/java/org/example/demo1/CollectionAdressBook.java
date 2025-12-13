package org.example.demo1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class CollectionAdressBook implements AdressBook {

    private ObservableList<Person> personList = FXCollections.observableArrayList();

    public ObservableList<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(ObservableList<Person> personList) {
        this.personList = personList;
    }

    @Override
    public void add(Person person) {
        personList.add(person);
    }

    @Override
    public void update(Person person) {

    }

    @Override
    public void delete(Person person) {
        personList.remove(person);
    }


    public void testData() {
        personList.add(new Person("Roman", "050668454"));
        personList.add(new Person("Ivan", "050668454"));
        personList.add(new Person("Anna", "050668454"));
        personList.add(new Person("Roman", "050668454"));
    }
}