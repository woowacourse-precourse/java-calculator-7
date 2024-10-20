package calculator.view;

public class OutputView {

    public OutputView() {
    }

    public void printResult(int result) {
        if(result >= 0) {
            System.out.println("결과 : " + result);
        }
    }
}
