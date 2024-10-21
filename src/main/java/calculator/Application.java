package calculator;

import java.util.ArrayList;
import java.util.List;

public class Application {
    static int sum(List<Integer> numbers) {
        return numbers
            .stream()
            .reduce(Integer::sum)
            .orElse(0);
    }

    static List<Integer> parseNumberWithDelimiters(String str, List<Character> delimiters) {
        List<Integer> parsedNumbers = new ArrayList<>();
        int acc = -1;
        for (int i = 0 ; i < str.length(); i++) {
            char current = str.charAt(i);
            if (delimiters.contains(current)) {
                parsedNumbers.add(acc == -1 ? 0 : acc);
                acc = -1;
            } else if ('0' <= current && current <= '9') {
                if (current == '0' && acc == 0) {
                    throw new IllegalArgumentException("맨 앞 0은 한번밖에 올 수 없습니다.");
                }
                if (acc == -1) {
                    acc = 0;
                }
                acc = acc * 10 + (current - '0');
            } else {
                throw new IllegalArgumentException("숫자와 정해진 구분자외 다른 문자는 올 수 없습니다.");
            }
        }
        return parsedNumbers;
    }

    public static void main(String[] args) {
    }
}
