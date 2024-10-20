package calculator.calculator;

import calculator.exception.ValidateInput;
import calculator.io.InputString;
import calculator.io.OutputResult;

import java.util.List;


public class Calculator {
    private final InputString inputString;
    private final ValidateInput validateInput;
    private final StringParsing stringParsing;
    private final OutputResult outputResult;

    public Calculator() {
        this.inputString = new InputString();
        this.validateInput = new ValidateInput();
        this.stringParsing = new StringParsing();
        this.outputResult = new OutputResult();
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

        //덧셈 계산 후 결과 반환
        outputResult.printResult(calculateResult(integers));
    }

    //덧셈 계산
    private int calculateResult(List<Integer> integers) {
        int sum = 0;
        for (int number : integers) {
            sum += number;
        }
        return sum;
    }
}
