package group13.backend;

import group13.SnakeGameMain;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
//import javafx.scene.layout.VBox;
//import javafx.scene.paint.Color;
import javafx.scene.text.Text;

import java.util.Map;
import java.util.List;


public class LeaderBoard {

    public static Scene getLeaderScene() throws Exception{

        Canvas canvas = new Canvas(700,700);
        GraphicsContext gContext = canvas.getGraphicsContext2D();
        Group root = new Group();

        //VBox leaderLayout = new VBox(canvas);

        Button backToMenu = new Button("Back To Menu");
        backToMenu.setAlignment(Pos.TOP_LEFT);
        backToMenu.setOnMousePressed( e -> {
                    try{
                        SnakeGameMain.showMenu();
                    } catch(Exception e1){
                        System.out.println("Please try again later");
                    }
                }
        );

        ScoreHandler handler = new ScoreHandler();
        List<Map<String, Object>> LeaderList = handler.getHighScoreList(10);


        for (Map<String, Object> stringObjectMap : LeaderList) {
            String player = (String) stringObjectMap.get("name");
            int score = (Integer) stringObjectMap.get("score");

            String display = (player + ", " + score /* + "\n" */);

            Text playerText = new Text(display);
            gContext.strokeText(display, 25, 25);
            //ADD THEM ALL TO THE SCENE WITHOUT A VBOX
        }

        String player1 = (String) LeaderList.get(0).get("name");
        Text firstPlayer = new Text(player1);



        root.getChildren().add(backToMenu);

        return new Scene(root);
    }




}