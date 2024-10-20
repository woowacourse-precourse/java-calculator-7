package calculator;

import java.util.ArrayList;

public class StringUtil {
    public static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    public static String getCustomDelimiter(String input, int index) {
        return input.substring(2, index);
    }

    public static ArrayList<Integer> split(String input, String delimiter) {
        ArrayList<Integer> result = new ArrayList<>();
        StringBuilder number = new StringBuilder();
        for (char c : input.toCharArray()) {
            if (c == '-') {
                throw new IllegalArgumentException("음수를 입력할 수 없습니다.");
            }
            if (isDigit(c)) {
                number.append(c);
            }
            else if (delimiter.indexOf(c) >= 0 && !number.isEmpty()) {
                if (number.toString().equals("0")) {
                    throw new IllegalArgumentException("0을 입력할 수 없습니다.");
                }
                else {
                    result.add(Integer.parseInt(number.toString()));
                    number.setLength(0);
                }
            }
            else {
                throw new IllegalArgumentException("유효하지 않은 문자: " + c);
            }
        }
        if (number.toString().isEmpty()) {
            throw new IllegalArgumentException("구분자 이후에 수가 없습니다.");
        }
        if (number.toString().equals("0")) {
            throw new IllegalArgumentException("0을 입력할 수 없습니다.");
        }
        result.add(Integer.parseInt(number.toString()));  // 마지막 문자 추가
        return result;
    }
}
