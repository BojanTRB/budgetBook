package org.application.application;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import org.application.util.FileHandler;

public class BudgetBook extends Application {
    @Override
    public void init() throws Exception {
        FileHandler fh = new FileHandler();
        fh.writeTransactions("Withdraw", "Amazon", 70);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FileHandler fh = new FileHandler();

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root);

        /* Stylesheet */
        scene.getStylesheets().addAll(this.getClass().getResource("/style.css").toExternalForm());
        primaryStage.setScene(scene);

        /* Icon */
        primaryStage.getIcons().add(new Image(this.getClass().getResource("/images/Icon.png").toExternalForm()));
        primaryStage.setTitle("Budget Book");

        /* Set full screen */
        if(fh.readConfig().containsKey("defaultFullScreen")) {
          String value = fh.readConfig().get("defaultFullScreen");
          if(value.equals("true")) {
              // If value is true
              primaryStage.setMaximized(true);
          } else {
              // If value is set to false
              primaryStage.setMaximized(false);
          }
        } else {
            // If no value exists
            primaryStage.setMaximized(true);
        }


        primaryStage.show();
    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}