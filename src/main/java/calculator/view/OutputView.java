package calculator.view;

public class OutputView {
    public static void printInputStringMessage() {
        System.out.println(SystemMessage.INPUT_STRING.getMessage());
    }

    public static void printResult(int result) {
        System.out.println(SystemMessage.RESULT.getMessage() + result);
    }
}
