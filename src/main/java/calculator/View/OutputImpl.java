package calculator.View;

public class OutputImpl implements Output {
    private static final String OUTPUT_MESSAGE = "결과";

    public void printResult(int result) {
        System.out.println("OUTPUT_MESSAGE : " + result);
    }
}
