package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sample.controllers.PersonOverviewController;
import sample.models.Person;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Main extends Application {
    public Main(){
        for (int i=0; i<35; i++){
            personData.add(new Person("Имя"+Integer.toString(i), "Фамилия"+Integer.toString(i)));
        }
    }

    public ObservableList<Person> getPersonData() {
        return personData;
    }

    private Stage primaryStage;
    private BorderPane rootLayout;
    private ObservableList<Person> personData = FXCollections.observableArrayList();


    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Address");

        initRootLayout();
        ShowPersonOnView();
    }

    public void initRootLayout(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("views/rootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    public void ShowPersonOnView(){
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("views/mainScene.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();
            rootLayout.setCenter(personOverview);
            PersonOverviewController controller = loader.getController();
            controller.setMainApp(this);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public Stage getPrimaryStage(){
        return primaryStage;
    }
    public static void main(String[] args) {
        launch(args);
    }
}
