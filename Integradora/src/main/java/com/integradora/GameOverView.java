package com.integradora;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class GameOverView {
    private Stage menustage;
    private Scene scene;

    public void restart(ActionEvent actionEvent) throws IOException {

        Parent fxmlLoader = FXMLLoader.load((getClass().getResource("/fxml/forClose-view.fxml")));
        menustage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        menustage.setScene(scene);

        menustage.show();
        menustage.close();
    }

    public void exit(ActionEvent actionEvent) {
        System.exit(0);
    }
}
