package calculator.service.util;

public class ManageDelimiters {
    private String delimiters = ":|,";

    public String getDelimiters() {
        return delimiters;
    }

    public void addDelimiter(String delimiter) {
        delimiters = delimiters + "|" + delimiter;
    }
}
