package calculator;

public class StringCalculator {

    public  int add(String text) {
        if (text.isEmpty() || text == null) {
            return 0;
        }

        String delimiter = ",|:";

        if (text.startsWith("//")) {
            int delimiterIndex = text.indexOf("\n");
            delimiter = text.substring(2, delimiterIndex);
            text = text.substring(delimiterIndex + 1);
        }

        String[] tokens = splitNumbers(text, delimiter);
        return sumNumbers(tokens);
    }
}
