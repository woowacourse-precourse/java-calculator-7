package calculator.Domain;

import calculator.Message.ErrorMessage;
import calculator.Tool.Delimiters;
import java.util.ArrayList;

public class Extractor {

    public static ArrayList<Integer> extractNumbers(String input) {
        ArrayList<Integer> result = new ArrayList<>();

        String delimeter = Delimiters.getDelimiters();
        String[] extractedWords = input.split(delimeter);

        for (String word : extractedWords) {
            if (!word.trim().isEmpty()) {
                int number = validateNumber(word);
                result.add(number);
            }
        }
        return result;
    }

    private static int validateNumber(String token) {
        try {
            int number = Integer.parseInt(token);
            if (number < 0) {
                throw new IllegalArgumentException(ErrorMessage.NEGATIVE_NUMBER_INPUT_ERROR);
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_A_NUMBER_INPUT_ERROR);
        }
    }
}
