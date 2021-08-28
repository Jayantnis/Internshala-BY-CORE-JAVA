package com.internshala.javafxapp;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;//always select in javafx.scene.control.*;


import java.net.URL;
import java.util.ResourceBundle;

public class MyController implements Initializable {
	// FIXME: 24-08-2021
	@FXML
	public Label welomeLabel;
	@FXML
	public ChoiceBox<String> choiceBox;
	@FXML
	public TextField UserField;

	@FXML
	public Button convertButton;

	private static final String C_TO_f="Celsius to Fahrenheit";
	private static final String f_to_C="Fahrenheit to Celsius";// FIXME: 24-08-2021
	
	private boolean is_C_TO_f=true;
	
//creating Template
	@Override
	public void initialize(URL url, ResourceBundle resourceBundle) {

		//obj create at time of class in string
		choiceBox.getItems().add(C_TO_f);
		choiceBox.getItems().add(f_to_C);

		choiceBox.setValue(C_TO_f);//fix string
		choiceBox.setValue(f_to_C);

		//applied in LAMBDA METHOD
		choiceBox.getSelectionModel().selectedItemProperty().addListener((observableValue, s, t1) -> {

			//if user has selected "C to F"
			//t1=> new Value
			if (t1.equals(C_TO_f))
			{
				is_C_TO_f=true;
			}else {
				is_C_TO_f=false;

			}
		});

		convertButton.setOnAction(event -> { convert();  });//create convert method

	}

	//extract value getText
	private void convert()
	{   //Enter user input
		String input=UserField.getText();//23.4 -> " 23.4 "
		// FIXME: 25-08-2021
		float enteredTemperature=0.0f;
		//start handing Exception
		try {
			enteredTemperature = Float.parseFloat(input);//23.4f
		}catch (Exception exception)
		{
			warsUSer();
			return;
			//No code Executed... return
		}
		float newtemp=0.0f;//formulaset
		if(is_C_TO_f)
		{
			newtemp=((enteredTemperature *9/5)+32);
		}else
		{
			newtemp=(enteredTemperature-32)*5/9;
		}
	display(newtemp);
	}

	private void warsUSer() {
		Alert alert=new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error Occurred");
		alert.setHeaderText("Invalid Temperature Entered");
		alert.setContentText("Please enter a valid temperature");
		alert.show();

	}

	private void display(float newtemp){
		String unit=is_C_TO_f? "'F":"'C";//current temp
		System.out.println("The new Temperature is : "+newtemp+unit);

	//display result
		Alert alert=new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Result");
		alert.setContentText("The new Temperature is : "+newtemp+unit);
		alert.show();
	}
}
