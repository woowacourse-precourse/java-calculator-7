package calculator.model;

public class Delimiter {

    private String delimiter;

    public Delimiter(String delimiter) {
        if (delimiter.equals(",|:")) {
            this.delimiter = delimiter;
            return;
        }
        valid(delimiter);
        this.delimiter = delimiter;
    }

    public String getDelimiter() {
        return delimiter;
    }


    public void valid(String delimiter) {

    }
}
