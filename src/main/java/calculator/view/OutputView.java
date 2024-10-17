package calculator.view;

public class OutputView {

    private static final String INPUT_PROMPT = "덧셈할 문자열을 입력해 주세요.";
    private static final String OUTPUT_PROMPT = "결과 : ";

    public static void printInput() {
        System.out.println(INPUT_PROMPT);
    }

    public static void printResult(int result) {
        System.out.println(OUTPUT_PROMPT + result);
    }

    public static void printError(String error) {
        System.out.println(error);
    }
}
