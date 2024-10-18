package calculator;

public class StringSplitter {
    private static String BASIC_DELIMITER = ",|:";
    public String[] split(String input) {
        return input.split(BASIC_DELIMITER);
    }
}
