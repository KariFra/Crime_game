package sample;

import javafx.scene.layout.GridPane;

import java.util.*;
import java.util.stream.Collectors;

public class CaseFiles {

    ArrayList<Evidence> newDeck = new ArrayList<>();
    Evidence newCard;
    Evidence newCaseFileCard;



    public ArrayList<Evidence> createTheNewDeck(){

        newDeck.add(new Evidence("MAN","KNIFE", "GARDEN", "DAY"));
        newDeck.add(new Evidence("MAN","KNIFE", "GARDEN", "DAY"));
        newDeck.add( new Evidence("WOMAN","KNIFE", "GARDEN", "DAY"));
        newDeck.add(new Evidence("MAN","UNKNOWN", "UNKNOWN", "NIGHT"));
        newDeck.add( new Evidence("WOMAN","KNIFE", "GARDEN", "NIGHT"));
        newDeck.add(new Evidence("WOMAN","GUN", "HOUSE", "DAY"));
        newDeck.add( new Evidence("WOMAN","KNIFE", "HOUSE", "DAY"));
        newDeck.add(new Evidence("MAN","UNKNOWN", "GARDEN", "DAY"));
        newDeck.add(new Evidence("MAN","GUN", "HOUSE", "NIGHT"));
        newDeck.add(new Evidence("WOMAN","UNKNOWN", "GARDEN", "DAY"));
        newDeck.add(new Evidence("WOMAN","GUN", "GARDEN", "DAY"));
        newDeck.add(new Evidence("MAN","GUN", "HOUSE", "DAY"));
        newDeck.add( new Evidence("WOMAN","KNIFE", "UNKNOWN", "NIGHT"));
        newDeck.add( new Evidence("UNKNOWN","GUN", "GARDEN", "UNKNOWN"));
        newDeck.add( new Evidence("WOMAN","KNIFE", "UNKNOWN", "UNKNOWN"));
        newDeck.add( new Evidence("MAN","GUN", "GARDEN", "UNKNOWN"));
        newDeck.add( new Evidence("WOMAN","GUN", "HOUSE", "UNKNOWN"));
        newDeck.add( new Evidence("MAN","KNIFE", "HOUSE", "NIGHT"));
        newDeck.add(new Evidence("MAN","KNIFE", "UNKNOWN", "NIGHT"));
        newDeck.add( new Evidence("MAN","GUN", "GARDEN", "DAY"));
        newDeck.add( new Evidence("MAN","KNIFE", "HOUSE", "DAY"));
        newDeck.add( new Evidence("UNKNOWN","GUN", "GARDEN", "NIGHT"));
        newDeck.add( new Evidence("WOMAN","GUN", "HOUSE", "NIGHT"));
        newDeck.add( new Evidence("WOMAN","GUN", "GARDEN", "NIGHT"));
        newDeck.add( new Evidence("UNKNOWN","UNKNOWN", "HOUSE", "DAY"));
        newDeck.add( new Evidence("UNKNOWN","KNIFE", "HOUSE", "DAY"));
        newDeck.add( new Evidence("MAN","KNIFE", "GARDEN", "NIGHT"));
        newDeck.add( new Evidence("MAN","GUN", "GARDEN", "NIGHT"));
        newDeck.add( new Evidence("WOMAN","KNIFE", "HOUSE", "NIGHT"));

        return newDeck;
    }

    public ArrayList<Evidence> mixTheDeck(){

        for (int i =0; i<newDeck.size(); i++){
            Random random = new Random();
            Evidence card = newDeck.get(i);
            HashSet<Integer> setOfNumbers = new HashSet<>();
            int randomPosition = random.nextInt(newDeck.size());
            setOfNumbers.add(randomPosition);
            newDeck.remove(card);
            newDeck.add(randomPosition,card);
        }
        return newDeck;
    }





    public ArrayList<Evidence> removeTheCardFromTheDeck(Evidence newCard){
        int number = newDeck.indexOf(newCard);
        newDeck.remove(number);
        return newDeck;
    }
    public ArrayList<Evidence> removeTheCaseFilesFromTheDeck(Evidence newCaseFileCard){
        int number = newDeck.indexOf(newCaseFileCard);
        newDeck.remove(number);
        return newDeck;
    }

    public ArrayList<Solution> fillNewSolutionDeck(){
        ArrayList<Solution> solutionCards = new ArrayList<>();
        solutionCards.add(new Solution(1,"One drop"));
        solutionCards.add(new Solution(2,"Two drops"));
        solutionCards.add(new Solution(3,"Three drops"));

        return solutionCards;
    }


    public Evidence pickTheCardFromTheDeck(int i) {
       newCard = newDeck.get(i);
       return newCard;
    }

    public Evidence pickTheCaseFilesFromTheDeck() {
        ArrayList<Evidence> possibleCaseFiles = (ArrayList<Evidence>) newDeck.stream()
                .filter(e -> e.getGender() != "UNKNOWN")
                .filter(e -> e.getTool() != "UNKNOWN")
                .filter(e -> e.getTime() != "UNKNOWN")
                .filter(e -> e.getPlace() != "UNKNOWN")
                .collect(Collectors.toList());
        newCaseFileCard = possibleCaseFiles.get(0);
        System.out.println(" Yours new murder case is as follows " + newCaseFileCard);
        return newCaseFileCard;
    }
}

