package calculator;

public class Application {
    private String processNull(String input) {
        if (input == null || input.isEmpty()) {
            return "0";
        }
        return input;
    }

    private String extractCustomSymbols(String input) {
        if (input.indexOf("/") == 0) {
            int startIndex = input.indexOf("/") + 2;
            int endIndex = input.indexOf("\\");
            return input.substring(startIndex, endIndex);
        }
        return "";
    }
}