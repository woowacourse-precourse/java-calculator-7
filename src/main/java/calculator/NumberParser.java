package calculator;

import java.util.ArrayList;
import java.util.List;

public class NumberParser {

    public List<Long> parse(String string, List<Character> delimiters) {
        String regex = delimitersToRegex(delimiters);
        String[] splitted = string.split(regex);

        // 숫자 개수가 10억보다 크면 에러
        if (splitted.length > 1e9) {
            throw new IllegalArgumentException("숫자는 10억개 이하여야 합니다");
        }

        List<Long> numbers = new ArrayList<Long>();
        for (String stringNum : splitted) {
            if (stringNum.isEmpty()) { continue; }

            if (stringNum.length() > 9) {
                throw new IllegalArgumentException("숫자는 10억보다 작아야 합니다");
            }

            numbers.add(Long.parseLong(stringNum));
        }

        return numbers;
    }

    private String delimitersToRegex(List<Character> delimiters) {
        StringBuilder regex = new StringBuilder("[");
        for (Character delimiter : delimiters) {
            regex.append("\\").append(delimiter);
        }

        regex.append("]");
        return regex.toString();
    }

}
