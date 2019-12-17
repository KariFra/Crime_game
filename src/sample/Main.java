package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Main extends Application {


//    import graphics

    Image picture = new Image("file:src/sample/assets/background.png");
   Image unknown = new Image("file:src/sample/assets/UNKNOWN.png");
    Image img_button01 = new Image("file:src/sample/assets/button01.png");
    Image img_button2 = new Image("file:src/sample/assets/button2.png");
    Image img_button3 = new Image("file:src/sample/assets/button3.png");
    Image man = new Image("file:src/sample/assets/MAN.png");
    Image woman = new Image("file:src/sample/assets/WOMAN.png");
    Image knife = new Image("file:src/sample/assets/KNIFE.png");
    Image gun = new Image("file:src/sample/assets/GUN.png");
    Image inside = new Image("file:src/sample/assets/INSIDE.png");
    Image outside = new Image("file:src/sample/assets/OUTSIDE.png");
    Image day = new Image("file:src/sample/assets/DAY.png");
    Image night = new Image("file:src/sample/assets/NIGHT.png");


//creating objects
    CaseFiles caseFiles = new CaseFiles();
    Hand hand = new Hand();
    Button button01 = new Button("     0/1     ");
    Button button2 = new Button("      2     ");
    Button button3 = new Button("      3     ");
    Button button = new Button("Case");
    Button buttonDraw = new Button("Draw a card");

    Rectangle caseCard = new Rectangle(250.00, 60.00);
    Circle circle1 = new Circle(40.00);
    Circle circle2 = new Circle(40.00);
    Circle circle3 = new Circle(40.00);
    Circle circle4 = new Circle(40.00);

    Stage window;

    public static void main(String[] args) {
        launch(args);
    }


    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;


        BackgroundSize backgroundSize = new BackgroundSize(100.0D, 100.0D, true, true, true, true);
        BackgroundImage backgroundImage = new BackgroundImage(this.picture, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);


//Preparing the grid
        GridPane grid = new GridPane();
        grid.setBackground(background);
        grid.setPadding(new Insets(10.00, 10.00, 10.00, 10.00));
        grid.setVgap(8.00);
        grid.setHgap(10.00);

        circle1.setFill(new ImagePattern(unknown));
        circle2.setFill(new ImagePattern(unknown));
        circle3.setFill(new ImagePattern(unknown));
        circle4.setFill(new ImagePattern(unknown));


        caseCard.setVisible(false);
        buttonDraw.setVisible(false);



//inserting elements to the grid

        Main main = new Main();
        main.fillTheGrid(grid);

        GridPane.setConstraints(button, 7, 13);
        GridPane.setConstraints(button01, 1, 13);
        GridPane.setConstraints(button2, 3, 13);
        GridPane.setConstraints(button3, 5, 13);
        GridPane.setConstraints(buttonDraw, 7, 11);
        GridPane.setConstraints(caseCard, 1, 1);
        GridPane.setConstraints(circle1, 7, 9);
        GridPane.setConstraints(circle2, 7, 7);
        GridPane.setConstraints(circle3, 7, 5);
        GridPane.setConstraints(circle4, 7, 3);


        grid.getChildren().addAll(button,button01,button2, button3,buttonDraw, circle1, circle2, circle3, circle4,caseCard);


        // showing the cards







// assign the action to elements

        button.setOnAction((click) -> {
            buttonDraw.setVisible(true);
            button.setVisible(false);
            caseFiles.createTheNewDeck();
            caseFiles.mixTheDeck();
            System.out.println(caseFiles.newDeck);
            caseFiles.pickPossibleCaseCards();
            System.out.println(caseFiles.newCaseFileCards);
            caseFiles.pickCaseFileCard();
            System.out.println(caseFiles.newCaseFileCard);
//            hand.chooseTheMurderCase();
//            caseCard.setFill(new ImagePattern(new Image("hand.murderCase.getPicture()")));
//            caseCard.setVisible(true);
//            System.out.println(caseFiles.newCard);
        });

        buttonDraw.setOnAction((click) -> {
            caseFiles.pickTheCardFromTheDeck();
            if (caseFiles.newCard.getPlace() == "GARDEN" ){
                circle1.setFill(new ImagePattern(outside));}
            if (caseFiles.newCard.getPlace() == "HOUSE" ){
                circle1.setFill(new ImagePattern(inside));}
            if (caseFiles.newCard.getTool() == "GUN" ){
                circle2.setFill(new ImagePattern(gun));}
            if (caseFiles.newCard.getTool() == "KNIFE" ){
                circle2.setFill(new ImagePattern(knife));}
            if (caseFiles.newCard.getGender() == "WOMAN" ){
                circle3.setFill(new ImagePattern(woman));}
            if (caseFiles.newCard.getGender() == "MAN" ){
                circle3.setFill(new ImagePattern(man));}
            if (caseFiles.newCard.getTime() == "DAY" ){
                circle4.setFill(new ImagePattern(day));}
            if (caseFiles.newCard.getTime() == "NIGHT" ){
                circle4.setFill(new ImagePattern(night));};
        });


        Scene scene = new Scene(grid, 900.00, 700.00, Color.BLACK);
        this.window.setTitle("Crime Game");
        this.window.setScene(scene);
        this.window.show();
    }
    public void fillTheGrid (GridPane grid){
        for(int i=0; i<8; i++){
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(50);
            grid.getColumnConstraints().add(column);
        }
        for(int i=0; i<15; i++){
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(10);
            grid.getRowConstraints().add(row);
        }

    }
}
