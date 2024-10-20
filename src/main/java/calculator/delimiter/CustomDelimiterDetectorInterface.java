package calculator.delimiter;

public interface CustomDelimiterDetectorInterface {
    String findCustomDelimiter(String text);
    String removeCustomDelimiter(String text, String delimiter);
}
