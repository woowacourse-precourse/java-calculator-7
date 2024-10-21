package calculator;

public class OutputHandler {
    // 결과 메시지 상수
    private final static String OUTPUT_MESSAGE = "결과 : ";

    public void showOutput(int result) {
        System.out.println(OUTPUT_MESSAGE + result);
    }
}
