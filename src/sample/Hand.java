package sample;

import java.util.ArrayList;

public class Hand {

    CaseFiles caseFiles = new CaseFiles();
    ArrayList<Evidence> handDeck = new ArrayList<>();
    ArrayList<Evidence> murderCases = new ArrayList();


    public ArrayList<Evidence> GetTheCardsToBeginTheGame(){

        caseFiles.createTheNewDeck();
//        caseFiles.mixTheDeck();
        Evidence card1 =caseFiles.pickTheCardFromTheDeck(0);
        Evidence card2 =caseFiles.pickTheCardFromTheDeck(1);
        Evidence card3 =caseFiles.pickTheCardFromTheDeck(2);
        handDeck.add(card1);
        handDeck.add(card2);
        handDeck.add(card3);
        caseFiles.removeTheCardFromTheDeck(card1);
        caseFiles.removeTheCardFromTheDeck(card2);
        caseFiles.removeTheCardFromTheDeck(card3);
        System.out.println(handDeck);
        return handDeck;
    }
    public ArrayList<Evidence> chooseTheMurderCase(){
        Evidence murderCase =caseFiles.pickTheCaseFilesFromTheDeck(1);
        murderCases.add(murderCase);
//        caseFiles.removeTheCaseFilesFromTheDeck(murderCase);
        System.out.println(murderCases);
        return murderCases;
    }

    public ArrayList<Evidence> pickTheCardDuringGame(){
        Evidence card1 =caseFiles.pickTheCardFromTheDeck(1);
        caseFiles.removeTheCardFromTheDeck(card1);
        handDeck.add(card1);
        return handDeck;
    }

    public void askForEvidenceComparison(){

    }
}
