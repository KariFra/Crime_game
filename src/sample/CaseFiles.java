package sample;

import java.util.*;
import java.util.stream.Collectors;

public class CaseFiles {

    ArrayList<Evidence> newDeck = new ArrayList<>();
    Evidence newCard;
    ArrayList<Evidence> newCaseFileCards = new ArrayList<>();

Evidence MKGD = new Evidence("MAN","KNIFE", "GARDEN", "DAY","MKGD");
Evidence WKGD = new Evidence("WOMAN","KNIFE", "GARDEN", "DAY","WKGD");
Evidence MN = new Evidence("MAN","UNKNOWN", "UNKNOWN", "NIGHT","MN");
Evidence WKGN = new Evidence("WOMAN","KNIFE", "GARDEN", "NIGHT","WKGN");
Evidence WGHD = new Evidence("WOMAN","GUN", "HOUSE", "DAY","WGHD");
Evidence WKHD = new Evidence("WOMAN","KNIFE", "HOUSE", "DAY","WKHD");
Evidence MGD  = new Evidence("MAN","UNKNOWN", "GARDEN", "DAY","MGD");
Evidence MGHN = new Evidence("MAN","GUN", "HOUSE", "NIGHT","MGHN");
Evidence WGD = new Evidence("WOMAN","UNKNOWN", "GARDEN", "DAY","WGD");
Evidence WGGD = new Evidence("WOMAN","GUN", "GARDEN", "DAY","WGGD");
Evidence MGHD = new Evidence("MAN","GUN", "HOUSE", "DAY","MGHD");
Evidence WKN = new Evidence("WOMAN","KNIFE", "UNKNOWN", "NIGHT","WKN");

    public ArrayList<Evidence> createTheNewDeck(){

        newDeck.add(MKGD);
        newDeck.add(WKGD);
        newDeck.add(MN);
        newDeck.add(WKGN);
        newDeck.add(WGHD);
        newDeck.add(WKHD);
        newDeck.add(MGD);
        newDeck.add(MGHN);
        newDeck.add(WGD);
        newDeck.add(WGGD);
        newDeck.add(MGHD);
        newDeck.add(WKN);
//        newDeck.add( new Evidence("UNKNOWN","GUN", "GARDEN", "UNKNOWN"));
//        newDeck.add( new Evidence("WOMAN","KNIFE", "UNKNOWN", "UNKNOWN"));
//        newDeck.add( new Evidence("MAN","GUN", "GARDEN", "UNKNOWN"));
//        newDeck.add( new Evidence("WOMAN","GUN", "HOUSE", "UNKNOWN"));
//        newDeck.add( new Evidence("MAN","KNIFE", "HOUSE", "NIGHT"));
//        newDeck.add(new Evidence("MAN","KNIFE", "UNKNOWN", "NIGHT"));
//        newDeck.add( new Evidence("MAN","GUN", "GARDEN", "DAY"));
//        newDeck.add( new Evidence("MAN","KNIFE", "HOUSE", "DAY"));
//        newDeck.add( new Evidence("UNKNOWN","GUN", "GARDEN", "NIGHT"));
//        newDeck.add( new Evidence("WOMAN","GUN", "HOUSE", "NIGHT"));
//        newDeck.add( new Evidence("WOMAN","GUN", "GARDEN", "NIGHT"));
//        newDeck.add( new Evidence("UNKNOWN","UNKNOWN", "HOUSE", "DAY"));
//        newDeck.add( new Evidence("UNKNOWN","KNIFE", "HOUSE", "DAY"));
//        newDeck.add( new Evidence("MAN","KNIFE", "GARDEN", "NIGHT"));
//        newDeck.add( new Evidence("MAN","GUN", "GARDEN", "NIGHT"));
//        newDeck.add( new Evidence("WOMAN","KNIFE", "HOUSE", "NIGHT"));

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


    public Evidence pickTheCardFromTheDeck() {
       newCard = newDeck.get(0);
       return newCard;
    }

    public ArrayList<Evidence> pickPossibleCaseCards() {
        newCaseFileCards = newDeck.stream()
                .filter(e -> e.getGender() != "UNKNOWN")
                .filter(e -> e.getTool() != "UNKNOWN")
                .filter(e -> e.getTime() != "UNKNOWN")
                .filter(e -> e.getPlace() != "UNKNOWN")
                .collect(Collectors.toCollection(ArrayList::new));
        return newCaseFileCards;
    }

}

