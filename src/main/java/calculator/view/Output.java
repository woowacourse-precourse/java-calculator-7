package calculator.view;

public class Output {

    private static final String INPUT_PROMPT = "덧셈할 문자열을 입력해 주세요.";
    private static final String RESULT_PROMPT = "결과 : ";

    public void printInputPrompt() {
        System.out.println(INPUT_PROMPT);
    }

    public void printResultPrompt(int result) {
        System.out.println(RESULT_PROMPT + result);
    }
}
