package net.scriptsource.bmicalculator;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.PopupWindow;

public class BmiView {
    int buttonClickCount = 0;
    double bmi;
    @FXML GridPane gridPane;
    @FXML Label lblLastname, lblWeight, lblHeight, lblAge, lblFirstname;
    @FXML TextField txtLastname, txtWeight, txtHeight, txtAge, txtFirstname;
    @FXML Button btnCount;


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
    protected double CalculateBMI(){
        bmi = Double.parseDouble(txtWeight.getText())/
                (Double.parseDouble(txtHeight.getText())*
                        Double.parseDouble(txtHeight.getText()));
        System.out.printf("BMI ist : %.1f\n", bmi);
        return bmi;
    }
}
