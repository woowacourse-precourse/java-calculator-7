package calculator.view;

public class OutputView {

    public static void printCalculateResult(Integer numbersSum) {
        printMessage(PrintMessage.USER_OUTPUT_MESSAGE);
        printNumbersSum(numbersSum);
    }

    public static void printNumbersSum(Integer numbersSum) {
        System.out.print(numbersSum);
    }

    public static void printMessage(PrintMessage message) {
        System.out.print(message.getMessage());
    }
}
