package calculator.ui;

public class UserInputController {

    private final InputUi inputUi;

    public UserInputController(final InputUi inputUi) {
        this.inputUi = inputUi;
    }

    public UserInputMessage getUserInputMessage() {
        return new UserInputMessage(inputUi.readLine());
    }
}
