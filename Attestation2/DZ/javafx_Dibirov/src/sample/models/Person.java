package sample.models;

import javafx.beans.property.*;

import java.time.LocalDate;

public class Person {
    private StringProperty firstName;
    private StringProperty lastName;
    private StringProperty street;
    private StringProperty city;
    private IntegerProperty postalCode;
    private ObjectProperty<LocalDate> birthday;

    public String getCity() {
        return city.get();
    }
    public StringProperty getCityProperty() {
        return city;
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
    public StringProperty getLastNameProperty() {
        return lastName;
    }

    public int getPostalCode() {
        return postalCode.get();
    }

    public LocalDate getBirthday() {
        return birthday.get();
    }

    public StringProperty getStreetProperty() {
        return street;
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

    public void setPostalCode(int postalCode) {
        this.postalCode.set(postalCode);
    }

    public Person(String firstName, String lastName){
        this.firstName = new SimpleStringProperty(firstName);
        this.lastName = new SimpleStringProperty(lastName);

        // Фиктивные данные
        this.city = new SimpleStringProperty("Какаой-то город");
        this.street = new SimpleStringProperty("Какая-то улица");
        this.postalCode = new SimpleIntegerProperty(1234);
        this.birthday = new SimpleObjectProperty<LocalDate>(LocalDate.of(1995,10,12));

    }


}
