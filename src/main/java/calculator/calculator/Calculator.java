package calculator.calculator;

import calculator.exception.ValidateInput;
import calculator.io.InputString;

import java.util.List;


public class Calculator {
    private final InputString inputString;
    private final ValidateInput validateInput;
    private final StringParsing stringParsing;

    public Calculator() {
        this.inputString = new InputString();
        this.validateInput = new ValidateInput();
        this.stringParsing = new StringParsing();
    }

    //계산기 로직
    public void playCalculator() {
        String inputStr = inputString.input();
        Input input = new Input(inputStr);

        if (inputStr.startsWith("//") || inputStr.startsWith("\\n")) { //커스텀 구분자 있을 경우 - "//" 또는 "\n"로 시작
            validateInput.validateCustomDelimiter(input);
        } else { //커스텀 구분자 없을 경우
            validateInput.validateDefaultDelimiter(input);
        }

        //숫자 추출
        List<Integer> integers = stringParsing.parseString(input);
    }
}
