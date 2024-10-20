package detector;

public interface CustomSeparatorDetector {
    String detectSeparator(String text);
    String removeCustomFormat(String text, String separator);
}
