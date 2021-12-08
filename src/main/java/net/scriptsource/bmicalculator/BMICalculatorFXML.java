package net.scriptsource.bmicalculator;

import connector.DatabaseConnector;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import support_class.User;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

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