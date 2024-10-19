package calculator.view;

public class OutputView {
    private static final String INPUT_PROMPT_MESSAGE = "덧셈할 문자열을 입력해 주세요";

    public void printPrompt() {
        System.out.println(INPUT_PROMPT_MESSAGE);
    }

    public void printSum(int sum) {
        System.out.println("결과 : "+ sum);
    }
}
