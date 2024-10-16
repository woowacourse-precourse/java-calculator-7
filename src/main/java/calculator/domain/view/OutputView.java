package calculator.domain.view;

public class OutputView {

    private final Integer sum;

    private static final String OUTPUT_TEXT = "결과 : ";

    public OutputView(int sum) {
        this.sum = sum;
    }

    public void output() {
        System.out.println(OUTPUT_TEXT + sum);
    }
}
