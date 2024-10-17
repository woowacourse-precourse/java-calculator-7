package calculator.view;

public class OutputView {

    private static final String INPUT_PROMPT = "덧셈할 문자열을 입력해 주세요.";
    private static final String OUTPUT_PROMPT = "결과 : ";
    private static final String OUTPUT_REPEAT_PROMPT = "재시작을 원한다면 1, 종료를 원한다면 2를 입력하세요.";

    public static void printInput() {
        System.out.println(INPUT_PROMPT);
    }

    public static void printResult(int result) {
        System.out.println(OUTPUT_PROMPT + result);
    }

    public static void printRepeat() {
        System.out.println(OUTPUT_REPEAT_PROMPT);
    }

    public static void printError(String error) {
        System.out.println(error);
    }
}
