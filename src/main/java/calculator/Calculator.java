package calculator;

import java.util.Arrays;
import java.util.regex.Pattern;

public class Calculator {

    private int sum;

    // 입력 받은 문자열을 구분자로부터 구분
    public String[] separateArr(String input) {

        // 커스텀 구분자를 사용하는 경우
        if (input.startsWith("//") && input.contains("\\n")) {
            int startIndex = input.indexOf("//");
            int endIndex = input.indexOf("\\n");

            String delimiter = input.substring(startIndex + 2, endIndex);
            String separatedUserInput = input.substring(endIndex + 2);

            return separatedUserInput.split(Pattern.quote(delimiter));
        }

        // 일반 구분자를 사용하는 경우
        return input.split("[,:]");
    }

    // 구분된 숫자의 합 계산
    public int addArr(String input) {
        return sum = Arrays.stream(separateArr(input))
                       .mapToInt(Integer::parseInt)
                       .sum();
    }

    public int getSum() {
        return sum;
    }
}
