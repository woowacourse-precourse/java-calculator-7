package view;


import model.Custom;
import utils.InputViewValidator;
import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;


public class InputView {

    private final InputViewValidator inputViewValidator = new InputViewValidator();
    private final Custom custom;

    private String inputName;
    private ArrayList<String> resultParsingInput;

    public InputView(Custom custom) {
        this.custom = custom;
    }


    public void readInputString() {
        inputName = Console.readLine();
        inputViewValidator.validateQuotationPair(inputName);
        inputName = inputName.substring(1, inputName.length() - 1);
        resultInput();
    }

    public Boolean isCustom() {
        System.out.println("inputname: " + inputName);
        /*조건문 분리 및 리팩토링 필요*/
        if(inputName.length()>4) {
            String prefix = inputName.substring(0, 2);
            String suffix = inputName.substring(3, 5);
            String customData = inputName.substring(2, 3);
            if (prefix.equals("//") && suffix.equals("\\n")) {
                inputViewValidator.validateCustomNumeric(customData);
                custom.addCustomSet(customData); /*컨트롤러의 역할로 변경*/
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