package org.example.demo1;

import javafx.beans.property.SimpleStringProperty;

public class Person {
    private SimpleStringProperty pib = new SimpleStringProperty("");
    private SimpleStringProperty numberphone = new SimpleStringProperty("");

    public Person(String pib, String numberphone) {
        this.pib = new SimpleStringProperty(pib);
        this.numberphone = new SimpleStringProperty(numberphone);
    }

    public String getPib() {
        return pib.get();
    }

    public SimpleStringProperty pibProperty() {
        return pib;
    }

    public SimpleStringProperty numberphoneProperty() {
        return numberphone;
    }

    public void setPib(String pib) {
        this.pib.set(pib);
    }

    public String getNumberphone() {
        return numberphone.get();
    }

    public void setNumberphone(String numberphone) {
        this.numberphone.set(numberphone);
    }

    @Override
    public String toString() {
        return  "Person{ " + "pib=" + pib + ", phone=" + numberphone + '}';
    }
}
