package calculator;

public class Application {
    private String processNull(String input) {
        if (input == null || input.isEmpty()) {
            return "0";
        }
        return input;
    }
}