package sample.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import sample.Main;
import sample.models.Person;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import sample.utils.DateUtil;

public class PersonOverviewController {
    @FXML
    private TableView<Person> personTableView;
    @FXML
    private TableColumn<Person, String> firstNameColumn;
    @FXML
    private TableColumn<Person, String> lastNameColumn;

    @FXML
    private Label firstNameLabel;
    @FXML
    private Label lastNameLabel;
    @FXML
    private Label streetLabel;
    @FXML
    private Label cityLabel;
    @FXML
    private Label postalCodeLabel;
    @FXML
    private Label birthdayLabel;

    private Main main;

    public PersonOverviewController(){}

    @FXML
    private void initialize(){
        firstNameColumn.setCellValueFactory(cellData -> cellData.getValue().getFirstNameProperty());
        lastNameColumn.setCellValueFactory(cellData -> cellData.getValue().getLastNameProperty());

        showPersonDetails(null);
        personTableView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue,newValue) -> showPersonDetails(newValue)
        );
    }

    public void setMainApp(Main main){
        this.main = main;
        personTableView.setItems(main.getPersonData());
    }

    private void showPersonDetails(Person person){
        if (person != null){
            firstNameLabel.setText(person.getFirstName());
            lastNameLabel.setText(person.getLastName());
            streetLabel.setText(person.getStreet());
            cityLabel.setText(person.getCity());
            postalCodeLabel.setText(Integer.toString(person.getPostalCode()));
            birthdayLabel.setText(DateUtil.format(person.getBirthday()));
        }else{
            firstNameLabel.setText("");
            lastNameLabel.setText("");
            streetLabel.setText("");
            cityLabel.setText("");
            postalCodeLabel.setText("");
            birthdayLabel.setText("");
        }
    }

    @FXML
    private void handleDeletePerson(){
        int selectedIndex=personTableView.getSelectionModel().getSelectedIndex();
        if (selectedIndex>=0){
            personTableView.getItems().remove(selectedIndex);
        }else{
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(main.getPrimaryStage());
            alert.setTitle("No selection ");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table");

            alert.showAndWait();
        }

    }
}
