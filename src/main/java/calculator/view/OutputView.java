package calculator.view;

public class OutputView {

    public OutputView() {
    }

    public static void printCalculateStartMessage() {
        System.out.println(CalculateMessage.INPUT_STRING.getMessage());
    }

    public static void printResultMessage(int result) {
        System.out.println(CalculateMessage.RESULT.getMessage() + result);
    }
}
