package calculator.separator;

public interface SeparatorService {

    boolean checkCustomSeparator(String input);
    String getSeparator(String input);
    String[] splitBySeparator(String input, String separator);
}
