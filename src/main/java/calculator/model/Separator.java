package calculator.model;

public class Separator {
    public String separator = ",:";

    public void append(String customSeparator) {
        separator += customSeparator;
    }
}
