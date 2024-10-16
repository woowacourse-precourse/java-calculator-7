package calculator.view;

import static calculator.message.CalculatorMessage.OUTPUT_MESSAGE;

public class OutputView {
    public static void printSum(int sum) {
        System.out.printf(OUTPUT_MESSAGE, sum);
    }
}