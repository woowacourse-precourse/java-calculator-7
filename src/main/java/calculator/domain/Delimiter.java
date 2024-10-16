package calculator.domain;

public class Delimiter {

    private static boolean hasCustomDelimiter(String input) {
        return input.startsWith("//") && input.contains("\n");
    }
}
