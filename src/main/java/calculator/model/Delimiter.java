package calculator.model;

public class Delimiter {
    private String delimiter = "[,:]";

    public String getDelimiter() {
        return delimiter;
    }

    public void addDelimiter(String newDelimiter) {
        this.delimiter = this.delimiter.substring(0, this.delimiter.length() - 1) + newDelimiter + "]";
    }
}
