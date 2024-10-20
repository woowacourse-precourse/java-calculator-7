package calculator.util;

public class ErrorHandler {
    public static void handleError(Exception e) {
        System.out.println("An error occurred: " + e.getMessage());
    }
}
