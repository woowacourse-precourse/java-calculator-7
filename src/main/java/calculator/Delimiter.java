package calculator;

public class Delimiter {

    public static String[] getDelimiter(String word) {

        return defaultDelimiter(word);

    }

    private static String[] defaultDelimiter(String words) {
        String[] numbers = words.split("[,:]");
        return numbers;
    }

}
