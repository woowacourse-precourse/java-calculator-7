package calculator.ui;

public class UserOutputController {

    private final OutputUi outputUi;

    public UserOutputController(final OutputUi outputUi) {
        this.outputUi = outputUi;
    }

    public void printInputInformation() {
        outputUi.printMessage("덧셈할 문자열을 입력해 주세요.");
    }

    public void printResult(final ResultMessage resultMessage) {
        outputUi.printMessage(resultMessage.getResult());
    }
}
