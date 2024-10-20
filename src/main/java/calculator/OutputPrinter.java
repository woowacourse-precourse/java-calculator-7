package calculator;

import static calculator.enums.PrintText.PRINT_RESULT;
import static calculator.enums.PrintText.PROMPT_FOR_INPUT;

public class OutputPrinter {
    public void promptForInput() {
        System.out.println(PROMPT_FOR_INPUT.getPrintText());
    }

    public void printResult(int result) {
        System.out.println(PRINT_RESULT.getPrintText() + result);
    }
}
