package view;

public class OutputView {

    private static final String INPUT_GUIDE = "덧셈할 문자열을 입력해 주세요.";
    private static final String OUTPUT_RESULT = "결과 : %s";

    public static void printGuide() {
        System.out.println(INPUT_GUIDE);
    }

    public static void printResult(final int result) {
        System.out.println(String.format(OUTPUT_RESULT, result));
    }
}
