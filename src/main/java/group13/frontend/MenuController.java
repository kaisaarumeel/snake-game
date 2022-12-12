package group13.frontend;

import group13.SnakeGameMain;
import group13.backend.LeaderBoard;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class MenuController {
    SnakeGame game = new SnakeGame();

    public void startGame() throws Exception {
        SnakeGameMain.stage.setScene(game.getScene());
        SnakeGameMain.stage.setTitle("Snake Game");
        game.startGame();
    }

    public void leaderBoard() throws Exception{
        SnakeGameMain.stage.setScene(LeaderBoard.getLeaderScene());
        SnakeGameMain.stage.setTitle("Leader Board");
    }

    public  void exitGame(){
        System.exit(0);

    }

    public void howToPlay() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HowToPlayController.class.getResource("/HowToPlay.fxml"));
        Parent root = loader.load();
        Scene howToPlayScene = new Scene(root);
        SnakeGameMain.stage.setScene(howToPlayScene);
        SnakeGameMain.stage.setTitle("How To Play");

    }


    public void sound(){
        System.out.println("Coming soon...");
    }

    public void music(){
        System.out.println("Coming soon...");
    }

    /*public static Scene getScene() {

    }*/

    public SnakeGame getGame() {
        return game;
    }
}
