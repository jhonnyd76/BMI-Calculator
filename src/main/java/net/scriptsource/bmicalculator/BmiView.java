package net.scriptsource.bmicalculator;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.text.DecimalFormat;

public class BmiView {
    private static final DecimalFormat df = new DecimalFormat("0.0");
    int buttonClickCount = 0;
    double bmi;
    @FXML GridPane rootPane;
    @FXML Label lblLastname, lblWeight, lblHeight, lblAge, lblFirstname;
    @FXML TextField txtLastname, txtWeight, txtHeight, txtAge, txtFirstname;
    @FXML Button btnCount;
    @FXML Text txtOutput;
    @FXML TableView<TableUser> tbUser;
    protected ObservableList<TableUser> data;



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
        data=tbUser.getItems();
        if (txtWeight.getText()!="" | txtLastname.getText()!="" |
                txtFirstname.getText()!=""| txtHeight.getText() != ""){
            bmi = Double.parseDouble(txtWeight.getText())/
                    (Double.parseDouble(txtHeight.getText())*
                            Double.parseDouble(txtHeight.getText()));
            txtOutput.setText("Der BMI ist: " + df.format(bmi));
            User user = new User(txtLastname.getText(),txtFirstname.getText(),Integer.parseInt(txtAge.getText()),
                    Double.parseDouble(txtHeight.getText()),Double.parseDouble(txtWeight.getText()));
            data.add(new TableUser(user.getFirstname(), user.getLastname(),
                    String.valueOf(user.getAge()),String.valueOf(user.getHeight()),String.valueOf(user.getWeight())));
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
