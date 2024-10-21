package calculator;

public class OutputService {
    private static final String WELCOME_MESSAGE = "덧셈할 문자열을 입력해 주세요.";

    public void welcome() {
        System.out.println(WELCOME_MESSAGE);
    }

    public void printResult(String result) {
        System.out.println("결과 : " + result);
    }
}
