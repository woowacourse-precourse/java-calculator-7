package calculator.view;

public class OutputView {

    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printMessageWithNumber(String message, int number) {
        System.out.print(message + number);
    }
}
