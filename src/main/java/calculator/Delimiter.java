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
        return numbers;
    }

    private static String[] customDelimiter(String words) {

        String regex = words.substring(2, 3);
        String numbersPart = words.substring(5);

        String[] numbers = numbersPart.split(regex);
        return numbers;

    }

}
