package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application{

    Image picture = new Image ("file:src/sample/background.png");
    Button button;
    Hand hand = new Hand();

    public static void main(String[] args) {


        launch(args);
    }

    Stage window;
    @Override
    public void start(Stage primaryStage) throws Exception

    {
        window = primaryStage;



        BackgroundSize backgroundSize = new BackgroundSize(100,100,true, true, true, true);
        BackgroundImage backgroundImage = new BackgroundImage(picture, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER,backgroundSize);
        Background background = new Background(backgroundImage);

        button = new Button();
        button.setText("Choose the case");
        button.setOnAction(click -> {
            hand.GetTheCardsToBeginTheGame();
            hand.chooseTheMurderCase();});


        GridPane grid = new GridPane();
        grid.setBackground(background);
        grid.setPadding(new Insets(10, 10,10,10));
        grid.setVgap(8);
        grid.setHgap(10);
        GridPane.setConstraints(button, 50,50);
        grid.getChildren().add(button);

        Scene scene  = new Scene(grid, 1200, 900, Color.BLACK);


        window.setTitle("Crime Game");
        window.setScene(scene);
        window.show();
    }
}
