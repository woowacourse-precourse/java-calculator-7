package calculator.model;

public record Delimiter(String delimiter) {

    public Delimiter(String delimiter) {
        if (delimiter.equals(",|:")) {
            this.delimiter = delimiter;
            return;
        }
        valid(delimiter);
        this.delimiter = delimiter;
    }

    public void valid(String delimiter) {

    }
}
