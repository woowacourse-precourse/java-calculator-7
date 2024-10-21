package calculator;

public class OutputHandler {

    public void printResult(double result) {
        if (result % 1 == 0) {
            System.out.printf("결과 : %.0f\n", result);
        } else {
            System.out.printf("결과 : %f\n", result);
        }
    }
}
