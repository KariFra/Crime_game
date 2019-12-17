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
    Evidence murderCase;

    


    public void BeginTheGame(){
    }
    public Evidence chooseTheMurderCase(){
        caseFiles.pickPossibleCaseCards();
        murderCase = caseFiles.pickCaseFileCard();
        caseFiles.removeTheCaseFilesFromTheDeck(murderCase);
        return murderCase;

    }

    public void pickTheCardDuringGame(){
        Evidence card1 =caseFiles.pickTheCardFromTheDeck();
        caseFiles.removeTheCardFromTheDeck(card1);
        handDeck.add(card1);
    }

    public void askForEvidenceComparison(){

    }


}
