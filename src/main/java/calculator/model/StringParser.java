package calculator.model;

import java.util.Arrays;
import java.util.List;

public class StringParser {

    public List<Integer> parse(String[] stringArray) {
        try {
            return Arrays.stream(stringArray)
                    .filter(s -> !s.isEmpty())
                    .map(Integer::parseInt)
                    .toList();
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("[Error] 정수로 변환할 수 없는 입력이 포함되어 있습니다.");
        }
    }
}
