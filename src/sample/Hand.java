package sample;

import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.ImagePattern;

import java.util.ArrayList;



public class Hand {

    Image man = new Image("file:src/sample/assets/MAN.png");
    Image woman = new Image("file:src/sample/assets/WOMAN.png");
    Image knife = new Image("file:src/sample/assets/KNIFE.png");
    Image gun = new Image("file:src/sample/assets/GUN.png");
    Image inside = new Image("file:src/sample/assets/INSIDE.png");
    Image outside = new Image("file:src/sample/assets/OUTSIDE.png");
    Image day = new Image("file:src/sample/assets/DAY.png");
    Image night = new Image("file:src/sample/assets/NIGHT.png");

    CaseFiles caseFiles = new CaseFiles();
    ArrayList<Evidence> handDeck = new ArrayList<>();
    ArrayList<Evidence> murderCases = new ArrayList();
    ArrayList<Solution> playerOneSolutionCards = new ArrayList();
    ArrayList<Solution> playerTwoSolutionCards = new ArrayList();
    


    public void getTheCardsToBeginTheGame(){
        caseFiles.createTheNewDeck();
        caseFiles.mixTheDeck();
        Evidence card1 =caseFiles.pickTheCardFromTheDeck(0);
        Evidence card2 =caseFiles.pickTheCardFromTheDeck(1);
        Evidence card3 =caseFiles.pickTheCardFromTheDeck(2);
        handDeck.add(card1);
        handDeck.add(card2);
        handDeck.add(card3);
        caseFiles.removeTheCardFromTheDeck(card1);
        caseFiles.removeTheCardFromTheDeck(card2);
        caseFiles.removeTheCardFromTheDeck(card3);
        playerOneSolutionCards = caseFiles.fillNewSolutionDeck();
        playerTwoSolutionCards = caseFiles.fillNewSolutionDeck();
        System.out.println(handDeck);

    }
    public void chooseTheMurderCase(){
        Evidence murderCase = caseFiles.pickTheCaseFilesFromTheDeck();
        murderCases.add(murderCase);
        caseFiles.removeTheCaseFilesFromTheDeck(murderCase);
        System.out.println(murderCases);

    }

    public void pickTheCardDuringGame(){
        Evidence card1 =caseFiles.pickTheCardFromTheDeck(1);
        caseFiles.removeTheCardFromTheDeck(card1);
        handDeck.add(card1);
    }

    public void askForEvidenceComparison(){

    }


}
