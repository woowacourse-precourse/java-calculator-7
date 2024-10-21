package calculator.view;

public class OutputView {
    private OutputView() {}

    public static void printResult(int result) {
        System.out.print(ViewMessage.OUTPUT_STRING);
        System.out.println(result);
    }
}