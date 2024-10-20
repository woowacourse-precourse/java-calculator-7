package calculator;

public class InputData {

    private String delimiters = ",|:";
    private String numbers;

    public InputData(String input) {
        parseDelimiterAndNumbers(input);
        this.numbers = numbers;
        this.delimiters = delimiters;
    }

    private void parseDelimiterAndNumbers(String input) {
        if (input.startsWith("//")) {
            int idx = input.indexOf("\\n");
            delimiters += "|" + input.substring(2, idx);
            numbers = input.substring(idx + 2);
        } else {
            numbers = input;
        }
    }

    public String getDelimiters() {
        return delimiters;
    }

    public String getNumbers() {
        return numbers;
    }
}
