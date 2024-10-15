package calculator;

public class Calculator {
    private String userInput;
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
        if (userInput.length() >= 5 && userInput.startsWith("//")) {
            return true;
        } else {
            return false;
        }
    }

    private String getCustomSpliter() {
        int delimiterIndex = userInput.indexOf("\n");
        String newDelimiter = userInput.substring(2, delimiterIndex);
        userInput = userInput.substring(delimiterIndex + 1);
        return newDelimiter;
    }

    private boolean isValidSpliter(){
        return true;
    }

}
