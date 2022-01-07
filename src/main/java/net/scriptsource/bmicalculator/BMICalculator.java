package net.scriptsource.bmicalculator;

import connector.DatabaseConnector;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
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

public class BMICalculator extends Application {
    private static final DecimalFormat df = new DecimalFormat("0.0");
    DatabaseConnector con = new DatabaseConnector();
    @Override
    public void start(Stage stage) throws IOException {
        ArrayList<User> userList = con.GetUser();
        ObservableList<String> oUserList = FXCollections.observableArrayList();
        stage.setTitle("BMI-Calculator!");
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25,25,25,25));
        Text sceneTitle = new Text("BMI Calculator");
        sceneTitle.setFont(Font.font("Tahoma", FontWeight.NORMAL,20));
        grid.add(sceneTitle, 0,0,2,1);
        //Vorbereiten der Beschriftungen
        Label lbl_firstName = new Label("Vorname");
        Label lbl_lastName = new Label("Nachname");
        Label lbl_height = new Label("Grösse in cm:");
        Label lbl_weight = new Label("Gewicht in KG:");
        Label lbl_age = new Label("Alter:");
        Label lbl_savedUsers = new Label("Gespeicherte Benutzer");
        //Vorbereiten der Eingabefelder
        TextField txt_firstName = new TextField();
        TextField txt_lastName = new TextField();
        TextField txt_height = new TextField();
        TextField txt_weight = new TextField();
        TextField txt_age = new TextField();
        //Vorbereitung des Auswahlfeldes
        ChoiceBox cb_User = new ChoiceBox<>();
        String[] st = new String[userList.size()];
        for (User s:userList) {
            st[s.getId()-1] = s.getFirstname() + " " + s.getLastname();
        }
        cb_User.setItems(FXCollections.observableArrayList(st));
        final Text bmiOutput = new Text();
        //Vorbereitung der Buttons
        Button btnCalculate = new Button("Calculate");
        Button btnExit = new Button("Exit");
        Button btnReset = new Button("Reset");
        //Hinzufügen der Elemente zum Grid
        //grid.add(Object, columnIndex, rowIndex, columnSpan, rowSpan)
        grid.add(lbl_savedUsers,0,1,3,1);
        grid.add(cb_User,2,1,2,1);
        grid.add(lbl_firstName,0,2);
        grid.add(lbl_lastName,1,2);
        grid.add(lbl_height,2,2);
        grid.add(lbl_weight,3,2);
        grid.add(lbl_age,4,2);
        grid.add(txt_firstName,0,3);
        grid.add(txt_lastName,1,3);
        grid.add(txt_height,2,3);
        grid.add(txt_weight,3,3);
        grid.add(txt_age,4,3);
        grid.add(btnReset,2,4);
        grid.add(btnExit,0,4);
        grid.add(btnCalculate,4,4);
        grid.add(bmiOutput,1,5);
        grid.isGridLinesVisible();
        btnExit.setCancelButton(true);
        cb_User.setOnAction((actionEvent)->{
            int selectedIndex = cb_User.
                    getSelectionModel().getSelectedIndex();
            Object selectedItem = cb_User.
                    getSelectionModel().getSelectedItem();

            System.out.println("Selection made " +
                    selectedIndex + " " + selectedItem);
            System.out.println(cb_User.getValue());
        });
        //ActionHandler für die Buttons
        btnCalculate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                bmiOutput.setFill(Color.FIREBRICK);

                double height = Double.parseDouble(txt_height.getText());
                double weight = Double.parseDouble(txt_weight.getText());
                double bmi = (weight / (height*height));

                String output = String.valueOf(
                        System.out.printf("Dein BMI Wert ist %.1f.",bmi));
                bmiOutput.setText("BMI: " +df.format(bmi));
                con.InsertData(txt_firstName.getText(),
                        txt_lastName.getText(),Integer.parseInt(
                                txt_age.getText()),height,weight);
                txt_firstName.setText("");
                txt_lastName.setText("");
                txt_age.setText("");
                txt_height.setText("");
                txt_weight.setText("");
            }
        });
        btnExit.setOnAction((event)->{
            stage.close();
        });
        btnReset.setOnAction((event) ->{
            txt_age.setText("");
            txt_firstName.setText("");
            txt_height.setText("");
            txt_weight.setText("");
            txt_lastName.setText("");
        });
        Scene scene = new Scene(grid,500,400);
        stage.setScene(scene);
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }
}