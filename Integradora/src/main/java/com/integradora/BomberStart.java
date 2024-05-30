package com.integradora;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class BomberStart {

    private Stage menustage;
    private Scene scene;


    @FXML
    public ImageView startimageView;
    @FXML
    public Button start;


    public void Startbutton(ActionEvent actionEvent) throws IOException {
        Parent fxmlLoader = FXMLLoader.load((getClass().getResource("/fxml/menu-view.fxml")));
        menustage = (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
        scene = new Scene(fxmlLoader);
        menustage.setScene(scene);

        menustage.show();
    }
}
