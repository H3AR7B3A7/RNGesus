package be.dog.d.steven;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class RNGesusController implements Initializable {

    @FXML private Button btnExit;

    @FXML private TextFlow textView;

    @FXML private TextField tfSize;

    @FXML private TextField tfTime;

    @FXML public TextField tfAmount;

    @FXML private CheckBox cbTimer;

    @FXML private CheckBox cbRepeat;

    RandomGenerator rl;
    Text t = new Text();
    int timeInSeconds = 5;
    Timeline timeline = new Timeline();
    int amount = 10;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rl = new RandomGenerator(10);
        tfTime.setDisable(true);
        tfAmount.setDisable(true);
    }

    @FXML
    private void btnExitHandler(){
        Stage stage = (Stage) btnExit.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void btnNextHandler() {
        if(!cbTimer.isSelected()) {
            generateNewRandom();
        }else{
            if(!timeline.getStatus().equals(Animation.Status.RUNNING)) {
                if (cbTimer.isSelected()) {
                    generateNewRandom();
                    timeline = new Timeline(new KeyFrame(Duration.seconds(timeInSeconds), actionEvent -> generateNewRandom()));
                    timeline.setCycleCount(amount-1);
                    timeline.play();
                }
            }
        }
    }

    private void generateNewRandom() {
        if (cbRepeat.isSelected()) {
            t = new Text(rl.readAndRemoveNextRandom());
        } else {
            t = new Text(rl.readNextRandomAndShuffle());
        }
        t.setFont(Font.font("Verdana", 80));
        t.fillProperty().setValue(Paint.valueOf("white"));
        textView.getChildren().clear();
        textView.getChildren().add(t);
    }

    public void sizeChangedHandler() {
        rl = new RandomGenerator(Integer.parseInt(tfSize.getText()));
    }

    public void timeChangedHandler() {
        timeInSeconds = Integer.parseInt(tfTime.getText());
    }

    public void amountChangedHandler() {
        amount = Integer.parseInt((tfAmount.getText()));
    }

    public void cbTimerChangedHandler(ActionEvent actionEvent) {
        if(cbTimer.isSelected()){
            tfTime.setDisable(false);
            tfAmount.setDisable(false);
        }else{
            tfTime.setDisable(true);
            tfAmount.setDisable(true);
        }
    }
}