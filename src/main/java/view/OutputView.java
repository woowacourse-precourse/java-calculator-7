package view;

public class OutputView {

    public void printResult(int sum) {
        System.out.println("결과 : " + sum);
    }

    public void printError(Exception exception) {
        System.out.println(exception.getMessage());
    }
}
