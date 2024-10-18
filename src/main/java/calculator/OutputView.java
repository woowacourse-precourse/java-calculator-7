package calculator;

public class OutputView {
    int result;

    public OutputView(int result) {
        this.result = result;
        printResult();
    }

    private void printResult() {
        System.out.println("결과 : " + result);
    }
}
