package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import static sample.Hand.chosenCard;


public class Main extends Application {


//    import graphics

    Image picture = new Image("file:src/sample/assets/background.png");
   Image unknown = new Image("file:src/sample/assets/UNKNOWN.png");
    Image man = new Image("file:src/sample/assets/MAN.png");
    Image woman = new Image("file:src/sample/assets/WOMAN.png");
    Image knife = new Image("file:src/sample/assets/KNIFE.png");
    Image gun = new Image("file:src/sample/assets/GUN.png");
    Image house = new Image("file:src/sample/assets/HOUSE.png");
    Image garden = new Image("file:src/sample/assets/GARDEN.png");
    Image day = new Image("file:src/sample/assets/DAY.png");
    Image night = new Image("file:src/sample/assets/NIGHT.png");




//creating elements of the scene

    Button button01 = new Button("     0/1     ");
    Button button2 = new Button("      2     ");
    Button button3 = new Button("      3     ");
    Button button = new Button("Get the Case");
    Button buttonCompare = new Button("Compare   ");
    Button buttonCheckYourHand = new Button("Choose card");

    Rectangle caseCard = new Rectangle(260.00, 70.00);
    Rectangle opponentCaseCard = new Rectangle(260.00, 70.00);

    Rectangle card1 = new Rectangle(260.00, 70.00);
    Rectangle card2 = new Rectangle(260.00, 70.00);
    Rectangle card3 = new Rectangle(260.00, 70.00);
    Rectangle card4 = new Rectangle(260.00, 70.00);
    Rectangle card5 = new Rectangle(260.00, 70.00);
    Rectangle card6 = new Rectangle(260.00, 70.00);
    Rectangle card7 = new Rectangle(260.00, 70.00);
    Rectangle card8 = new Rectangle(260.00, 70.00);
    Rectangle card9 = new Rectangle(260.00, 70.00);
    Rectangle card10 = new Rectangle(260.00, 70.00);
    Rectangle card11 = new Rectangle(260.00, 70.00);
    Rectangle card12 = new Rectangle(260.00, 70.00);
    Circle circle1 = new Circle(40.00);
    Circle circle2 = new Circle(40.00);
    Circle circle3 = new Circle(40.00);
    Circle circle4 = new Circle(40.00);

    Rectangle cardUp1 = new Rectangle(260.00, 70.00);
    Rectangle cardUp2 = new Rectangle(260.00, 70.00);
    Rectangle cardUp3 = new Rectangle(260.00, 70.00);
    Rectangle cardUp4 = new Rectangle(260.00, 70.00);
    Rectangle cardUp5 = new Rectangle(260.00, 70.00);
    Rectangle cardUp6 = new Rectangle(260.00, 70.00);
    Rectangle cardUp7 = new Rectangle(260.00, 70.00);
    Rectangle cardUp8 = new Rectangle(260.00, 70.00);
    Rectangle cardUp9 = new Rectangle(260.00, 70.00);
    Rectangle cardUp10 = new Rectangle(260.00, 70.00);
    Rectangle cardUp11 = new Rectangle(260.00, 70.00);
    Rectangle cardUp12 = new Rectangle(260.00, 70.00);

    Stage window;
    CaseFiles caseFiles = new CaseFiles();
    Hand hand = new Hand(caseFiles);
    static Evidence opponentMurderCase;
    int oneOrZero = 0;
    int two = 0;
    int three = 0;

    public static void main(String[] args) {
        launch(args);
    }


    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;


        BackgroundSize backgroundSize = new BackgroundSize(100.0D, 100.0D, true, true, true, true);
        BackgroundImage backgroundImage = new BackgroundImage(this.picture, BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.CENTER, backgroundSize);
        Background background = new Background(backgroundImage);

        circle1.setFill(new ImagePattern(unknown));
        circle2.setFill(new ImagePattern(unknown));
        circle3.setFill(new ImagePattern(unknown));
        circle4.setFill(new ImagePattern(unknown));

//Preparing the grid
        GridPane grid = new GridPane();
        grid.setBackground(background);
        grid.setPadding(new Insets(10.00, 5.00, 10.00, 10.00));
        grid.setVgap(8.00);
        grid.setHgap(10.00);


//inserting elements to the grid

        Main main = new Main();
        main.fillTheGrid(grid);

        GridPane.setConstraints(button, 7, 13);
        GridPane.setConstraints(button01, 1, 13);
        GridPane.setConstraints(button2, 3, 13);
        GridPane.setConstraints(button3, 5, 13);
        GridPane.setConstraints(buttonCompare, 7, 11);
        GridPane.setConstraints(buttonCheckYourHand,7,10);
        GridPane.setConstraints(caseCard, 6, 13);
        GridPane.setConstraints(circle1, 7, 9);
        GridPane.setConstraints(circle2, 7, 7);
        GridPane.setConstraints(circle3, 7, 5);
        GridPane.setConstraints(circle4, 7, 3);
        GridPane.setConstraints(card1, 0, 11);
        GridPane.setConstraints(card2, 2, 11);
        GridPane.setConstraints(card3, 4, 11);
        GridPane.setConstraints(card4, 0, 10);
        GridPane.setConstraints(card5, 2, 10);
        GridPane.setConstraints(card6, 4, 10);
        GridPane.setConstraints(card7, 0, 9);
        GridPane.setConstraints(card8, 2, 9);
        GridPane.setConstraints(card9, 4, 9);
        GridPane.setConstraints(card10, 0, 8);
        GridPane.setConstraints(card11, 2, 8);
        GridPane.setConstraints(card12, 4, 8);
        GridPane.setConstraints(cardUp1, 0, 1);
        GridPane.setConstraints(cardUp2, 2, 1);
        GridPane.setConstraints(cardUp3, 4, 1);
        GridPane.setConstraints(cardUp4, 0, 2);
        GridPane.setConstraints(cardUp5, 2, 2);
        GridPane.setConstraints(cardUp6, 4, 2);
        GridPane.setConstraints(cardUp7, 0, 3);
        GridPane.setConstraints(cardUp8, 2, 3);
        GridPane.setConstraints(cardUp9, 4, 3);
        GridPane.setConstraints(cardUp10, 0, 4);
        GridPane.setConstraints(cardUp11, 2, 4);
        GridPane.setConstraints(cardUp12, 4, 4);
        GridPane.setConstraints(opponentCaseCard, 6, 1);
        grid.getChildren().addAll(buttonCompare,opponentCaseCard,buttonCheckYourHand,button,button01,button2, button3, circle1, circle2, circle3, circle4,caseCard, card1, card2, card3, card4,card5,card6,card7,card8,card9,card10,card11,card12,cardUp1,cardUp2,cardUp3,cardUp4,cardUp5,cardUp6,cardUp7,cardUp8,cardUp9,cardUp10,cardUp11,cardUp12);

        caseCard.setVisible(false);
        buttonCompare.setVisible(false);
        buttonCheckYourHand.setVisible(false);








// assign the action to elements

        button.setOnAction((click) -> {
            button.setVisible(false);
            buttonCheckYourHand.setVisible(true);
            caseCard.setVisible(true);
            caseFiles.createTheNewDeck();
            caseFiles.mixTheDeck();
            System.out.println(caseFiles.newDeck);
            caseFiles.pickPossibleCaseCards();
            Evidence murderCase = hand.chooseTheMurderCase();
            Evidence opponentMurderCase = hand.chooseOpponentMurderCase();
            caseCard.setFill(new ImagePattern(new Image("file:src/sample/assets/"+murderCase.getPicture()+".png")));
            caseCard.setVisible(true);
            hand.BeginTheGameWithThreeCards();
        });

        buttonCheckYourHand.setOnAction((click) ->{
            buttonCompare.setVisible(true);
            hand.pickTheCardDuringGame();
            chosenCard = hand.displayHand();
            if (chosenCard.getPlace() == "GARDEN" ){
                circle1.setFill(new ImagePattern(garden));}
            if (chosenCard.getPlace() == "HOUSE" ){
                circle1.setFill(new ImagePattern(house));}
            if (chosenCard.getTool() == "GUN" ){
                circle2.setFill(new ImagePattern(gun));}
            if (chosenCard.getTool() == "KNIFE" ){
                circle2.setFill(new ImagePattern(knife));}
            if (chosenCard.getGender() == "WOMAN" ){
                circle3.setFill(new ImagePattern(woman));}
            if (chosenCard.getGender() == "MAN" ){
                circle3.setFill(new ImagePattern(man));}
            if (chosenCard.getTime() == "DAY" ){
                circle4.setFill(new ImagePattern(day));}
            if (chosenCard.getTime() == "NIGHT" ){
                circle4.setFill(new ImagePattern(night));}
        });

        buttonCompare.setOnAction((click) -> {
        int commonEvidences = main.askForEvidenceComparison();
        main.placeCardInTheRightSpot(commonEvidences);
                });

        Scene scene = new Scene(grid, 1200.00, 1000.00, Color.BLACK);
        this.window.setTitle("Crime Game");
        this.window.setScene(scene);
        this.window.show();
    }
    public int askForEvidenceComparison() {
        int i = 0;
        System.out.println(chosenCard);
        System.out.println(opponentMurderCase);
        if (chosenCard.getPlace().equals(Hand.opponentMurderCase.getPlace())) {
            i++;
        }
        if (chosenCard.getTime() == opponentMurderCase.getTime()) {
            i++;
        }
        if (chosenCard.getGender() == opponentMurderCase.getGender()) {
            i++;
        }
        if (chosenCard.getTool() == opponentMurderCase.getTool()) {
            i++;
        }
        return i;
    }

    public void placeCardInTheRightSpot(int i){

        if (i<=1 && oneOrZero==0){
            oneOrZero++;
            cardUp1.setFill(new ImagePattern(new Image("file:src/sample/assets/"+ chosenCard.getPicture()+".png")));
            cardUp1.setVisible(true);
        }
        if (i<=1 && oneOrZero==1){
            oneOrZero++;
            cardUp4.setFill(new ImagePattern(new Image("file:src/sample/assets/"+chosenCard.getPicture()+".png")));
            cardUp4.setVisible(true);
        }
        if (i<=1 && oneOrZero==2){
            oneOrZero++;
            cardUp7.setFill(new ImagePattern(new Image("file:src/sample/assets/"+chosenCard.getPicture()+".png")));
            cardUp7.setVisible(true);
        }
        if (i<=1 && oneOrZero==3){
            oneOrZero++;
            cardUp10.setFill(new ImagePattern(new Image("file:src/sample/assets/"+chosenCard.getPicture()+".png")));
            cardUp10.setVisible(true);
        }
        if (i<=2 && two==0){
            two++;
            cardUp2.setFill(new ImagePattern(new Image("file:src/sample/assets/"+chosenCard.getPicture()+".png")));
            cardUp2.setVisible(true);
        }
        if (i<=2 && two==1){
            two++;
            cardUp5.setFill(new ImagePattern(new Image("file:src/sample/assets/"+chosenCard.getPicture()+".png")));
            cardUp5.setVisible(true);
        }
        if (i<=2 && two==2){
            two++;
            cardUp8.setFill(new ImagePattern(new Image("file:src/sample/assets/"+chosenCard.getPicture()+".png")));
            cardUp8.setVisible(true);
        }
        if (i<=2 && two==3){
            two++;
            cardUp11.setFill(new ImagePattern(new Image("file:src/sample/assets/"+chosenCard.getPicture()+".png")));
            cardUp11.setVisible(true);
        }
        if (i<=3 && three==0){
            three++;
            cardUp3.setFill(new ImagePattern(new Image("file:src/sample/assets/"+chosenCard.getPicture()+".png")));
            cardUp3.setVisible(true);
        }
        if (i<=3 && three==1){
            three++;
            cardUp6.setFill(new ImagePattern(new Image("file:src/sample/assets/"+chosenCard.getPicture()+".png")));
            cardUp6.setVisible(true);
        }
        if (i<=3 && three==2){
            three++;
            cardUp9.setFill(new ImagePattern(new Image("file:src/sample/assets/"+chosenCard.getPicture()+".png")));
            cardUp9.setVisible(true);
        }
        if (i<=3 && three==3){
            three++;
            cardUp12.setFill(new ImagePattern(new Image("file:src/sample/assets/"+chosenCard.getPicture()+".png")));
            cardUp12.setVisible(true);
        }
    }

    public void fillTheGrid (GridPane grid){
        for(int i=0; i<9; i++){
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(50);
            grid.getColumnConstraints().add(column);
        }
        for(int i=0; i<15; i++){
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(10);
            grid.getRowConstraints().add(row);
        }

        StackPane stack1 = new StackPane();
        stack1.getChildren().addAll(new Rectangle(100,30,Color.WHITE), new Label("0/1"));
        StackPane stack2 = new StackPane();
        stack2.getChildren().addAll(new Rectangle(100,30,Color.WHITE), new Label("2"));
        StackPane stack3 = new StackPane();
        stack3.getChildren().addAll(new Rectangle(100,30,Color.WHITE), new Label("3"));


        GridPane.setConstraints(stack1, 1, 0);
        GridPane.setConstraints(stack2, 3, 0);
        GridPane.setConstraints(stack3, 5, 0);

        grid.getChildren().addAll(stack1,stack2,stack3);



    }
}
