package calculator;

public class OutputProcessor {
    // 결과 메세지 헤더
    private static final String MESSAGE_HEADER = "결과 : ";

    public void printResult(int result) {
        System.out.println(MESSAGE_HEADER + result);
    }
}
