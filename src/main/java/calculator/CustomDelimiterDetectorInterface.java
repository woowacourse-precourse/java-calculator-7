package calculator;

public interface CustomDelimiterDetectorInterface {
    String findCustomDelimiter(String text);
    String removeCustomDelimiter(String text, String delimiter);
}
