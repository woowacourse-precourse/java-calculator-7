package calculator;

import static calculator.calculate.Calculator.getNumSum;
import static calculator.calculate.Calculator.printResult;
import static calculator.input.StringInput.getInput;
import static calculator.split.StringSplit.getCustomCalFormula;
import static calculator.split.StringSplit.getCustomSeparator;
import static calculator.split.StringSplit.getDefaultCalFormula;
import static calculator.split.StringSplit.getDefaultSeparator;
import static calculator.split.StringSplit.splitCalFormulaBySeparator;
import static calculator.validate.StringValidate.isInputStartWithSlash;
import static calculator.validate.StringValidate.validateCalFormula;
import static calculator.validate.StringValidate.validateNewLineInput;
import static calculator.validate.StringValidate.validateSeperator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String seperator, calFormula;
        int[] numArr;
        int result;

        String input = getInput();

        // 커스텀 구분자
        if (isInputStartWithSlash(input)) {
            validateNewLineInput(input);
            seperator = getCustomSeparator(input);
            calFormula = getCustomCalFormula(input);
        } else { // 기본 구분자
            seperator = getDefaultSeparator();
            calFormula = getDefaultCalFormula(input);
        }

        validateSeperator(seperator);
        validateCalFormula(calFormula, seperator);
        numArr = splitCalFormulaBySeparator(calFormula, seperator);
        result = getNumSum(numArr);
        printResult(result);
    }

}
