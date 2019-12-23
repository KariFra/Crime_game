package sample;


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
    boolean answer;

    public boolean showWindow(Label labelFinal) {
        Stage finalWindow = new Stage();
        finalWindow.setTitle("End");
        finalWindow.initModality(Modality.APPLICATION_MODAL);

        BackgroundSize backgroundSize = new BackgroundSize(100.0D, 100.0D, true, true, true, true);
        BackgroundImage backgroundImage = new BackgroundImage(picture, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);


        Button startNewGame = new Button("Try again!");
        startNewGame.setOnAction(e -> {
            answer = true;
            finalWindow.close();
        });
        GridPane grid = new GridPane();
        grid.setBackground(background);
        GridPane.setConstraints(labelFinal,6,20);
        GridPane.setConstraints(startNewGame,6,25);
        grid.getChildren().addAll(labelFinal,startNewGame);
        grid.setPadding(new Insets(10.00, 5.00, 10.00, 10.00));
        grid.setVgap(8.00);
        grid.setHgap(10.00);

        Scene scene = new Scene(grid, 1400.00, 1000.00, Color.BLACK);
        scene.getStylesheets().add("file:src/sample/style.css");
        finalWindow.setScene(scene);
        finalWindow.showAndWait();

return answer;
    }
}
