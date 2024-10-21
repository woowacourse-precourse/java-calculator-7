package calculator.view;

public class OutputView {
    private static final String INITIAL_MESSAGE = "덧셈할 문자열을 입력해 주세요.";
    private static final String FORMAT_OF_RESULT = "결과 : %d\n";

    public static void printInitialMessage(){
        System.out.println(INITIAL_MESSAGE);
    }

    public static void printResult(int sum){
        System.out.printf(FORMAT_OF_RESULT, sum);
    }
}
