package com.integradora;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Map;

public class BomberMenu {
    private Scene scene;
    @FXML
    static Button start;
    @FXML
    static Button exit;

    private Stage menustage;

    public void Exit(ActionEvent actionEvent) throws IOException {
        System.exit(0);
    }

    public void Start(ActionEvent actionEvent) throws IOException {
        Parent fxmlLoader = FXMLLoader.load((getClass().getResource("/fxml/playerSelection-view.fxml")));
        menustage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        menustage.setScene(scene);

        menustage.show();
    }
}
