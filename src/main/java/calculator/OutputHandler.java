package calculator;

public class OutputHandler {
    public void printResult(int result) {
        System.out.println("결과 : " + result);
    }

    public void printError(String message) {
        System.out.println("Error: " + message);
    }
}