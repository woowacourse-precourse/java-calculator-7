package calculator.view;

public class OutputView {
    private static final String PROMPT = "결과 : ";
    public static final OutputView INSTANCE = new OutputView();

    private OutputView() {
    }

    public void print(Integer result) {
        System.out.println(PROMPT + result);
    }
}
