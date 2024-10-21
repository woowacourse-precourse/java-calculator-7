package calculator;

import java.util.ArrayList;

public class Parser {
    static int result = 0;
    static ArrayList<Integer> numbers;

    public static String parse(String input, Delimiter delimiter) {
        String delimiters = delimiter.getDelimiters(); // Delimiter에서 구분자 정보 가져오기
        numbers = new ArrayList<>();

        for (String number : input.split(delimiters)) {
            numbers.add(Integer.parseInt(number));
        }

        for (int number : numbers) {
            result += number;
        }

        return String.valueOf(result);
    }
}
