package com.integradora;

import com.structures.FloydWarshallAlgorithm;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.Optional;

public class MapGame {
    public static Stage menustage;
    private Scene scene;
    @FXML
    private Label TextLabel;
    @FXML
    private Button shortRoute;
    @FXML
    private TextField textInput;
    private static Scene scenegame;
    private static Stage gamestage ;
    private static Level[] levels= new Level[9];
    private FloydWarshallAlgorithm floyd =new FloydWarshallAlgorithm(9);
    public static int actuallvl=0;
    public static boolean winned;

    public static void close() {
        gamestage.close();
    }

    public void setWinned(boolean winnedbool){
        winned=winnedbool;
    }

    public MapGame() {
        for (int i= 0; i<levels.length;i++){
            levels[i] = new Level();
        }
        floyd.addEdge(0,1,1);
        floyd.addEdge(1,2,1);
        floyd.addEdge(2,3,1);
        floyd.addEdge(3,4,1);
        floyd.addEdge(4,5,1);
        floyd.addEdge(5,6,1);
        floyd.addEdge(6,7,1);
        floyd.addEdge(7,8,1);

        floyd.addEdge(1,4,1);
        floyd.addEdge(3,6,1);
        floyd.addEdge(5,8,1);
        floyd.addEdge(0,1,1);
        floyd.addEdge(6,8,1);
    }

    public void ShortRoute(ActionEvent actionEvent) {
        int position = Integer.parseInt(textInput.getText());

        textInput.setVisible(false);

        //use to floyd
        TextLabel.setText(floyd.getShortestPath(position-1,8));

        shortRoute.setVisible(false);

    }
    public void start(ActionEvent actionEvent) throws IOException {

        Parent fxmlLoader = FXMLLoader.load((getClass().getResource("/fxml/hello-view.fxml")));

        scenegame = new Scene(fxmlLoader);
        gamestage = new Stage();
        gamestage.setScene(scenegame);
        Image icon = new Image("/Icon.png");
        gamestage.getIcons().add(icon);
        gamestage.setTitle("BomberMan Game");
        gamestage.setResizable(false);
        gamestage.show();

        gamestage.setOnCloseRequest(event ->{
                event.consume();
                gamestage.close();

        });
    }

    public void getwinned(){
        winned=BomberController.getWinned();
    }
    public static void newLevel(ActionEvent event){
        gamestage.close();
        int level =getActuallvl();
        if(levels[level].getCompleted()){
            Platform.runLater(() -> {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setHeaderText("You completed the level!");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK) {
                    alert.close();
                }

                alert.setOnCloseRequest(eventClose -> {
                    eventClose.consume();
                    alert.close();
                });
            });
            event.consume();
        }

    }

    public void Alert(){

        Alert alert= new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText("You havent completed previous levels! you are in level " + (getActuallvl()+1));
        if(alert.showAndWait().get() == ButtonType.OK){

            alert.close();
        }
        alert.setOnCloseRequest(event ->{
            event.consume();
            alert.close();
        });
    }
    public void lvl1(ActionEvent actionEvent) throws IOException {
        setActuallvl(0);
        start(actionEvent);
        getwinned();
        if(winned){
            levels[0].setCompleted(true);
        }
    }
    public void lvl2(ActionEvent actionEvent) throws IOException {
        if(levels[0].getCompleted()){
            setActuallvl(1);
            start(actionEvent);
            getwinned();
            if(winned){
                levels[1].setCompleted(true);
            }

        }else {
            Alert();
        }


    }
    public void lvl3(ActionEvent actionEvent) throws IOException {

        if(levels[1].getCompleted()){
            setActuallvl(2);
            start(actionEvent);
            getwinned();
            if(winned){
                levels[2].setCompleted(true);
            }


        }else {
            Alert();
        }
        actionEvent.consume();

    }
    public void lvl4(ActionEvent actionEvent) throws IOException {
        if(levels[2].getCompleted()){
            setActuallvl(3);
            start(actionEvent);
            getwinned();
            if(winned){
                levels[3].setCompleted(true);
            }

        }else {
            Alert();
        }
        actionEvent.consume();

    }
    public void lvl5(ActionEvent actionEvent) throws IOException {
        if(levels[3].getCompleted() || levels[1].getCompleted() ){
            setActuallvl(4);
            start(actionEvent);
            getwinned();
            if(winned){
                levels[4].setCompleted(true);

            }

        }else {
            Alert();
        }
        actionEvent.consume();

    }
    public void lvl6(ActionEvent actionEvent) throws IOException {
        if(levels[4].getCompleted()){
            setActuallvl(5);
            start(actionEvent);
            getwinned();
            if(winned){
                levels[5].setCompleted(true);
            }


        }else {
            Alert();
        }
        actionEvent.consume();

    }
    public void lvl7(ActionEvent actionEvent) throws IOException {

        if(levels[3].getCompleted() || levels[5].getCompleted() ){
            setActuallvl(6);
            start(actionEvent);
            getwinned();
            if(winned){
                levels[6].setCompleted(true);

            }

        }else {
            Alert();
        }

        actionEvent.consume();
    }
    public void lvl8(ActionEvent actionEvent) throws IOException {
        if(levels[6].getCompleted()){
            setActuallvl(7);
            start(actionEvent);
            getwinned();
            if(winned){
                levels[7].setCompleted(true);
            }


        }else {
            Alert();
        }
        actionEvent.consume();
    }
    public void lvl9(ActionEvent actionEvent) throws IOException {
        if(levels[5].getCompleted() || levels[7].getCompleted() ){
            setActuallvl(8);
            start(actionEvent);
            getwinned();
            if(winned){
                levels[8].setCompleted(true);
                Parent fxmlLoader = FXMLLoader.load((getClass().getResource("/fxml/winGame-view.fxml")));
                menustage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
                scene = new Scene(fxmlLoader);
                menustage.setScene(scene);
                menustage.show();
            }
        }else {
            Alert();
        }
        actionEvent.consume();
    }

    public static int getActuallvl() {
        return actuallvl;
    }
    public void setActuallvl(int actuallvl) {
        this.actuallvl = actuallvl;
    }
    public Level[] getLevels() {
        return levels;
    }
}
