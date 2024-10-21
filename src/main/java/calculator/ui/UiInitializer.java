package calculator.ui;

public class UiInitializer {

    public UserInputController initInputController() {
        final InputUi inputUi = new InputConsole();
        return new UserInputController(inputUi);
    }

    public UserOutputController initOutputController() {
        final OutputUi outputUi = new OutputConsole();
        return new UserOutputController(outputUi);
    }
}