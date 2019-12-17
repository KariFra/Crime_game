package sample;

import java.util.*;
import java.util.stream.Collectors;

public class CaseFiles {

    ArrayList<Evidence> newDeck = new ArrayList<>();
    Evidence newCard;
    Evidence newCaseFileCard;
    ArrayList<Evidence> newCaseFileCards = new ArrayList<>();

Evidence MKGD = new Evidence("MAN","KNIFE", "GARDEN", "DAY","file:src/sample/assets/MKGD.png)");
Evidence WKGD = new Evidence("WOMAN","KNIFE", "GARDEN", "DAY","file:src/sample/assets/WKGD.png)");
Evidence MN = new Evidence("MAN","UNKNOWN", "UNKNOWN", "NIGHT","file:src/sample/assets/MN.png)");
Evidence WKGN = new Evidence("WOMAN","KNIFE", "GARDEN", "NIGHT","file:src/sample/assets/WKGN.png)");
Evidence WGHD = new Evidence("WOMAN","GUN", "HOUSE", "DAY","file:src/sample/assets/WGHD.png)");
Evidence WKHD = new Evidence("WOMAN","KNIFE", "HOUSE", "DAY","file:src/sample/assets/WKHD.png)");
Evidence MGD  = new Evidence("MAN","UNKNOWN", "GARDEN", "DAY","file:src/sample/assets/MGD.png)");
Evidence MGHN = new Evidence("MAN","GUN", "HOUSE", "NIGHT","file:src/sample/assets/MGHN.png)");
Evidence WGD = new Evidence("WOMAN","UNKNOWN", "GARDEN", "DAY","file:src/sample/assets/WGD.png)");
Evidence WGGD = new Evidence("WOMAN","GUN", "GARDEN", "DAY","file:src/sample/assets/WGGD.png)");
Evidence MGHD = new Evidence("MAN","GUN", "HOUSE", "DAY","file:src/sample/assets/MGHD.png)");
Evidence WKN = new Evidence("WOMAN","KNIFE", "UNKNOWN", "NIGHT","file:src/sample/assets/WKN.png)");

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
    public Evidence pickCaseFileCard(){
        newCaseFileCards.get(0);
        return newCaseFileCard;
    }
}

