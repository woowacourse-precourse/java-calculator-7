package view;

public class OutputView {

    public void printResult(int sum) {
        System.out.println("결과 : " + sum);
        System.out.println(); // 개행
    }

    public void printError(Exception exception) {
        System.out.println(exception.getMessage());
    }
}
