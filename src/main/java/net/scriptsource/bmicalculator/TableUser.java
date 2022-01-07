package net.scriptsource.bmicalculator;

import javafx.beans.property.SimpleStringProperty;

public class TableUser {
    private final SimpleStringProperty firstname = new SimpleStringProperty("");
    private final SimpleStringProperty lastname = new SimpleStringProperty("");
    private final SimpleStringProperty age = new SimpleStringProperty("");
    private final SimpleStringProperty weight = new SimpleStringProperty("");
    private final SimpleStringProperty height = new SimpleStringProperty("");

    public TableUser() {
        this("","","","","");
    }

    public TableUser(String firstname, String lastname, String age, String weight, String height){
        setFirstname(firstname);
        setLastname(lastname);
        setAge(age);
        setWeight(weight);
        setHeight(height);
    }

    public String getFirstname() {
        return firstname.get();
    }

    public SimpleStringProperty firstnameProperty() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname.set(firstname);
    }

    public String getLastname() {
        return lastname.get();
    }

    public SimpleStringProperty lastnameProperty() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname.set(lastname);
    }

    public String getAge() {
        return age.get();
    }

    public SimpleStringProperty ageProperty() {
        return age;
    }

    public void setAge(String age) {
        this.age.set(age);
    }

    public String getWeight() {
        return weight.get();
    }

    public SimpleStringProperty weightProperty() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight.set(weight);
    }

    public String getHeight() {
        return height.get();
    }

    public SimpleStringProperty heightProperty() {
        return height;
    }

    public void setHeight(String height) {
        this.height.set(height);
    }
}
