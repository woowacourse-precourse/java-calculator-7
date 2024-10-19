package calculator.view;

import calculator.utils.InputViewValidator;
import camp.nextstep.edu.missionutils.Console;


public class InputView {

    private final InputViewValidator inputViewValidator = new InputViewValidator();

    private String inputName;
    private String customData;

    public void readInputString() {
        inputName = Console.readLine();
        resultInput();
    }

    public String getCustom() {
        return customData;
    }

    public String getInputString() {
        return inputName;
    }

    private void resultInput() {
        if (isCustom()) {
            inputName = inputName.substring(5);
        }
    }

    private Boolean isCustom() {
        if (!hasInputCustomLength()) {
            return false;
        }

        if (!hasCustomDelimeter()) {
            return false;
        }

        inputViewValidator.validateCustomNumeric(getParsingCustom());
        setCustom(getParsingCustom());

        return true;
    }

    private void setCustom(String customData) {
        this.customData = customData;
    }

    private boolean hasInputCustomLength() {
        return inputName.length() > 4;
    }

    private boolean hasCustomDelimeter() {
        String prefix = inputName.substring(0, 2);
        String suffix = inputName.substring(3, 5);
        return prefix.equals("//") && suffix.equals("\\n");
    }

    private String getParsingCustom() {
        return inputName.substring(2, 3);
    }

}