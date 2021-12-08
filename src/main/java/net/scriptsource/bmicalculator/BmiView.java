package net.scriptsource.bmicalculator;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import support_class.User;

import java.text.DecimalFormat;

public class BmiView {
    private static final DecimalFormat df = new DecimalFormat("0.0");
    int buttonClickCount = 0;
    double bmi;
    @FXML GridPane gridPane;
    @FXML Label lblLastname, lblWeight, lblHeight, lblAge, lblFirstname;
    @FXML TextField txtLastname, txtWeight, txtHeight, txtAge, txtFirstname;
    @FXML Button btnCount;
    @FXML Text txtOutput;
    @FXML TableView<User> tbUser;


    @FXML
    protected void ClickButton(){
        this.buttonClickCount++;
        if (this.buttonClickCount%2==0){
            txtLastname.setText("Hallo Gerade");
        }else {
            txtLastname.setText("Hallo Ungerade");
        }
        System.out.println(this.buttonClickCount);
    }

    @FXML
    protected void CalculateBMI(ActionEvent event){
        if (txtWeight.getText()!="" | txtLastname.getText()!="" |
        txtFirstname.getText()!=""| txtHeight.getText() != ""){
            bmi = Double.parseDouble(txtWeight.getText())/
                    (Double.parseDouble(txtHeight.getText())*
                            Double.parseDouble(txtHeight.getText()));
            txtOutput.setText("Der BMI ist: " + df.format(bmi));
            ObservableList<User> data = tbUser.getItems();
            data.add(new User(txtLastname.getText(),txtFirstname.getText(),Integer.parseInt(txtAge.getText()),
                    Double.parseDouble(txtHeight.getText()),Double.parseDouble(txtWeight.getText())));
            ClearFields();
        } else {
            bmi = 0.0;
            txtOutput.setText("Sie müssen Werte in den Feldern eintragen!");
        }
    }

    protected void ClearFields(){
        txtFirstname.setText("");
        txtLastname.setText("");
        txtAge.setText("");
        txtWeight.setText("");
        txtHeight.setText("");
    }
}
