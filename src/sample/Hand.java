package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.awt.*;
import java.util.ArrayList;



public class Hand {

static Evidence chosenCard;
static Evidence opponentMurderCase;
    ArrayList<Evidence> handDeck = new ArrayList<>();
    Evidence murderCase;

    CaseFiles caseFiles;

    public Evidence displayHand(){
        Stage handCards = new Stage();
        handCards.setTitle("Your deck");
        handCards.setMinWidth(350);
        handCards.initModality(Modality.APPLICATION_MODAL);


        Rectangle card1 = new Rectangle(260.00, 70.00);
        Rectangle card2 = new Rectangle(260.00, 70.00);
        Rectangle card3 = new Rectangle(260.00, 70.00);
        ToggleGroup group = new ToggleGroup();
        RadioButton chooseCard1 = new RadioButton("Card 1");
        RadioButton chooseCard2 = new RadioButton("Card 2");
        RadioButton chooseCard3 = new RadioButton("Card 3");

        chooseCard1.setToggleGroup(group);
        chooseCard2.setToggleGroup(group);
        chooseCard3.setToggleGroup(group);

        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>()
        {
            public void changed(ObservableValue<? extends Toggle> ob,
                                Toggle o, Toggle n)
            {

                RadioButton rb = (RadioButton)group.getSelectedToggle();

                if (rb != null) {
                    if (chooseCard1.isSelected()) {
                        chosenCard = handDeck.get(0);
                        handDeck.remove(0);
                    }
                    if (chooseCard2.isSelected()) {
                        chosenCard = handDeck.get(1);
                        handDeck.remove(1);
                    }
                    if (chooseCard3.isSelected()) {
                        chosenCard = handDeck.get(2);
                        handDeck.remove(2);
                    }
                    handCards.close();
                }
            }
        });




        System.out.println(handDeck);

        card1.setFill(new ImagePattern(new Image("file:src/sample/assets/"+handDeck.get(0).getPicture()+".png")));
        card2.setFill(new ImagePattern(new Image("file:src/sample/assets/"+handDeck.get(1).getPicture()+".png")));
        card3.setFill(new ImagePattern(new Image("file:src/sample/assets/"+handDeck.get(2).getPicture()+".png")));

        VBox imageCard = new VBox();
        imageCard.getChildren().addAll(card1,card2,card3);
        VBox checkCard = new VBox();
        checkCard.getChildren().addAll(chooseCard1,chooseCard2,chooseCard3);
        HBox layout = new HBox();
        layout.getChildren().addAll(imageCard,checkCard);

        Scene scene = new Scene(layout,350, 210.00, Color.BLACK);
        handCards.setScene(scene);
        handCards.showAndWait();

        return chosenCard;
    }


    public Hand(CaseFiles caseFiles) {
        this.caseFiles = caseFiles;

    }

    public ArrayList<Evidence> BeginTheGameWithThreeCards() {
        for (int i = 0; i < 3; i++) {
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

    public Evidence chooseOpponentMurderCase(){
        caseFiles.pickPossibleCaseCards();
        opponentMurderCase = caseFiles.pickPossibleCaseCards().get(0);
        caseFiles.removeTheCaseFilesFromTheDeck(opponentMurderCase);
        return opponentMurderCase;

    }

    public ArrayList<Evidence> pickTheCardDuringGame(){
        if(handDeck.size()<3){
            handDeck.add(caseFiles.pickTheCardFromTheDeck());
        caseFiles.removeTheCardFromTheDeck(caseFiles.pickTheCardFromTheDeck());
        }
        return handDeck;
    }




}
