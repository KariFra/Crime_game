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
Evidence GG = new Evidence("UNKNOWN","GUN", "GARDEN", "UNKNOWN","GG");
Evidence WK = new Evidence("WOMAN","KNIFE", "UNKNOWN", "UNKNOWN","WK");
Evidence MGG = new Evidence("MAN","GUN", "GARDEN", "UNKNOWN","MGG");
Evidence WGH = new Evidence("WOMAN","GUN", "HOUSE", "UNKNOWN","WGH");
Evidence MKHN = new Evidence("MAN","KNIFE", "HOUSE", "NIGHT","MKHN");
Evidence MKN = new Evidence("MAN","KNIFE", "UNKNOWN", "NIGHT","MKN");
Evidence MGGD = new Evidence("MAN","GUN", "GARDEN", "DAY","MGGD");
Evidence MKHD = new Evidence("MAN","KNIFE", "HOUSE", "DAY","MKHD");
Evidence GGN = new Evidence("UNKNOWN","GUN", "GARDEN", "NIGHT","GGN");
Evidence WGHN = new Evidence("WOMAN","GUN", "HOUSE", "NIGHT","WGHN");
Evidence WGGN = new Evidence("WOMAN","GUN", "GARDEN", "NIGHT","WGGN");
Evidence HD =  new Evidence("UNKNOWN","UNKNOWN", "HOUSE", "DAY","HD");
Evidence KHD= new Evidence("UNKNOWN","KNIFE", "HOUSE", "DAY","KHD");
Evidence MKGN =new Evidence("MAN","KNIFE", "GARDEN", "NIGHT","MKGN");
Evidence MGGN = new Evidence("MAN","GUN", "GARDEN", "NIGHT","MGGN");
Evidence WKHN = new Evidence("WOMAN","KNIFE", "HOUSE", "NIGHT","WKHN");

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
        newDeck.add(GG);
        newDeck.add(WK);
        newDeck.add(MGG);
        newDeck.add(WGH);
        newDeck.add(MKHN);
        newDeck.add(MKN);
        newDeck.add(MGGD);
        newDeck.add(MKHD);
        newDeck.add(GGN);
        newDeck.add(WGHN);
        newDeck.add(WGGN);
        newDeck.add(HD);
        newDeck.add(KHD);
        newDeck.add(MKGN);
        newDeck.add(MGGN);
        newDeck.add(WKHN);

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

    public void removeTheCardFromTheDeck(Evidence newCard){
        newDeck.remove(newDeck.indexOf(newCard));
    }

    public void removeTheCaseFilesFromTheDeck(Evidence murderCase){
        newDeck.remove(newDeck.indexOf(murderCase));
    }

    public Evidence pickTheCardFromTheDeck() {
       newCard = newDeck.get(0);
       return newCard;
    }

    public ArrayList<Evidence> pickPossibleCaseCards() {
        newCaseFileCards = newDeck.stream()
                .filter(e -> !e.getGender().equals("UNKNOWN"))
                .filter(e -> !e.getTool().equals("UNKNOWN"))
                .filter(e -> !e.getTime().equals("UNKNOWN"))
                .filter(e -> !e.getPlace().equals("UNKNOWN"))
                .collect(Collectors.toCollection(ArrayList::new));
        return newCaseFileCards;
    }

}

