package snake.controller;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import snake.model.SnakeGame;
import snake.view.GameView;

import java.net.URL;

import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML
    Canvas canvas;

    @FXML
    Pane pane;

    private Timeline timeline;

    private SnakeGame game;
    private GameView gameView;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        bindSizes();
        game = new SnakeGame();
        gameView = new GameView(game, canvas);
        timeline = new Timeline(new KeyFrame(Duration.millis(1000), event -> processTick()));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private void bindSizes() {
        canvas.widthProperty().bind(pane.widthProperty());
        canvas.heightProperty().bind(pane.heightProperty());

        canvas.widthProperty().addListener(evt -> gameView.draw());
        canvas.heightProperty().addListener(evt -> gameView.draw());
    }

    private void processTick() {
        game.tick();
        gameView.draw();
    }


}
