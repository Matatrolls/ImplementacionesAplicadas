package com.integradora;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class PlayerSelectionView {
    @FXML
    static Button start;
    @FXML
    static Button exit;

    public static String getSelection() {
        return selection;
    }

    private static String selection;

    public static MapGame map =new MapGame();

    public static Stage mapStage;
    public static Scene scene;

    public static MapGame getMap() {
        return map;
    }


    public void Start(MouseEvent actionEvent) throws IOException {
        Parent fxmlLoader = FXMLLoader.load((getClass().getResource("/fxml/map-view.fxml")));
        mapStage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        mapStage.setScene(scene);

        mapStage.show();
    }

    public void ClickWhite(MouseEvent mouseEvent) throws IOException {
        selection="White";

        Start(mouseEvent);
    }

    public void ClickBlack(MouseEvent mouseEvent) throws IOException {
        selection="Black";

        Start(mouseEvent);
    }

    public static Stage getMapStage() {
        return mapStage;
    }

    public static Scene getScene() {
        return scene;
    }

}
