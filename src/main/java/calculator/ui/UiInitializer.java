package calculator.ui;

public class UiInitializer {

    public UserInputInterface initInputInterface() {
        final InputUi inputUi = new InputConsole();
        return new UserInputInterface(inputUi);
    }

    public UserOutputInterface initOutputInterface() {
        final OutputUi outputUi = new OutputConsole();
        return new UserOutputInterface(outputUi);
    }
}