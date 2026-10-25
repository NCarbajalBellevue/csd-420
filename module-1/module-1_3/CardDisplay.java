/*
 * Name: Natalia Carbajal
 * Date: October 24, 2026
 * Assignment: Module 1.3 Programming Assignment
 * Purpose: Display four random playing cards and use a refresh button to show four different cards.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.*;

public class CardDisplay extends Application {

    HBox cards = new HBox(10);

    public void start(Stage stage) {
        cards.setStyle("-fx-alignment: center;");

        Button refresh = new Button("Refresh");
        refresh.setOnAction(e -> showCards());

        VBox root = new VBox(20, cards, refresh);
        root.setStyle("-fx-alignment: center;");

        showCards();

        stage.setTitle("Random Cards");
        stage.setScene(new Scene(root, 600, 250));
        stage.show();
    }

    private void showCards() {
        cards.getChildren().clear();

        List<Integer> deck = new ArrayList<>();
        for (int i = 1; i <= 52; i++) {
            deck.add(i);
        }

        Collections.shuffle(deck);

        for (int i = 0; i < 4; i++) {
            Image image = new Image(
                getClass().getResourceAsStream(
                    "/cards/" + deck.get(i) + ".png"
                )
            );

            ImageView card = new ImageView(image);
            card.setFitWidth(100);
            card.setPreserveRatio(true);
            cards.getChildren().add(card);
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
