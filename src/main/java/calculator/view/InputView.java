package view;


import utils.InputViewValidator;
import camp.nextstep.edu.missionutils.Console;


public class InputView {

    private final InputViewValidator inputViewValidator = new InputViewValidator();

    private String inputName;

    public String readInputString() {
        inputName = Console.readLine();
        return inputName;
    }

    public void validatorAllInput() {

        inputName = inputViewValidator.validateQutoPair(inputName);

        // first custom messsage pasing validate
    }

}
