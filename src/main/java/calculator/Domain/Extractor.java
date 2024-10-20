package calculator.Domain;

import calculator.Tool.Delimiters;
import java.util.ArrayList;

public class Extractor {

    public static ArrayList<Integer> extractNumbers(String input) {
        ArrayList<Integer> result = new ArrayList<>();

        String delimeter = Delimiters.getDelimiters();
        String[] extractedWords = input.split(delimeter);

        for (String word : extractedWords) {
            if (!word.trim().isEmpty()) { // 빈 문자열 무시
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
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("유효한 숫자가 아닙니다.");
        }
    }
}
