package net.scriptsource.bmicalculator;

import connector.DatabaseConnector;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.DecimalFormat;

public class BMICalculatorFXML extends Application {
    private static final DecimalFormat df = new DecimalFormat("0.0");
    DatabaseConnector con = new DatabaseConnector();
    @Override
    public void start(Stage stage) throws IOException {
        Parent fxmlLoader = FXMLLoader.load(getClass().getResource("bmi-view.fxml"));
        stage.setTitle("BMI-Calculator!");
        Scene scene = new Scene(fxmlLoader,600,400);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}