package calculator;

public class StringCalculator {
    private final String userInput;
    private String delimiter;
    private String string;
    private String[] substrings;

    StringCalculator(String userInput) {
        this.userInput = userInput;
        this.delimiter = "[,:]";
        this.string = userInput;

        this.substrings = string.split(delimiter);
    }

    public int stringSum() {
        int sum = 0;

        for (String substring : substrings) {
            if (!substring.isEmpty()) {
                sum += Integer.parseInt(substring);
            }
        }

        return sum;
    }
}
