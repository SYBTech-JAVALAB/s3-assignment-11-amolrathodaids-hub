import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class TrafficLightApp extends Application {

    @Override
    public void start(Stage primaryStage) {
        // 1. Create the Message Label (Initially empty)
        Label messageLabel = new Label("");
        messageLabel.setFont(Font.font("Arial", FontWeight.BOLD, 30));

        // 2. Create Radio Buttons
        RadioButton rbRed = new RadioButton("Red");
        RadioButton rbYellow = new RadioButton("Yellow");
        RadioButton rbGreen = new RadioButton("Green");

        // 3. Group them so only one can be selected
        ToggleGroup group = new ToggleGroup();
        rbRed.setToggleGroup(group);
        rbYellow.setToggleGroup(group);
        rbGreen.setToggleGroup(group);

        // 4. Add Event Handlers
        rbRed.setOnAction(e -> {
            messageLabel.setText("STOP");
            messageLabel.setTextFill(Color.RED);
        });

        rbYellow.setOnAction(e -> {
            messageLabel.setText("READY");
            messageLabel.setTextFill(Color.ORANGE);
        });

        rbGreen.setOnAction(e -> {
            messageLabel.setText("GO");
            messageLabel.setTextFill(Color.GREEN);
        });

        // 5. Layout Management
        VBox root = new VBox(20); // 20px spacing
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(messageLabel, rbRed, rbYellow, rbGreen);

        // 6. Scene and Stage setup
        Scene scene = new Scene(root, 300, 250);
        primaryStage.setTitle("Traffic Light Simulator");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}