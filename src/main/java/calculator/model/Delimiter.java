package calculator.model;

public class Delimiter {
    private String delimiter;

    public Delimiter() {
        this.delimiter = ",|:";
    }

    public void registerDelimiter(String delimiterSection) {
        for (int nowDelimiterIdx = 0; nowDelimiterIdx < delimiterSection.length(); nowDelimiterIdx++) {
            this.delimiter += ("|\\" + delimiterSection.charAt(nowDelimiterIdx));
        }
    }

    public String getDelimiter() {
        return delimiter;
    }
}
