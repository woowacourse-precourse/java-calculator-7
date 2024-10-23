package calculator;

import static calculator.calculate.Calculator.getNumSum;
import static calculator.calculate.Calculator.printResult;
import static calculator.input.StringInput.getInput;
import static calculator.split.StringSplit.getCalFormula;
import static calculator.split.StringSplit.getSeparator;
import static calculator.split.StringSplit.splitCalFormulaBySeparator;

public class Application {
    public static void main(String[] args) {
        String input = getInput();

        String separator = getSeparator(input);
        String calFormula = getCalFormula(input);

        int[] numArr = splitCalFormulaBySeparator(calFormula, separator);
        int result = getNumSum(numArr);

        printResult(result);
    }

}
