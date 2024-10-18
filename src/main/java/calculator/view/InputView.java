package calculator.view;

import calculator.utils.InputViewValidator;
import camp.nextstep.edu.missionutils.Console;


public class InputView {

    private final InputViewValidator inputViewValidator = new InputViewValidator();

    private String inputName;
    private String customData;


    public void setCustom(String customData) {
        this.customData = customData;
    }

    public String getCustom() {
        return customData;
    }

    public void readInputString() {
        inputName = Console.readLine();
        resultInput();
    }

    public Boolean isCustom() {
        /*조건문 분리 및 리팩토링 필요*/
        if (inputName.length() > 4) {
            String prefix = inputName.substring(0, 2);
            String suffix = inputName.substring(3, 5);
            String customData = inputName.substring(2, 3);
            if (prefix.equals("//") && suffix.equals("\\n")) {
                inputViewValidator.validateCustomNumeric(customData);
                setCustom(customData);
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    private void resultInput() {
        if (isCustom()) {
            inputName = inputName.substring(5);
        }
    }

    public String getInputString() {
        return inputName;
    }
}