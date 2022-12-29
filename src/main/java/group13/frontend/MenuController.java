package group13.frontend;

import group13.SnakeGameMain;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import java.net.URISyntaxException;
import java.util.Objects;


public class MenuController {

    @FXML
    private ImageView musicImageView;

    @FXML
    private ImageView soundImageView;

    public static boolean soundEffect = false;
    private int musicPressedCounter = 1;
    private int soundPressedCounter = 1;

    SnakeGame game = new SnakeGame();
    private MediaView mediaView;

    public MenuController(){
    }


    public void startGame() throws Exception {
        SnakeGameMain.stage.setScene(game.getScene());
        SnakeGameMain.stage.setTitle("Snake Game");
        game.startGame();
    }

    public void leaderBoard(){
        SnakeGameMain.stage.setScene(LeaderBoard.getLeaderScene());
        SnakeGameMain.stage.setTitle("Leader Board");
    }

    public  void exitGame(){
        System.exit(0);

    }

    public void howToPlay() throws Exception {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(HowToPlayController.class.getResource("/FXMLfiles/HowToPlay.fxml"));
        Parent root = loader.load();
        Scene howToPlayScene = new Scene(root);
        SnakeGameMain.stage.setScene(howToPlayScene);
        SnakeGameMain.stage.setTitle("How To Play");

    }

    /**
     *Both sound() and music() methods enable a user to decide whether they want to use the sounds effects and music,
     * respectively. Both are muted by default.
     */

    public void sound() throws URISyntaxException {
        soundPressedCounter += 1;
        if(soundPressedCounter % 2 == 0){
            soundEffect = true;
            Image mutedImage = new Image(Objects.requireNonNull(SnakeGameMain.class.getResource("/Images/Sound.png")).toURI().toString());
            soundImageView.setImage(mutedImage);
        }else {
            soundEffect = false;
            Image mutedImage = new Image(Objects.requireNonNull(SnakeGameMain.class.getResource("/Images/MutedSound.png")).toURI().toString());
            soundImageView.setImage(mutedImage);
        }

    }

    public void music() throws URISyntaxException {

        musicPressedCounter += 1;
        if (mediaView == null){
            String file = (Objects.requireNonNull(SnakeGameMain.class.getResource("/arcadeMusic.mp3"))).toURI().toString();
            Media media = new Media(file);
            MediaPlayer mediaPlayer = new MediaPlayer(media);
            mediaPlayer.setCycleCount(AudioClip.INDEFINITE);
            mediaView = new MediaView();
            mediaView.setMediaPlayer(mediaPlayer);
        }
        if(musicPressedCounter % 2 == 0){
            mediaView.getMediaPlayer().play();
            Image mutedImage = new Image(Objects.requireNonNull(SnakeGameMain.class.getResource("/Images/Music.png")).toURI().toString());
            musicImageView.setImage(mutedImage);
        }else {
            mediaView.getMediaPlayer().stop();
            Image unmutedImage = new Image(Objects.requireNonNull(SnakeGameMain.class.getResource("/Images/mutedMusic.png")).toURI().toString());
            musicImageView.setImage(unmutedImage);
        }



    }

}
