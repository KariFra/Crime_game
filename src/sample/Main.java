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
import javafx.stage.Stage;

import java.util.Random;

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


    Button buttonStart = new Button("Get the Case");
    Button buttonCompare = new Button("Compare   ");
    Button buttonCheckYourHand = new Button("Choose card");
    Button finishRound = new Button("Finish round");
    Button guessButton = new Button("Guess");

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
    boolean answer;

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



//inserting elements to the grid

        Main main = new Main();
        main.fillTheGrid(grid);

        GridPane.setConstraints(buttonStart, 7, 13);
        GridPane.setConstraints(buttonCompare, 7, 11);
        GridPane.setConstraints(buttonCheckYourHand,7,10);
        GridPane.setConstraints(finishRound, 7, 11);
        GridPane.setConstraints(guessButton,7,10);
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
        grid.getChildren().addAll(guessButton,finishRound,buttonCompare,opponentCaseCard,buttonCheckYourHand,buttonStart, circle1, circle2, circle3, circle4,caseCard, card1, card2, card3, card4,card5,card6,card7,card8,card9,card10,card11,card12,cardUp1,cardUp2,cardUp3,cardUp4,cardUp5,cardUp6,cardUp7,cardUp8,cardUp9,cardUp10,cardUp11,cardUp12);

        caseCard.setVisible(false);
        buttonCompare.setVisible(false);
        buttonCheckYourHand.setVisible(false);
        finishRound.setVisible(false);
        opponentCaseCard.setVisible(false);
        guessButton.setVisible(false);
        cardUp1.setVisible(false);
        cardUp2.setVisible(false);
        cardUp3.setVisible(false);
        cardUp4.setVisible(false);
        cardUp5.setVisible(false);
        cardUp6.setVisible(false);
        cardUp7.setVisible(false);
        cardUp8.setVisible(false);
        cardUp9.setVisible(false);
        cardUp10.setVisible(false);
        cardUp11.setVisible(false);
        cardUp12.setVisible(false);
        card1.setVisible(false);
        card2.setVisible(false);
        card3.setVisible(false);
        card4.setVisible(false);
        card5.setVisible(false);
        card6.setVisible(false);
        card7.setVisible(false);
        card8.setVisible(false);
        card9.setVisible(false);
        card10.setVisible(false);
        card11.setVisible(false);
        card12.setVisible(false);
        circle1.setVisible(false);
        circle2.setVisible(false);
        circle3.setVisible(false);
        circle4.setVisible(false);








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
            circle1.setFill(new ImagePattern(unknown));
            circle2.setFill(new ImagePattern(unknown));
            circle3.setFill(new ImagePattern(unknown));
            circle4.setFill(new ImagePattern(unknown));
            circle1.setVisible(true);
            circle2.setVisible(true);
            circle3.setVisible(true);
            circle4.setVisible(true);
            buttonCompare.setVisible(true);
            buttonCheckYourHand.setVisible(false);
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
            numberOfCommonEvidencesOpponent = 0;
            circle1.setVisible(false);
            circle2.setVisible(false);
            circle3.setVisible(false);
            circle4.setVisible(false);
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
                cardUp1.setFill(new ImagePattern(new Image("file:src/sample/assets/"+ chosenCard.getPicture()+".png")));
                cardUp1.setVisible(true);
            }
            if (numberOfCommonEvidencesOpponent<=1 && oneOrZeroOpponent==2){
                cardUp4.setFill(new ImagePattern(new Image("file:src/sample/assets/"+chosenCard.getPicture()+".png")));
                cardUp4.setVisible(true);
            }
            if (numberOfCommonEvidencesOpponent<=1 && oneOrZeroOpponent==3){
                cardUp7.setFill(new ImagePattern(new Image("file:src/sample/assets/"+chosenCard.getPicture()+".png")));
                cardUp7.setVisible(true);
            }
            if (numberOfCommonEvidencesOpponent<=1 && oneOrZeroOpponent==4){
                cardUp10.setFill(new ImagePattern(new Image("file:src/sample/assets/"+chosenCard.getPicture()+".png")));
                cardUp10.setVisible(true);
            }
            if (numberOfCommonEvidencesOpponent==2 && twoOpponent==1){
                cardUp2.setFill(new ImagePattern(new Image("file:src/sample/assets/"+chosenCard.getPicture()+".png")));
                cardUp2.setVisible(true);
            }
            if (numberOfCommonEvidencesOpponent==2 && twoOpponent==2){
                cardUp5.setFill(new ImagePattern(new Image("file:src/sample/assets/"+chosenCard.getPicture()+".png")));
                cardUp5.setVisible(true);
            }
            if (numberOfCommonEvidencesOpponent==2 && twoOpponent==3){
                cardUp8.setFill(new ImagePattern(new Image("file:src/sample/assets/"+chosenCard.getPicture()+".png")));
                cardUp8.setVisible(true);
            }
            if (numberOfCommonEvidencesOpponent==2 && twoOpponent==4){
                cardUp11.setFill(new ImagePattern(new Image("file:src/sample/assets/"+chosenCard.getPicture()+".png")));
                cardUp11.setVisible(true);
            }
            if (numberOfCommonEvidencesOpponent==3 && threeOpponent==1){
                cardUp3.setFill(new ImagePattern(new Image("file:src/sample/assets/"+chosenCard.getPicture()+".png")));
                cardUp3.setVisible(true);
            }
            if (numberOfCommonEvidences==3 && threeOpponent==2){
                cardUp6.setFill(new ImagePattern(new Image("file:src/sample/assets/"+chosenCard.getPicture()+".png")));
                cardUp6.setVisible(true);
            }
            if (numberOfCommonEvidencesOpponent==3 && threeOpponent==3){
                cardUp9.setFill(new ImagePattern(new Image("file:src/sample/assets/"+chosenCard.getPicture()+".png")));
                cardUp9.setVisible(true);
            }
            if (numberOfCommonEvidencesOpponent==3 && threeOpponent==4){
                cardUp12.setFill(new ImagePattern(new Image("file:src/sample/assets/"+chosenCard.getPicture()+".png")));
                cardUp12.setVisible(true);
            }

            numberOfCommonEvidencesOpponent = 0;
        });

        finishRound.setOnAction((click) ->{
            guessButton.setVisible(true);
            numberOfCommonEvidences = 0;
            if (clickCalculator<6){buttonCheckYourHand.setVisible(true);}
            if (clickCalculator==6){finalCardGuess =main.opponentGuess(murderCase);
                if (finalCardGuess.equals(murderCase.printOutGender()+" "+murderCase.printOutTime()+" "+murderCase.printOutTool()+" "+murderCase.printOutPlace())){

                    System.out.println("You were too slow this time...");
                } else{
                    System.out.println("You still have chance to solve the case");
                }
            }
            if (card3.isVisible() && card6.isVisible() || card2.isVisible() && card3.isVisible()){
                finalCardGuess =main.opponentGuess(murderCase);
                if (finalCardGuess.equals(murderCase.printOutGender()+" "+murderCase.printOutTime()+" "+murderCase.printOutTool()+" "+murderCase.printOutPlace())){
                    System.out.println("You were too slow this time...");
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
                card1.setFill(new ImagePattern(new Image("file:src/sample/assets/"+ opponentChosenCard.getPicture()+".png")));
                card1.setVisible(true);
            }
            if (numberOfCommonEvidences<=1 && oneOrZero==2){
                card4.setFill(new ImagePattern(new Image("file:src/sample/assets/"+opponentChosenCard.getPicture()+".png")));
                card4.setVisible(true);
            }
            if (numberOfCommonEvidences<=1 && oneOrZero==3){
                card7.setFill(new ImagePattern(new Image("file:src/sample/assets/"+opponentChosenCard.getPicture()+".png")));
                card7.setVisible(true);
            }
            if (numberOfCommonEvidences<=1 && oneOrZero==4){
                card10.setFill(new ImagePattern(new Image("file:src/sample/assets/"+opponentChosenCard.getPicture()+".png")));
                card10.setVisible(true);
            }
            if (numberOfCommonEvidences==2 && two==1){
                card2.setFill(new ImagePattern(new Image("file:src/sample/assets/"+opponentChosenCard.getPicture()+".png")));
                card2.setVisible(true);
            }
            if (numberOfCommonEvidences==2 && two==2){
                card5.setFill(new ImagePattern(new Image("file:src/sample/assets/"+opponentChosenCard.getPicture()+".png")));
                card5.setVisible(true);
            }
            if (numberOfCommonEvidences==2 && two==3){
                card8.setFill(new ImagePattern(new Image("file:src/sample/assets/"+opponentChosenCard.getPicture()+".png")));
                card8.setVisible(true);
            }
            if (numberOfCommonEvidences==2 && two==4){
                card11.setFill(new ImagePattern(new Image("file:src/sample/assets/"+opponentChosenCard.getPicture()+".png")));
                card11.setVisible(true);
            }
            if (numberOfCommonEvidences==3 && three==1){
                card3.setFill(new ImagePattern(new Image("file:src/sample/assets/"+opponentChosenCard.getPicture()+".png")));
                card3.setVisible(true);
            }
            if (numberOfCommonEvidences==3 && three==2){
                card6.setFill(new ImagePattern(new Image("file:src/sample/assets/"+opponentChosenCard.getPicture()+".png")));
                card6.setVisible(true);
            }
            if (numberOfCommonEvidences==3 && three==3){
                card9.setFill(new ImagePattern(new Image("file:src/sample/assets/"+opponentChosenCard.getPicture()+".png")));
                card9.setVisible(true);
            }
            if (numberOfCommonEvidences==3 && three==4){
                card12.setFill(new ImagePattern(new Image("file:src/sample/assets/"+opponentChosenCard.getPicture()+".png")));
                card12.setVisible(true);
            }

            numberOfCommonEvidences = 0;
        });

        guessButton.setOnAction((click) ->{
            opponentGuessedCard = guess.guessOpponentCard();
            while (opponentGuessedCard != null) {
                System.out.println("The card that I guessed " + opponentGuessedCard);
                String opponentCard = opponentMurderCase.printOutGender() + " " + opponentMurderCase.printOutTime() + " " + opponentMurderCase.printOutTool() + " " + opponentMurderCase.printOutPlace();
                System.out.println("The card that was murder case " + opponentCard);
                if (opponentGuessedCard.equals(opponentCard)) {
                    finalWindow.showWindow(new Label("You were right Scherlock!"));
                    window.close();
//                    if (answer){
//                        window.
//                    }
                    System.out.println("You were right Scherlock!");
                } else {
                    finalWindow.showWindow(new Label("Not even close..."));
                    System.out.println("Not even close...");
                }
            }
        });

        Scene scene = new Scene(grid, 1400.00, 1000.00, Color.BLACK);
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
        String place;
        String tool;
        String gender;
        String time;
        if(card3.isVisible() && card6.isVisible() || card2.isVisible() && card3.isVisible()){
            finalCardGuess = murderCase.printOutGender()+" "+murderCase.printOutTime()+" "+murderCase.printOutTool()+" "+murderCase.printOutPlace();
        }
        if(card3.isVisible()){
            if(numberPlace == 0){
                place = "HOUSE";
            } else {place = "GARDEN";}
            finalCardGuess = murderCase.printOutGender()+" "+murderCase.printOutTime()+" "+murderCase.printOutTool()+" "+place;
        }
        if(card2.isVisible() && card5.isVisible()){
            if(numberPlace == 0){
                place = "HOUSE";
            } else {place = "GARDEN";}
            if(numberTool == 0){
                tool = "GUN";
            } else {tool = "KNIFE";}
            finalCardGuess = murderCase.printOutGender()+" "+murderCase.printOutTime()+" "+tool+" "+place;
        }
        if(card2.isVisible()){
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


}
