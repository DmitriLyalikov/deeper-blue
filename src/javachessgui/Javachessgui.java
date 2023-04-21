package javachessgui;

import javafx.application.Application;
import javafx.scene.*;
import javafx.stage.*;

import java.io.*;
import javafx.application.Platform;

import javafx.scene.control.TextArea;

/**
 *  Author: Dmitri Lyalikov 
 *  File: Javachessgui.java
 * 
 * - Initialize our GUI based on the JavaFX library 
 * - Start a new thread and start process, 
 * - define functions for safely destructing and quitting the application
 */

public class Javachessgui extends Application {
    
    public Gui gui;
    
    public static TextArea message_text=new TextArea();
    
    final static String message_text_style=
            "-fx-border-width: 10px;"
            + "-fx-border-radius: 10px;"
            + "-fx-border-style: solid;"
            + "-fx-control-inner-background: #efefff;"
            + "-fx-border-color: #afafff;";
    
    public static int timer;
    public static void system_message(String what,int set_timer)
    {
        
        timer=set_timer;
        
        message_text.setText(what);
        message_text.setStyle("-fx-opacity: 1;"+message_text_style);
        message_text.setMinHeight(350);
        message_text.toFront();
                
        Thread system_message_thread=new Thread(new Runnable()
        {

            public void run()
            {

                try
                {
                    Thread.sleep(timer);
                }
                catch(InterruptedException ex)
                {

                }

                Platform.runLater(new Runnable()
                {

                    public void run()
                    {

                        message_text.setStyle("-fx-opacity: 0;"+message_text_style);
                        message_text.toBack();

                    }   

                });

            }   

        });

        system_message_thread.start();
                
    }

    @Override
    public void start(Stage primaryStage) {
        
        try
        {
            new File("book").mkdir();
        }
        catch(Exception e)
        {
            
        }
               
        init_app();
        
        primaryStage.setTitle("Deeper Blue");
        primaryStage.setX(0);
        primaryStage.setY(0);

        Group root = new Group();

        gui = new Gui(primaryStage);

        root.getChildren().add(gui.horizontal_box);
        
        message_text.setWrapText(true);
        message_text.setTranslateX(30);
        message_text.setTranslateY(30);
        message_text.setStyle("-fx-opacity: 0;"+message_text_style);
        root.getChildren().add(message_text);

        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        
        system_message("Welcome to Deeper-Blue!",2000);
        
        System.out.println("Deeper Blue Chess GUI Started");
    }
       
    @Override
    public void stop() {

        gui.shutdown();
        
        System.out.println("Deeper Blue Chess GUI stopped");
    }

    private void init_app() {
        Board.init_class();
        
        System.out.println("GUI initialized");
    }

    public static void main(String[] args) {
        launch(args);
    }

}
