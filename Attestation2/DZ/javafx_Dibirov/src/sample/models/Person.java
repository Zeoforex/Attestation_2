package sample.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;

import java.time.LocalDate;

public class Person {
    private StringProperty firstName;
    private StringProperty lastName;
    private StringProperty street;
    private StringProperty city;
    private IntegerProperty postlCode;
    private ObjectProperty<LocalDate> birthday;

    public String getCity() {
        return city.get();
    }
    public String getCity() {
        return city.get();
    }

    public String getFirstName() {
        return firstName.get();
    }
    public StringProperty getFirstNameProperty() {
        return firstName;
    }

    public String getLastName() {
        return lastName.get();
    }

    public int getPostlCode() {
        return postlCode.get();
    }

    public LocalDate getBirthday() {
        return birthday.get();
    }

    public String getStreet() {
        return street.get();
    }

    public String getStreet() {
        return street.get();
    }
    public String getStreet() {
        return street.get();
    }

    public void setCity(String city) {
        this.city.set(city);
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday.set(birthday);
    }

    public void setFirstName(String firstName) {
        this.firstName.set(firstName);
    }

    public void setLastName(String lastName) {
        this.lastName.set(lastName);
    }

    public void setStreet(String street) {
        this.street.set(street);
    }

    public void setPostlCode(int postlCode) {
        this.postlCode.set(postlCode);
    }

    public Person(){

    }


}
