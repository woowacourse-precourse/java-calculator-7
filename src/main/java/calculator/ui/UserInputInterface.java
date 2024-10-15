package calculator.ui;

public class UserInputInterface {

    private final InputUi inputUi;

    public UserInputInterface(final InputUi inputUi) {
        this.inputUi = inputUi;
    }

    public UserInputMessage getUserInputMessage() {
        return new UserInputMessage(inputUi.readLine());
    }
}
