package calculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class NumberParser {

    public List<Long> parse(String string, Set<Character> delimiters) {
        String[] splitted = RegexUtil.splitByDelimiters(string, delimiters);

        // 숫자 개수가 10억보다 크면 에러
        if (splitted.length > 1e9) {
            throw new IllegalArgumentException("숫자는 10억개 이하여야 합니다");
        }

        // 숫자가 10억보다 작은지 검사하고 long으로 바꾸어 저장
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

}
