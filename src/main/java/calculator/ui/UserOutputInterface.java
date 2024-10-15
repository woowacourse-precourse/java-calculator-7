package calculator.ui;

public class UserOutputInterface {

    private final OutputUi outputUi;

    public UserOutputInterface(final OutputUi outputUi) {
        this.outputUi = outputUi;
    }
    
    public void printResult(final ResultMessage resultMessage) {
        outputUi.printMessage(resultMessage.getResult());
    }
}
