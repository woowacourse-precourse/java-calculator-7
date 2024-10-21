package calculator.view;

public class ErrorView {
    public static final String ERROR_MESSAGE = "[ERROR] ";

    public void errorPage(String message) {
        System.out.println(ERROR_MESSAGE + message);
    }
}
