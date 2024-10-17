package calculator.view;

public class OutputView {

    public OutputView() {
    }

    public static void printCalculateStartMessage() {
        System.out.println(CalculateMessage.INPUT_STRING);
    }

    public static void printResultMessage() {
        System.out.println(CalculateMessage.RESULT);
    }
}
