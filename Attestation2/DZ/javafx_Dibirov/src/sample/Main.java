package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Hello world Application");
        primaryStage.setWidth(300);
        primaryStage.setHeight(200);

        Label hellolabel = new Label("Hello world");
        hellolabel.setAlignment(Pos.CENTER);
        Scene primaryScene = new Scene(hellolabel);
        primaryStage.setScene(primaryScene);

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
