package sample;

import java.util.ArrayList;
import java.util.Random;

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
        Random randome = new Random();
        for (int i =0; i<newDeck.size(); i++){
            int randomePosition = randome.nextInt(newDeck.size());
            newDeck.add(randomePosition,newDeck.get(i));
        }
        return newDeck;
    }

    public Evidence pickTheCardFromTheDeck(int n){

        newCard = newDeck.get(n);
        return newCard;
    }
    public Evidence pickTheCaseFilesFromTheDeck(int n){
        if ( newDeck.get(n).getGender() == "UNKNOWN" || newDeck.get(n).getTool() == "UNKNOWN" || newDeck.get(n).getPlace() == "UNKNOWN" || newDeck.get(n).getTime() == "UNKNOWN"){
            n+=1;
        }
        newCard = newDeck.get(n);
        System.out.println(" Yours new murder case is as follows " + newCard);
        return newCaseFileCard;
    }
    public ArrayList<Evidence> removeTheCardFromTheDeck(Evidence newCard){
        int number = newDeck.indexOf(newCard);
        newDeck.remove(number);
        return newDeck;
    }
//    public ArrayList<Evidence> removeTheCaseFilesFromTheDeck(Evidence newCaseFileCard){
//        int number = newDeck.indexOf(newCaseFileCard);
//        newDeck.remove(number);
//        return newDeck;
//    }

}

