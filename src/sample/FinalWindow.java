package sample;


import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FinalWindow {


    Image picture = new Image("file:src/sample/assets/knife_end.jpg");

    public void showWindow(String labelFinal) {
        Stage finalWindow = new Stage();
        finalWindow.setTitle("End");
        finalWindow.initModality(Modality.APPLICATION_MODAL);

        BackgroundSize backgroundSize = new BackgroundSize(100.0D, 100.0D, true, true, true, true);
        BackgroundImage backgroundImage = new BackgroundImage(picture, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);
        Label label = new Label();
        label.setStyle("-fx-font: 50 arial;");
        label.setText(labelFinal);

        Button startNewGame = new Button("Try again!");
        Button closeTheGame = new Button("I am done...");

        startNewGame.setOnAction(e -> {
            finalWindow.close();
        });

        closeTheGame.setOnAction(e -> {
            finalWindow.close();
            Platform.exit();
            System.exit(0);
        });
        GridPane grid = new GridPane();
        grid.setBackground(background);
        GridPane.setConstraints(label,6,20);
        GridPane.setConstraints(startNewGame,6,25);
        GridPane.setConstraints(closeTheGame,6,30);
        grid.getChildren().addAll(label,startNewGame,closeTheGame);
        grid.setPadding(new Insets(10.00, 5.00, 10.00, 10.00));
        grid.setVgap(8.00);
        grid.setHgap(10.00);

        Scene scene = new Scene(grid, 1400.00, 1000.00, Color.BLACK);
        scene.getStylesheets().add("file:src/sample/style.css");
        finalWindow.setScene(scene);
        finalWindow.showAndWait();
    }
}
