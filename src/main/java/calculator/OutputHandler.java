package calculator;

public class OutputHandler {
    private final static String OUTPUT_MESSAGE = "결과 : ";

    public void showOutput(int result) {
        System.out.println(OUTPUT_MESSAGE + result);
    }
}
