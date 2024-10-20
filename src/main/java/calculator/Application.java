package calculator;


import java.util.regex.Pattern;

public class Application {

    public int stringAdd(String text) {
        if (text == null || text.isBlank()) {
            return 0;
        }
        String[] numbers = splitNumbers(text);
        return calculateSum(numbers);

    }

    private static String[] splitNumbers(String text) {
        if (text.startsWith("//")) {
            int delimiterIndex = text.indexOf("\\n");
            if (delimiterIndex != -1) {
                String delimiter = text.substring(2, delimiterIndex);
                String numberPart = text.substring(delimiterIndex + 2);
                return numberPart.split(Pattern.quote(delimiter));
            }
        }
        return text.split(",|:");
    }

    private int calculateSum(String[] numbers) {
        int sum = 0;
        for (String number : numbers) {
            int intValue = Integer.parseInt(number);
            if (intValue < 0) {
                throw new IllegalArgumentException();
            }
            sum += intValue;
        }
        return sum;
    }
}