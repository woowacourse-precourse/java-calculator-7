package calculator.view;

public class OutputView {
    private Long answer;

    public OutputView(Long answer) {
        this.answer = answer;
    }

    public void print() {
        System.out.println("결과 : " + this.answer);
    }
}
