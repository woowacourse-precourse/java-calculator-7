package calculator.common.io;

public class Output {

    public void printMessage(String msg) {
        System.out.println(msg);
    }

    public void printResult(int result) {
        System.out.println("결과 : " + result);
    }

    public void printError(String errorMessage) {
        System.err.println(errorMessage);
    }
}
