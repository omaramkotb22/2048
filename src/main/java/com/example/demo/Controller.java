package com.example.demo;

import com.example.demo.GamePackage.GameScene;
import com.example.demo.leaderboardPackage.LeaderboardScene;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Popup;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;


/**
 * The {@code Controller} class is responsible for handling the user interactions and managing the transitions between different scenes in the game.
 * It contains the logic for starting the game, switching to the main menu, settings, and leaderboard scenes, and opening the help window.
 * The {@code Controller} class also has a static field {@code darkTheme} which stores the state of the dark theme toggle, and a static method {@code getUserName()} which returns the user's name.
 */
public class Controller implements Initializable {

    @FXML
    public TextField userNameText;
    @FXML
    public Button settings;
    @FXML
    public Button help;
    private static Stage stage;
    private Color theme;
    public static String getUserName() {
        return userName;
    }

    private static String userName;

    public static CheckBox darkTheme = new CheckBox();


    private final Group gameRoot = new Group();
//    private static Scene scene;
//    private final Group controlsRoot = new Group();
    @FXML
    GameScene game = new GameScene();

    public Controller() throws IOException {
    }



    public void StartGameScene(ActionEvent actionEvent) throws IOException {
        Group endgameRoot = new Group();
        int HEIGHT = 600;
        int WIDTH = 600;
        Scene gameScene = new Scene(gameRoot, WIDTH, HEIGHT, Color.rgb(200, 200, 200));
        Scene endGameScene = new Scene(endgameRoot, 200, 150, Color.rgb(200, 200, 200));


//        Scene controlsScene = new Scene(controlsRoot, WIDTH, HEIGHT, Color.rgb(255,255,255));
        stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setScene(gameScene);
        userName = userNameText.getText();
        game.game(gameScene, gameRoot, stage, endGameScene, endgameRoot, userName);
        stage.show();
    }
    public void SwitchToMenu(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mainMenuLight.fxml")));
        Scene MenuScene = new Scene(root);
        Stage MenuStage = (Stage)((Node) event.getSource()).getScene().getWindow();
        MenuStage.setScene(MenuScene);
        MenuStage.show();
    }

    public void SwitchToSettings(ActionEvent actionevent) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("SettingsLightTheme.fxml")));
        Scene SettingsScene = new Scene(root);
        stage = (Stage)((Node) actionevent.getSource()).getScene().getWindow();
        stage.setScene(SettingsScene);

        stage.show();
    }
    public void SwitchToLeaderboard(ActionEvent actionEvent) throws IOException{
        stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        LeaderboardScene.getInstance().leaderboard(gameRoot, stage);
        stage.show();
    }
    public void OpenHelp(ActionEvent actionEvent){
        Popup popup = new Popup();
        Label statement_1 = new Label("The object of the game is to combine the numbers displayed on the tiles until you reach 2048");

        Label statement_2 = new Label("You hit the arrow keys on your keyboard to move the tiles around — and also to generate new tiles");
        Label statement_3 = new Label("Your objective is to reach 2048 before the board fills up");
        VBox vbox = new VBox();
        vbox.getChildren().addAll(statement_1,statement_2,statement_3);
//        popup.getContent().addAll(statement_1,statement_2,statement_3);

        Stage popupStage = new Stage();
        Scene scene = new Scene(vbox, 300,300);
        popupStage.setScene(scene);
        popupStage.show();



    }



    @FXML
    public void handleThemeChange(ActionEvent event) throws IOException {
        if (darkTheme.isSelected()) {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mainMenuDark.fxml")));
            Scene MenuScene = new Scene(root);
            Stage MenuStage = (Stage)((Node) event.getSource()).getScene().getWindow();
            MenuStage.setScene(MenuScene);
            MenuStage.show();
        } else {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mainMenuLight.fxml")));
            Scene MenuScene = new Scene(root);
            Stage MenuStage = (Stage)((Node) event.getSource()).getScene().getWindow();
            MenuStage.setScene(MenuScene);
            MenuStage.show();
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        handleThemeChange();
    }

    @FXML
    private void handleThemeChange() {
        darkTheme.setOnAction((event) -> {
            if(darkTheme.isSelected()) {
                theme = Color.rgb(30, 30, 30);
                try {
                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mainMenuDark.fxml")));
                    Scene MenuScene = new Scene(root, 600, 600, theme);
                    stage.setScene(MenuScene);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            else {
                theme = Color.rgb(200, 200, 200);
                try {
                    Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("mainMenuLight.fxml")));
                    Scene MenuScene = new Scene(root, 600, 600, theme);
                    stage.setScene(MenuScene);
                    stage.show();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }




}