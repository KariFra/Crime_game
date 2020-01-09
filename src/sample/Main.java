package sample;


import javafx.application.Application;
import javafx.application.Platform;
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
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Random;

import static sample.Hand.chosenCard;



public class Main extends Application {

    ArrayList< Rectangle> createdCards = new ArrayList<>();
    ArrayList< Circle> createdCircles = new ArrayList<>();

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

    Button buttonStart = new Button("Get the Case");
    Button buttonCompare = new Button("Compare   ");
    Button buttonCheckYourHand = new Button("Choose card");
    Button finishRound = new Button("Finish round");
    Button guessButton = new Button("Guess");

// creating objects

    CaseFiles caseFiles = new CaseFiles();
    Hand hand = new Hand(caseFiles);
    Guess guess = new Guess();
    FinalWindow finalWindow = new FinalWindow();


    Stage window;
    Evidence opponentMurderCase;
    Evidence opponentChosenCard;
    Evidence murderCase;
    String opponentGuessedCard;
    String finalCardGuess;
    int numberOfCommonEvidencesOpponent;
    int numberOfCommonEvidences;
    int oneOrZero;
    int two;
    int three;
    int oneOrZeroOpponent;
    int twoOpponent;
    int threeOpponent;
    int clickCalculator;

    Rectangle caseCard = new Rectangle(260.00, 70.00);
    Rectangle opponentCaseCard = new Rectangle(260.00, 70.00);

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
        grid.setPadding(new Insets(10.00, 5.00, 10.00, 10.00));
        grid.setVgap(8.00);
        grid.setHgap(10.00);

        //Creating the cards
        int numberOfColumn = 0;
        int numberOfRow = 11;
        for (int i = 0; i<24; i++) {
            Rectangle card = new Rectangle(260.00, 70.00);
            card.setVisible(false);
            if (numberOfRow == 7) {
                numberOfRow = 4;
            }
            if (numberOfColumn == 0) {
                GridPane.setConstraints(card, 0, numberOfRow);
                numberOfColumn++;
            } else if (numberOfColumn == 1) {
                GridPane.setConstraints(card, 2, numberOfRow);
                numberOfColumn++;
            } else if (numberOfColumn == 2) {
                GridPane.setConstraints(card, 4, numberOfRow);
                numberOfColumn = 0;
                numberOfRow -= 1;
            }
            createdCards.add(card);
            grid.getChildren().add(card);
        }


        //Creating the circles
        int rowIndexDifference = 3;
        for (int i = 0; i<4; i++){
            Circle circle = new Circle(40.00);
            circle.setVisible(false);
            GridPane.setConstraints(circle, 7, i+rowIndexDifference);
            grid.getChildren().add(circle);
            createdCircles.add(circle);
            rowIndexDifference++;
        }

        //inserting elements to the grid

        Main main = new Main();
        main.fillTheGrid(grid);

        GridPane.setConstraints(buttonStart, 7, 13);
        GridPane.setConstraints(buttonCompare, 7, 11);
        GridPane.setConstraints(buttonCheckYourHand,7,10);
        GridPane.setConstraints(finishRound, 7, 11);
        GridPane.setConstraints(guessButton,7,10);
        GridPane.setConstraints(caseCard, 6, 13);
        GridPane.setConstraints(opponentCaseCard, 6, 1);
        grid.getChildren().addAll(guessButton,finishRound,buttonCompare,opponentCaseCard,buttonCheckYourHand,buttonStart,caseCard);

        caseCard.setVisible(false);
        buttonCompare.setVisible(false);
        buttonCheckYourHand.setVisible(false);
        finishRound.setVisible(false);
        opponentCaseCard.setVisible(false);
        guessButton.setVisible(false);

// assign the action to elements

        buttonStart.setOnAction((click) -> {
            buttonStart.setVisible(false);
            buttonCheckYourHand.setVisible(true);
            caseCard.setVisible(true);
            opponentCaseCard.setVisible(true);
            caseFiles.createTheNewDeck();
            caseFiles.mixTheDeck();
            caseFiles.pickPossibleCaseCards();
            murderCase = hand.chooseTheMurderCase();
            System.out.println("my Murder case: "+murderCase);
            opponentMurderCase = hand.chooseOpponentMurderCase();
            System.out.println("Computer Murder case: "+opponentMurderCase);
            caseCard.setFill(new ImagePattern(new Image("file:src/sample/assets/"+murderCase.getPicture()+".png")));
            caseCard.setVisible(true);
            hand.BeginTheGameWithThreeCards();
        });

        buttonCheckYourHand.setOnAction((click) ->{
            clickCalculator++;
            createdCircles.get(0).setFill(new ImagePattern(unknown));
            createdCircles.get(1).setFill(new ImagePattern(unknown));
            createdCircles.get(2).setFill(new ImagePattern(unknown));
            createdCircles.get(3).setFill(new ImagePattern(unknown));
            createdCircles.get(0).setVisible(true);
            createdCircles.get(1).setVisible(true);
            createdCircles.get(2).setVisible(true);
            createdCircles.get(3).setVisible(true);
            buttonCompare.setVisible(true);
            buttonCheckYourHand.setVisible(false);
            hand.pickTheCardDuringGame();
            chosenCard = hand.displayHand();

            if (chosenCard.getPlace() == "GARDEN" ){
                createdCircles.get(0).setFill(new ImagePattern(garden));}
            if (chosenCard.getPlace() == "HOUSE" ){
                createdCircles.get(0).setFill(new ImagePattern(house));}
            if (chosenCard.getTool() == "GUN" ){
                createdCircles.get(1).setFill(new ImagePattern(gun));}
            if (chosenCard.getTool() == "KNIFE" ){
                createdCircles.get(1).setFill(new ImagePattern(knife));}
            if (chosenCard.getGender() == "WOMAN" ){
                createdCircles.get(2).setFill(new ImagePattern(woman));}
            if (chosenCard.getGender() == "MAN" ){
                createdCircles.get(2).setFill(new ImagePattern(man));}
            if (chosenCard.getTime() == "DAY" ){
                createdCircles.get(3).setFill(new ImagePattern(day));}
            if (chosenCard.getTime() == "NIGHT" ){
                createdCircles.get(3).setFill(new ImagePattern(night));}
        });

        buttonCompare.setOnAction((click) -> {
            numberOfCommonEvidencesOpponent = 0;
            createdCircles.get(0).setVisible(false);
            createdCircles.get(1).setVisible(false);
            createdCircles.get(2).setVisible(false);
            createdCircles.get(3).setVisible(false);
            buttonCompare.setVisible(false);
            finishRound.setVisible(true);
            guessButton.setVisible(true);
            numberOfCommonEvidencesOpponent = main.askForEvidenceComparison(chosenCard,opponentMurderCase);
            if(numberOfCommonEvidencesOpponent==0 ||numberOfCommonEvidencesOpponent==1){
                oneOrZeroOpponent++;
            }
            if(numberOfCommonEvidencesOpponent==2){
                twoOpponent++;
            }
            if(numberOfCommonEvidencesOpponent==3){
                threeOpponent++;
            }
        System.out.println(numberOfCommonEvidencesOpponent);

            if (numberOfCommonEvidencesOpponent<=1 && oneOrZeroOpponent==1){
                createdCards.get(23).setFill(new ImagePattern(new Image("file:src/sample/assets/"+ chosenCard.getPicture()+".png")));
                createdCards.get(23).setVisible(true);
            }
            if (numberOfCommonEvidencesOpponent<=1 && oneOrZeroOpponent==2){
                createdCards.get(20).setFill(new ImagePattern(new Image("file:src/sample/assets/"+chosenCard.getPicture()+".png")));
                createdCards.get(20).setVisible(true);
            }
            if (numberOfCommonEvidencesOpponent<=1 && oneOrZeroOpponent==3){
                createdCards.get(17).setFill(new ImagePattern(new Image("file:src/sample/assets/"+chosenCard.getPicture()+".png")));
                createdCards.get(17).setVisible(true);
            }
            if (numberOfCommonEvidencesOpponent<=1 && oneOrZeroOpponent==4){
                createdCards.get(14).setFill(new ImagePattern(new Image("file:src/sample/assets/"+chosenCard.getPicture()+".png")));
                createdCards.get(14).setVisible(true);
            }
            if (numberOfCommonEvidencesOpponent==2 && twoOpponent==1){
                createdCards.get(22).setFill(new ImagePattern(new Image("file:src/sample/assets/"+chosenCard.getPicture()+".png")));
                createdCards.get(22).setVisible(true);
            }
            if (numberOfCommonEvidencesOpponent==2 && twoOpponent==2){
                createdCards.get(19).setFill(new ImagePattern(new Image("file:src/sample/assets/"+chosenCard.getPicture()+".png")));
                createdCards.get(19).setVisible(true);
            }
            if (numberOfCommonEvidencesOpponent==2 && twoOpponent==3){
                createdCards.get(16).setFill(new ImagePattern(new Image("file:src/sample/assets/"+chosenCard.getPicture()+".png")));
                createdCards.get(16).setVisible(true);
            }
            if (numberOfCommonEvidencesOpponent==2 && twoOpponent==4){
                createdCards.get(13).setFill(new ImagePattern(new Image("file:src/sample/assets/"+chosenCard.getPicture()+".png")));
                createdCards.get(13).setVisible(true);
            }
            if (numberOfCommonEvidencesOpponent==3 && threeOpponent==1){
                createdCards.get(21).setFill(new ImagePattern(new Image("file:src/sample/assets/"+chosenCard.getPicture()+".png")));
                createdCards.get(21).setVisible(true);
            }
            if (numberOfCommonEvidences==3 && threeOpponent==2){
                createdCards.get(18).setFill(new ImagePattern(new Image("file:src/sample/assets/"+chosenCard.getPicture()+".png")));
                createdCards.get(18).setVisible(true);
            }
            if (numberOfCommonEvidencesOpponent==3 && threeOpponent==3){
                createdCards.get(15).setFill(new ImagePattern(new Image("file:src/sample/assets/"+chosenCard.getPicture()+".png")));
                createdCards.get(15).setVisible(true);
            }
            if (numberOfCommonEvidencesOpponent==3 && threeOpponent==4){
                createdCards.get(12).setFill(new ImagePattern(new Image("file:src/sample/assets/"+chosenCard.getPicture()+".png")));
                createdCards.get(12).setVisible(true);
            }

            numberOfCommonEvidencesOpponent = 0;
        });

        finishRound.setOnAction((click) ->{
            guessButton.setVisible(true);
            numberOfCommonEvidences = 0;
            if (clickCalculator<5){buttonCheckYourHand.setVisible(true);}
            if (clickCalculator==5){finalCardGuess =main.opponentGuess(murderCase);
                if (finalCardGuess.equals(murderCase.printOutGender()+" "+murderCase.printOutTime()+" "+murderCase.printOutTool()+" "+murderCase.printOutPlace())){
                  finalWindow.showWindow("You were too slow this time...");
                } else{
                    finalWindow.showWindow("You still have chance to solve the case");
                }
            }
            if (createdCards.get(3).isVisible() && createdCards.get(6).isVisible() || createdCards.get(2).isVisible() && createdCards.get(3).isVisible()){
                finalCardGuess =main.opponentGuess(murderCase);
                if (finalCardGuess.equals(murderCase.printOutGender()+" "+murderCase.printOutTime()+" "+murderCase.printOutTool()+" "+murderCase.printOutPlace())){
                    finalWindow.showWindow("You were too slow this time...");
                }
            }
            finishRound.setVisible(false);
            guessButton.setVisible(true);
            opponentChosenCard = caseFiles.pickTheCardFromTheDeck();
            caseFiles.removeTheCardFromTheDeck(opponentChosenCard);
            numberOfCommonEvidences = main.askForEvidenceComparison(opponentChosenCard,murderCase);
            if(numberOfCommonEvidences==0 || numberOfCommonEvidences==1){
                oneOrZero++;
            }
            if(numberOfCommonEvidences==2){
                two++;
            }
            if(numberOfCommonEvidences==3){
                three++;
            }
            if (numberOfCommonEvidences<=1 && oneOrZero==1){
                createdCards.get(0).setFill(new ImagePattern(new Image("file:src/sample/assets/"+ opponentChosenCard.getPicture()+".png")));
                createdCards.get(0).setVisible(true);
            }
            if (numberOfCommonEvidences<=1 && oneOrZero==2){
                createdCards.get(3).setFill(new ImagePattern(new Image("file:src/sample/assets/"+opponentChosenCard.getPicture()+".png")));
                createdCards.get(3).setVisible(true);
            }
            if (numberOfCommonEvidences<=1 && oneOrZero==3){
                createdCards.get(6).setFill(new ImagePattern(new Image("file:src/sample/assets/"+opponentChosenCard.getPicture()+".png")));
                createdCards.get(6).setVisible(true);
            }
            if (numberOfCommonEvidences<=1 && oneOrZero==4){
                createdCards.get(9).setFill(new ImagePattern(new Image("file:src/sample/assets/"+opponentChosenCard.getPicture()+".png")));
                createdCards.get(9).setVisible(true);
            }
            if (numberOfCommonEvidences==2 && two==1){
                createdCards.get(1).setFill(new ImagePattern(new Image("file:src/sample/assets/"+opponentChosenCard.getPicture()+".png")));
                createdCards.get(1).setVisible(true);
            }
            if (numberOfCommonEvidences==2 && two==2){
                createdCards.get(4).setFill(new ImagePattern(new Image("file:src/sample/assets/"+opponentChosenCard.getPicture()+".png")));
                createdCards.get(4).setVisible(true);
            }
            if (numberOfCommonEvidences==2 && two==3){
                createdCards.get(7).setFill(new ImagePattern(new Image("file:src/sample/assets/"+opponentChosenCard.getPicture()+".png")));
                createdCards.get(7).setVisible(true);
            }
            if (numberOfCommonEvidences==2 && two==4){
                createdCards.get(10).setFill(new ImagePattern(new Image("file:src/sample/assets/"+opponentChosenCard.getPicture()+".png")));
                createdCards.get(10).setVisible(true);
            }
            if (numberOfCommonEvidences==3 && three==1){
                createdCards.get(2).setFill(new ImagePattern(new Image("file:src/sample/assets/"+opponentChosenCard.getPicture()+".png")));
                createdCards.get(2).setVisible(true);
            }
            if (numberOfCommonEvidences==3 && three==2){
                createdCards.get(5).setFill(new ImagePattern(new Image("file:src/sample/assets/"+opponentChosenCard.getPicture()+".png")));
                createdCards.get(5).setVisible(true);
            }
            if (numberOfCommonEvidences==3 && three==3){
                createdCards.get(8).setFill(new ImagePattern(new Image("file:src/sample/assets/"+opponentChosenCard.getPicture()+".png")));
                createdCards.get(8).setVisible(true);
            }
            if (numberOfCommonEvidences==3 && three==4){
                createdCards.get(11).setFill(new ImagePattern(new Image("file:src/sample/assets/"+opponentChosenCard.getPicture()+".png")));
                createdCards.get(11).setVisible(true);
            }
            numberOfCommonEvidences = 0;
        });

        guessButton.setOnAction((click) ->{
            opponentGuessedCard = guess.guessOpponentCard();
            boolean gameEnd = false;
            while (opponentGuessedCard != null && gameEnd == false) {
                String opponentCard = opponentMurderCase.printOutGender() + " " + opponentMurderCase.printOutTime() + " " + opponentMurderCase.printOutTool() + " " + opponentMurderCase.printOutPlace();
                if (opponentGuessedCard.equals(opponentCard)) {
                    finalWindow.showWindow("You were right Scherlock!");
                    gameEnd = true;
                } else {
                    finalWindow.showWindow("Not even close...");
                    gameEnd = true;
                }
                for (int i = 0; i<createdCards.size(); i++){
                    createdCards.get(i).setVisible(false);
                }
                buttonStart.setVisible(true);
                guessButton.setVisible(false);
                finishRound.setVisible(false);
                caseCard.setVisible(false);
                opponentCaseCard.setVisible(false);
            }
        });

        Scene scene = new Scene(grid, 1600.00, 1000.00, Color.BLACK);
        scene.getStylesheets().add("file:src/sample/style.css");
        window.setTitle("Crime Game");
        window.setScene(scene);
        window.show();
    }

    public int askForEvidenceComparison(Evidence chosenCard, Evidence opponentMurderCase) {
        numberOfCommonEvidences = 0;
        if (chosenCard.getPlace().equals(opponentMurderCase.getPlace())) {
            numberOfCommonEvidences++;
        }
        if (chosenCard.getTime().equals(opponentMurderCase.getTime())) {
            numberOfCommonEvidences++;
        }
        if (chosenCard.getGender().equals(opponentMurderCase.getGender())) {
            numberOfCommonEvidences++;
        }
        if (chosenCard.getTool().equals(opponentMurderCase.getTool())) {
            numberOfCommonEvidences++;
        }
         System.out.println(numberOfCommonEvidences);
        return numberOfCommonEvidences;
    }

    public void fillTheGrid (GridPane grid){
        ArrayList <StackPane> createdStacks = new ArrayList<>();

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
        stack1.getChildren().addAll(new Rectangle(100,30,Color.BLACK), new Label("0/1"));
        StackPane stack2 = new StackPane();
        stack2.getChildren().addAll(new Rectangle(100,30,Color.BLACK), new Label("2"));
        StackPane stack3 = new StackPane();
        stack3.getChildren().addAll(new Rectangle(100,30,Color.BLACK), new Label("3"));
        StackPane stack4 = new StackPane();
        stack4.getChildren().addAll(new Rectangle(100,30,Color.BLACK), new Label("0/1"));
        StackPane stack5 = new StackPane();
        stack5.getChildren().addAll(new Rectangle(100,30,Color.BLACK), new Label("2"));
        StackPane stack6 = new StackPane();
        stack6.getChildren().addAll(new Rectangle(100,30,Color.BLACK), new Label("3"));


        GridPane.setConstraints(stack1, 1, 0);
        GridPane.setConstraints(stack2, 3, 0);
        GridPane.setConstraints(stack3, 5, 0);
        GridPane.setConstraints(stack4, 1, 13);
        GridPane.setConstraints(stack5, 3, 13);
        GridPane.setConstraints(stack6, 5, 13);

        grid.getChildren().addAll(stack1,stack2,stack3,stack4,stack5,stack6);

    }

    public String opponentGuess(Evidence murderCase){
        Random random = new Random();
        int numberPlace = random.nextInt(1);
        int numberTool = random.nextInt(1);
        int numberGender = random.nextInt(1);
        int numberTime = random.nextInt(1);
        System.out.println(murderCase);
        System.out.println(numberPlace);
        System.out.println(numberTool);
        System.out.println(numberGender);
        System.out.println(numberTime);
        String place;
        String tool;
        String gender;
        String time;
        if(createdCards.get(2).isVisible() && createdCards.get(5).isVisible() || createdCards.get(1).isVisible() && createdCards.get(2).isVisible()){
            finalCardGuess = murderCase.printOutGender()+" "+murderCase.printOutTime()+" "+murderCase.printOutTool()+" "+murderCase.printOutPlace();
        }
        if(createdCards.get(2).isVisible()){
            if(numberPlace == 0){
                place = "HOUSE";
            } else {place = "GARDEN";}
            finalCardGuess = murderCase.printOutGender()+" "+murderCase.printOutTime()+" "+murderCase.printOutTool()+" "+place;
        }
        if(createdCards.get(1).isVisible() && createdCards.get(4).isVisible()){
            if(numberPlace == 0){
                place = "HOUSE";
            } else {place = "GARDEN";}
            if(numberTool == 0){
                tool = "GUN";
            } else {tool = "KNIFE";}
            finalCardGuess = murderCase.printOutGender()+" "+murderCase.printOutTime()+" "+tool+" "+place;
        }
        if(createdCards.get(1).isVisible()){
            if(numberPlace == 0){
                place = "HOUSE";
            } else {place = "GARDEN";}
            if(numberTool == 0){
                tool = "GUN";
            } else {tool = "KNIFE";}
            if(numberTime == 0){
                time = "DAY";
            } else {time = "NIGHT";}
            finalCardGuess = murderCase.printOutGender()+" "+time+" "+tool+" "+place;
        } else {
            if(numberPlace == 0){
                place = "HOUSE";
            } else {place = "GARDEN";}
            if(numberTool == 0){
                tool = "GUN";
            } else {tool = "KNIFE";}
            if(numberTime == 0){
                time = "DAY";
            } else {time = "NIGHT";}
            if(numberGender == 0){
                gender = "WOMAN";
            } else {gender = "MAN";}
            finalCardGuess = gender+" "+time+" "+tool+" "+place;
        }
       return finalCardGuess;
    }

    public void restartTheGame(){
        for (int i = 0; i<createdCards.size(); i++){
            createdCards.get(i).setVisible(false);
        }
        buttonStart.setVisible(true);
        guessButton.setVisible(false);
        finishRound.setVisible(false);
        caseCard.setVisible(false);
        opponentCaseCard.setVisible(false);
    }

}
