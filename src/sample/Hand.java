package sample;

import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;
import java.util.ArrayList;



public class Hand {



    public void displayHand(){
        Stage handCards = new Stage();
        handCards.setTitle("Your deck");
        handCards.setMinWidth(300);
        handCards.initModality(Modality.APPLICATION_MODAL);


        Rectangle card1 = new Rectangle(260.00, 70.00);
        Rectangle card2 = new Rectangle(260.00, 70.00);
        Rectangle card3 = new Rectangle(260.00, 70.00);

        card1.setFill(new ImagePattern(new Image("file:src/sample/assets/"+handDeck.get(0).getPicture()+".png")));
        card2.setFill(new ImagePattern(new Image("file:src/sample/assets/"+handDeck.get(1).getPicture()+".png")));
        card3.setFill(new ImagePattern(new Image("file:src/sample/assets/"+handDeck.get(2).getPicture()+".png")));

        VBox layout = new VBox();
        layout.getChildren().addAll(card1,card2,card3);

        Scene scene = new Scene(layout,300.00, 300.00, Color.BLACK);
        handCards.setScene(scene);
        handCards.show();
    }


    ArrayList<Evidence> handDeck = new ArrayList<>();
    Evidence murderCase;
    CaseFiles caseFiles;

    public Hand(CaseFiles caseFiles) {
        this.caseFiles = caseFiles;

    }

    public ArrayList<Evidence> BeginTheGameWithThreeCards() {
        for (int i = 0; i < 2; i++) {
            handDeck.add(caseFiles.pickTheCardFromTheDeck());
            caseFiles.removeTheCardFromTheDeck(caseFiles.pickTheCardFromTheDeck());
        }
        return handDeck;
    }
    public Evidence chooseTheMurderCase(){
        caseFiles.pickPossibleCaseCards();
        murderCase = caseFiles.pickPossibleCaseCards().get(0);
        caseFiles.removeTheCaseFilesFromTheDeck(murderCase);
        return murderCase;

    }

//    public void pickTheCardDuringGame(){
//        Evidence card1 =caseFiles.pickTheCardFromTheDeck();
//        caseFiles.removeTheCardFromTheDeck(card1);
//        handDeck.add(card1);
//    }

    public void askForEvidenceComparison(){

    }


}
