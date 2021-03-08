package com.examples.java.inner;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
 
public class AnonymousInnerClassGUIEx extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello World!");
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        
        // Registering event handler
        // ButtonClickEventHandler eventHandler = new ButtonClickEventHandler();
        // btn.setOnAction(new ButtonClickEventHandler());          
        
        // Registering event handler with anonymous inner class
        btn.setOnAction(new EventHandler<ActionEvent>() {
 
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
    
//    public class ButtonClickEventHandler implements EventHandler<ActionEvent> 
//    {
//
//		@Override
//		public void handle(ActionEvent event) {
//			System.out.println("Hello world from ButtonClientEventHandler class..");			
//		}
//    	
//    }
}