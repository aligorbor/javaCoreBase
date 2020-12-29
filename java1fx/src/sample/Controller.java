package sample;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {

    @FXML
    private TextField textField;

    @FXML
    private Label headerName;
    private GuessNum guessNum = new GuessNum(11, 3);
    private Alert alertErr = new Alert(Alert.AlertType.ERROR, "Введите число!");

    @FXML
    void doAction() {
        String message = textField.getText();
        if (!message.isEmpty()) {
            try {
                int number = Integer.parseInt(message);
                headerName.setText(guessNum.play(number));
                textField.clear();
            } catch (NumberFormatException e) {
                headerName.setText("Ошибка!");
                alertErr.show();
            }
        }
    }

}

