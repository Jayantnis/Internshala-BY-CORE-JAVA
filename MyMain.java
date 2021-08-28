package com.internshala.TemperaturConvertorTool;

import javafx.application.*;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.Optional;

/******************    Temperature Convert Tool BY JAYANT NISHAD  ***********************/
public class MyMain extends Application
{

	public static void main(String[] args)
	{
		System.out.println("main");
		launch(args);
	}

	@Override
	public void init() throws Exception
	{
		System.out.println("init");
		// Initialize your application
		super.init();
	}

	@Override
	public void start(Stage primaryStage) throws Exception
	{

		System.out.println("start");    // Starts an application

		FXMLLoader loader = new FXMLLoader(getClass().getResource("sample.fxml"));
		VBox rootNode = loader.load();

		MenuBar menuBar = createMenu();
		rootNode.getChildren().add(0,menuBar);

		//Scene scene = new Scene(rootNode, 400, 400);
		Scene scene = new Scene(rootNode);//replace it automatic statically height and weight set

		primaryStage.setScene(scene);
		primaryStage.setTitle("(*.*)Temperature covert Tool");
		primaryStage.show();

	}

	private MenuBar createMenu()//create menus options all
	{
		// File Menu
		Menu fileMenu = new Menu("File");

		//LEMDA METHOD
		MenuItem newMenuItem = new MenuItem("New");
		newMenuItem.setOnAction(event ->
		{
			System.out.println("New Menu Item Clicked");

			// More code....
		});

		//Root control root
		SeparatorMenuItem separatorMenuItem = new SeparatorMenuItem();

		MenuItem quitMenuItem = new MenuItem("Quit");
		// Item menu //click handler
		quitMenuItem.setOnAction(event ->//LAMBDA
		{
			Platform.exit(); System.exit(0);
		});

		fileMenu.getItems().addAll(newMenuItem,separatorMenuItem,quitMenuItem);

		// Help Menu
		Menu helpMenu = new Menu("Help");

		MenuItem aboutApp = new MenuItem("About");
		//about ->
		aboutApp.setOnAction(event -> aboutApp());
		helpMenu.getItems().addAll(aboutApp);

		// Menu Bar
		MenuBar menuBar = new MenuBar();
		menuBar.getMenus().addAll(fileMenu, helpMenu);

		return menuBar;
	}
//any store container to store any object
	//Alert Dialog ! yes or No About selection
	public static void aboutApp()
	{
		// TODO
		Alert alertDialog=new Alert(Alert.AlertType.CONFIRMATION);
		alertDialog.setTitle("My  First Desktop App");
		alertDialog.setHeaderText("Learning JAVAFX BY JAYANTNISHAD");
		alertDialog.setContentText("I am just a beginner but soon I will be pro and start Developing");

		ButtonType yesbtn=new ButtonType("YES");
		ButtonType Nobtn=new ButtonType("No");

		alertDialog.getButtonTypes().setAll(yesbtn,Nobtn);

		Optional<ButtonType> clickedbtn=alertDialog.showAndWait();
		if(clickedbtn.isPresent() && clickedbtn.get()==yesbtn)
		{
			System.out.println("Yes Button clicked");
		}else
		{
			System.out.println("No Button CLicked");
		}
	}

	@Override
	public void stop() throws Exception
	{

		System.out.println("stop"); // Called when application is stopped and is about to shut down
		super.stop();
	}
}
