package calculator;

public class Calculator {
    private final String userInput;
    private final OutputView outputView = new OutputView();
    private String DELIMITER = ",|:|";
    private final Long resultNumber = 0L;

    public Calculator() {
        InputView inputView = new InputView();
        userInput = inputView.getInput();
    }

    public void stringSummation() {
        if (hasCustomSpliter()) {
            DELIMITER += getCustomSpliter();
        }

        splitString();
        changeStringToNumber();
        sumNumber();
        outputView.printResult(resultNumber);

    }

    private void sumNumber() {

    }

    private void changeStringToNumber() {

    }

    private void splitString() {

    }

    private boolean hasCustomSpliter(){
        return  true;
    }

    private String getCustomSpliter() {
        return null;
    }

    private boolean isValidSpliter(){
        return true;
    }

}
