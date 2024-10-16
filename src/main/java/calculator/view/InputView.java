package view;


import utils.InputViewValidator;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;


public class InputView {

    private final InputViewValidator inputViewValidator = new InputViewValidator();

    private String inputName;

    public String readInputString() {
        inputName = Console.readLine();
        return inputName;
    }

    public void validatorAllInput() {

        inputName = inputViewValidator.validateQutoPair(inputName);

        inputViewValidator.validateCustom(inputName);

        inputViewValidator.validateDuplicationCustom(inputName);

        // first custom messsage pasing validate
    }
    public void validatorCustomInput() {
        inputViewValidator.validateCustom(inputName);
    }

    public ArrayList<String> resultParsingInput() {

        return null;
    }

}
