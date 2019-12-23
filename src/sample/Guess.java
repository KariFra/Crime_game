package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.stage.Modality;
import javafx.stage.Stage;



public class Guess {
    static String guessedCard;



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

        Label newLabel = new Label("After ticking right buttons, close the window to check your answer!");
        Rectangle circleKnife = new Rectangle(70.00,70.00);
        circleKnife.setFill(new ImagePattern(knife));
        Rectangle circleGun = new Rectangle(70.00,70.00);
        circleGun.setFill(new ImagePattern(gun));
        Rectangle circleWoman = new Rectangle(70.00,70.00);
        circleWoman.setFill(new ImagePattern(woman));
        Rectangle circleMan = new Rectangle(70.00,70.00);
        circleMan.setFill(new ImagePattern(man));
        Rectangle circleDay = new Rectangle(70.00,70.00);
        circleDay.setFill(new ImagePattern(day));
        Rectangle circleNight = new Rectangle(70.00,70.00);
        circleNight.setFill(new ImagePattern(night));
        Rectangle circleGarden = new Rectangle(70.00,70.00);
        circleGarden.setFill(new ImagePattern(garden));
        Rectangle circleHouse = new Rectangle(70.00,70.00);
        circleHouse.setFill(new ImagePattern(house));

        RadioButton checkKnife = new RadioButton();
        RadioButton checkGun = new RadioButton();
        RadioButton checkWoman = new RadioButton();
        RadioButton checkMan = new RadioButton();
        RadioButton checkDay = new RadioButton();
        RadioButton checkNight = new RadioButton();
        RadioButton checkGarden = new RadioButton();
        RadioButton checkHouse = new RadioButton();

        ToggleGroup groupTool = new ToggleGroup();
        checkKnife.setToggleGroup(groupTool);
        checkGun.setToggleGroup(groupTool);
        ToggleGroup groupGender = new ToggleGroup();
        checkWoman.setToggleGroup(groupGender);
        checkMan.setToggleGroup(groupGender);
        ToggleGroup groupTime = new ToggleGroup();
        checkDay.setToggleGroup(groupTime);
        checkNight.setToggleGroup(groupTime);
        ToggleGroup groupPlace = new ToggleGroup();
        checkGarden.setToggleGroup(groupPlace);
        checkHouse.setToggleGroup(groupPlace);
        checkWoman.setVisible(true);
        checkMan.setVisible(true);
        checkDay.setVisible(false);
        checkNight.setVisible(false);
        checkGarden.setVisible(false);
        checkHouse.setVisible(false);
        checkGun.setVisible(false);
        checkKnife.setVisible(false);

        groupGender.selectedToggleProperty().addListener(new ChangeListener<Toggle>()
        {
            public void changed(ObservableValue<? extends Toggle> ob,
                                Toggle o, Toggle n)
            {
                RadioButton rb = (RadioButton)groupGender.getSelectedToggle();

                if (rb != null) {
                    if (checkWoman.isSelected()) {
                        guessedCard="WOMAN";
                        circleMan.setVisible(false);
                    }
                    if (checkMan.isSelected()) {
                        guessedCard="MAN";
                        circleWoman.setVisible(false);
                    }
                    checkWoman.setVisible(false);
                    checkMan.setVisible(false);
                    checkDay.setVisible(true);
                    checkNight.setVisible(true);
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
                    if (checkDay.isSelected()) {
                        guessedCard=guessedCard+" "+"DAY";
                        circleNight.setVisible(false);
                    }
                    if (checkNight.isSelected()) {
                        guessedCard=guessedCard+" "+"NIGHT";
                        circleDay.setVisible(false);
                    }
                    checkDay.setVisible(false);
                    checkNight.setVisible(false);
                    checkGun.setVisible(true);
                    checkKnife.setVisible(true);
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
                    if (checkKnife.isSelected()) {
                        guessedCard=guessedCard+" "+"KNIFE";
                        circleGun.setVisible(false);
                    }
                    if (checkGun.isSelected()) {
                        guessedCard=guessedCard+" "+"GUN";
                        circleKnife.setVisible(false);
                    }
                    checkKnife.setVisible(false);
                    checkGun.setVisible(false);
                    checkHouse.setVisible(true);
                    checkGarden.setVisible(true);
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
                    if (checkGarden.isSelected()) {
                        guessedCard=guessedCard+" "+"GARDEN";
                        circleHouse.setVisible(false);
                    }
                    if (checkHouse.isSelected()) {
                        guessedCard=guessedCard+" "+"HOUSE";
                        circleGarden.setVisible(false);
                    }
                    checkGarden.setVisible(false);
                    checkHouse.setVisible(false);
                }
            }
        });

        System.out.println("My guessed card is: "+guessedCard);
        VBox layoutTool = new VBox();
        HBox toolOptionOne = new HBox();
        toolOptionOne.getChildren().addAll(circleKnife,checkKnife);
        HBox toolOptionTwo = new HBox();
        toolOptionTwo.getChildren().addAll(circleGun,checkGun);
        layoutTool.getChildren().addAll(toolOptionOne,toolOptionTwo);
        VBox layoutGender = new VBox();
        HBox genderOptionOne = new HBox();
        genderOptionOne.getChildren().addAll(circleWoman,checkWoman);
        HBox genderOptionTwo = new HBox();
        genderOptionTwo.getChildren().addAll(circleMan,checkMan);
        layoutGender.getChildren().addAll(genderOptionOne,genderOptionTwo);
        VBox layoutPlace = new VBox();
        HBox placeOptionOne = new HBox();
        placeOptionOne.getChildren().addAll(circleHouse,checkHouse);
        HBox placeOptionTwo = new HBox();
        placeOptionTwo.getChildren().addAll(circleGarden,checkGarden);
        layoutPlace.getChildren().addAll(placeOptionOne,placeOptionTwo);
        VBox layoutTime = new VBox();
        HBox timeOptionOne = new HBox();
        timeOptionOne.getChildren().addAll(circleDay,checkDay);
        HBox timeOptionTwo = new HBox();
        timeOptionTwo.getChildren().addAll(circleNight,checkNight);
        layoutTime.getChildren().addAll(timeOptionOne,timeOptionTwo);
        HBox layout = new HBox();
        layout.getChildren().addAll(layoutGender,layoutTime,layoutTool,layoutPlace,newLabel);

        Scene scene = new Scene(layout,900, 150, Color.BLACK);
        opponentCardsPossibilities.setScene(scene);
        opponentCardsPossibilities.showAndWait();

        return guessedCard;

    }
}
