package calculator;

public class Delimiter {

    public static String[] getDelimiter(String word) {

        if (word.startsWith("//")) {
            return customDelimiter(word);
        }
        return defaultDelimiter(word);

    }

    private static String[] defaultDelimiter(String words) {
        String[] numbers = words.split("[,:]");
        Validator.validateNumbers(numbers);
        return numbers;
    }

    private static String[] customDelimiter(String words) {
        Validator.validateCustomDelimiterFormat(words);

        String regex = words.substring(2, 3);
        String numbersPart = words.substring(5);

        String[] numbers = numbersPart.split(regex);
        Validator.validateNumbers(numbers);
        return numbers;

    }

}
