package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.HashMap;


public class Guess {
    static String guessedCardGender;
    static String guessedCardTool;
    static String guessedCardPlace;
    static String guessedCardTime;
    static String guessedCard;

    ArrayList< RadioButton> checkButtonList = new ArrayList<>();
    ArrayList< Rectangle> optionsList = new ArrayList<>();

    Image man = new Image("file:src/sample/assets/MAN.png");
    Image woman = new Image("file:src/sample/assets/WOMAN.png");
    Image knife = new Image("file:src/sample/assets/KNIFE.png");
    Image gun = new Image("file:src/sample/assets/GUN.png");
    Image house = new Image("file:src/sample/assets/HOUSE.png");
    Image garden = new Image("file:src/sample/assets/GARDEN.png");
    Image day = new Image("file:src/sample/assets/DAY.png");
    Image night = new Image("file:src/sample/assets/NIGHT.png");

    public String guessOpponentCard(){
        Stage opponentCardsPossibilities = new Stage();
        opponentCardsPossibilities.setTitle("Solve the case");
        opponentCardsPossibilities.setMinWidth(350);
        opponentCardsPossibilities.initModality(Modality.APPLICATION_MODAL);

        Button endWindow = new Button("Close the window");
        endWindow.setStyle("-fx-background-color: white;-fx-font-size: 24 arial;-fx-text-fill: black;");
        endWindow.setOnAction(e ->opponentCardsPossibilities.close());
        Label newLabel = new Label("After ticking right buttons, close the window to check your answer!");
        newLabel.setStyle("-fx-font: 24 arial;-fx-text-fill: white;");

        ArrayList <Image> pictures = new ArrayList<>();
        pictures.add(0,knife);
        pictures.add(1,gun);
        pictures.add(2,woman);
        pictures.add(3,man);
        pictures.add(4,house);
        pictures.add(5,garden);
        pictures.add(6,day);
        pictures.add(7,night);

        ToggleGroup groupTool = new ToggleGroup();
        ToggleGroup groupGender = new ToggleGroup();
        ToggleGroup groupPlace = new ToggleGroup();
        ToggleGroup groupTime = new ToggleGroup();

        int number=0;

        for (int i =0; i<8;i++){
            Rectangle option = new Rectangle(70.00,70.00);
            option.setFill(new ImagePattern(pictures.get(i)));
            optionsList.add(option);
            RadioButton checkButton = new RadioButton();
            if(number == 0 || number == 1) {
                checkButton.setToggleGroup(groupTool);
            }
            else if (number == 2 || number == 3){
                checkButton.setToggleGroup(groupGender);
            }
            else if (number == 4 || number == 5){
                checkButton.setToggleGroup(groupPlace);
            }
            else if (number == 6 || number == 7){
                checkButton.setToggleGroup(groupTime);

            }
            checkButtonList.add(checkButton);
            number++;
        }

        groupGender.selectedToggleProperty().addListener(new ChangeListener<Toggle>()
        {
            public void changed(ObservableValue<? extends Toggle> ob,
                                Toggle o, Toggle n)
            {
                RadioButton rb = (RadioButton)groupGender.getSelectedToggle();

                if (rb != null) {
                    if (checkButtonList.get(2).isSelected()) {
                        guessedCardGender="WOMAN";
                    }
                    if (checkButtonList.get(3).isSelected()) {
                        guessedCardGender="MAN";

                    }
                    guessedCard = guessedCardGender+ " " +guessedCardTime+ " " +guessedCardTool+ " " +guessedCardPlace;
                }
            }
        });
        groupTime.selectedToggleProperty().addListener(new ChangeListener<Toggle>()
        {
            public void changed(ObservableValue<? extends Toggle> ob,
                                Toggle o, Toggle n)
            {
                RadioButton rb = (RadioButton)groupTime.getSelectedToggle();

                if (rb != null) {
                    if (checkButtonList.get(6).isSelected()) {
                        guessedCardTime="DAY";
                    }
                    if (checkButtonList.get(7).isSelected()) {
                        guessedCardTime="NIGHT";
                    }
                    guessedCard = guessedCardGender+ " " +guessedCardTime+ " " +guessedCardTool+ " " +guessedCardPlace;
                }

            }
        });
        groupTool.selectedToggleProperty().addListener(new ChangeListener<Toggle>()
        {
            public void changed(ObservableValue<? extends Toggle> ob,
                                Toggle o, Toggle n)
            {
                RadioButton rb = (RadioButton)groupTool.getSelectedToggle();

                if (rb != null) {
                    if (checkButtonList.get(0).isSelected()) {
                        guessedCardTool="KNIFE";
                    }
                    if (checkButtonList.get(1).isSelected()) {
                        guessedCardTool="GUN";
                    }
                    guessedCard = guessedCardGender+ " " +guessedCardTime+ " " +guessedCardTool+ " " +guessedCardPlace;
                }
            }
        });
        groupPlace.selectedToggleProperty().addListener(new ChangeListener<Toggle>()
        {
            public void changed(ObservableValue<? extends Toggle> ob,
                                Toggle o, Toggle n)
            {
                RadioButton rb = (RadioButton)groupPlace.getSelectedToggle();

                if (rb != null) {
                    if (checkButtonList.get(5).isSelected()) {
                        guessedCardPlace="GARDEN";
                    }
                    if (checkButtonList.get(4).isSelected()) {
                        guessedCardPlace="HOUSE";
                    }
                    guessedCard = guessedCardGender+ " " +guessedCardTime+ " " +guessedCardTool+ " " +guessedCardPlace;
                }
            }
        });

        FlowPane flow = new FlowPane(20.0, 20.0,optionsList.get(2),checkButtonList.get(2),optionsList.get(0),checkButtonList.get(0),optionsList.get(4),checkButtonList.get(4),optionsList.get(6),checkButtonList.get(6),newLabel,endWindow,optionsList.get(3),checkButtonList.get(3),optionsList.get(1),checkButtonList.get(1),optionsList.get(5),checkButtonList.get(5),optionsList.get(7),checkButtonList.get(7));
        flow.setPadding(new Insets(10));
        flow.setStyle("-fx-background-color: black");


        Scene scene = new Scene(flow,1000, 250, Color.BLACK);
        opponentCardsPossibilities.setScene(scene);
        opponentCardsPossibilities.showAndWait();

        return guessedCard;

    }
}
