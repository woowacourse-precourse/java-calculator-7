package calculator.view;

public class OutputView {

    public static final String resultMessage = "결과 : ";

    public void printResult(int sum) {
        System.out.println(resultMessage + sum);
    }
}
