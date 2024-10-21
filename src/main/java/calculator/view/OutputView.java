package calculator.view;


public class OutputView {
    public void printResult(int result) {
        System.out.println("°á°ú : " + result);
    }

    public void printError(String message) {
        System.out.println("[ERROR] " + message);
    }
}