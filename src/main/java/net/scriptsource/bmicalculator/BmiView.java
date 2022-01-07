package net.scriptsource.bmicalculator;

import connector.DatabaseConnector;
import connector.DatabaseData;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import support_class.TableUser;
import support_class.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;

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

    public void initialize(){
        refreshTable();
    }
    private void refreshTable(){
        tbUser.setEditable(true);
        ArrayList<User> userList = new DatabaseConnector().GetUser();
        ObservableList<TableUser> userData =tbUser.getItems();
        //userData.clear();
        for (User u : userList){
            String age = String.valueOf(u.getAge());
            String weight = String.valueOf(u.getWeight());
            String height = String.valueOf(u.getHeight());
            userData.add(new TableUser(u.getFirstname(),u.getLastname(),age,weight,height));
        }
    }

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
        DatabaseConnector con = new DatabaseConnector();
        data=tbUser.getItems();
        if (txtWeight.getText()!="" | txtLastname.getText()!="" |
                txtFirstname.getText()!=""| txtHeight.getText() != ""){
            bmi = Double.parseDouble(txtWeight.getText())/
                    (Double.parseDouble(txtHeight.getText())*
                            Double.parseDouble(txtHeight.getText()));
            txtOutput.setText("Der BMI ist: " + df.format(bmi));
            con.InsertData(txtFirstname.getText(),txtLastname.getText(),Integer.parseInt(txtAge.getText()),Double.parseDouble(txtHeight.getText()),Double.parseDouble(txtWeight.getText()));
            refreshTable();
            ClearFields();
        } else {
            bmi = 0.0;
            txtOutput.setText("Sie müssen Werte in die Felder eintragen!");
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
