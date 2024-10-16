package calculator.model;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class NumberExtractor {
    public static void extractNumber(String inputString, Delimiters delimiters, Calculator calculator) {
        if (!isStartingWithDigit(inputString)) {
            throw new IllegalArgumentException();
        }
        ArrayList<String> splitedStringList = splitByDelimiters(delimiters, inputString);
        for (String str : splitedStringList) {
            validateNumberString(str);
            int number = Integer.parseInt(str);
            calculator.saveNumber(number);
        }
    }

    private static boolean isStartingWithDigit(String inputString) {
        char firstChar = inputString.charAt(0);
        return Character.isDigit(firstChar);
    }

    private static ArrayList<String> splitByDelimiters(Delimiters delimiters, String inputString) {
        String delimitersString = createDelimitersString(delimiters);
        StringTokenizer tokenizer = new StringTokenizer(inputString, delimitersString);
        ArrayList<String> splitedStringList = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            splitedStringList.add(tokenizer.nextToken());
        }
        return splitedStringList;
    }

    private static String createDelimitersString(Delimiters delimiters) {
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : delimiters.getDelimiters()) {
            stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

    private static void validateNumberString(String inputString) {
        for (char c : inputString.toCharArray()) {
            if (!Character.isDigit(c)) {
                throw new IllegalArgumentException();
            }
        }
    }
}
