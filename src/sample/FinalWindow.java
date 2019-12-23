package sample;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FinalWindow {

    Image picture = new Image("file:src/sample/assets/knife_end.png");

    public void showWindowRight() {
        Stage finalWindow = new Stage();
        finalWindow.setTitle("End");
        finalWindow.initModality(Modality.APPLICATION_MODAL);

        BackgroundSize backgroundSize = new BackgroundSize(100.0D, 100.0D, true, true, true, true);
        BackgroundImage backgroundImage = new BackgroundImage(picture, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        Label labelFinal = new Label("kfakeugfkuegkuegfkuaegfkaegfkuga");


        AnchorPane anchorPane = new AnchorPane();
        anchorPane.setBackground(background);
        anchorPane.getChildren().addAll(labelFinal);
        AnchorPane.setTopAnchor(labelFinal,10.00);
        AnchorPane.setBottomAnchor(labelFinal,10.00);
        AnchorPane.setLeftAnchor(labelFinal,10.00);
        AnchorPane.setRightAnchor(labelFinal,10.00);

        Scene scene = new Scene(anchorPane, 1400.00, 1000.00, Color.BLACK);
        scene.getStylesheets().add("file:src/sample/style.css");
        finalWindow.setScene(scene);
        finalWindow.showAndWait();



    }
}
