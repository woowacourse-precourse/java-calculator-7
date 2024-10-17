package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    final static String cutomSeparatorStart = "//";
    final static String cutomSeparatorEnd = "\\n";
    final static String or = "|";
    final static String numberRegex = "\\d+"; // s.matches(numberRegex)

    private String input;
    private String separatorRegex;

    Calculator(String input) {
        this.input = input;
        this.separatorRegex = ",|:";
    }

    public void setSeparatorRegex(String additionalSeparator) {
        if (additionalSeparator.isEmpty())
            return ;

        this.separatorRegex = this.separatorRegex + or + additionalSeparator;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public Integer caculate() {
        List<String> strings = extract();
        System.out.println(strings);

        List<Integer> numbers = stringToInteger(strings);

        Integer result = sum(numbers);

        return result;
    }

    private List<String> extract() {
        List<String> strings = new ArrayList<>();

        if (input.isEmpty())
            return strings;

        if (input.startsWith(cutomSeparatorStart)) {
            if (input.contains(cutomSeparatorEnd)) {
                String customDelim = input.substring(2, input.indexOf(cutomSeparatorEnd));
                setSeparatorRegex(customDelim);

                int startIdx = input.indexOf(cutomSeparatorEnd) + cutomSeparatorEnd.length();
                setInput(input.substring(startIdx));
            } else {
                throw new IllegalArgumentException("\n지정 구분자는 //와 \\n 사이에 입력해주세요");
            }
        }

        strings = Arrays.stream(input.split(separatorRegex))
                .toList();

        return strings;
    }

    private List<Integer> stringToInteger(List<String> strs) {
        List<Integer> numbers = strs.stream()
                .filter(s -> !s.isEmpty() && !s.isBlank())
                .map(s -> {
                    if (!s.matches(numberRegex))
                        throw new IllegalArgumentException(s + " 는 허용되지 않는 문자입니다");
                    return Integer.parseInt(s);
                })
                .toList();

        return numbers;
    }

    private Integer sum(List<Integer> numbers) {
        Integer result = 0;

        result = numbers.stream()
                .reduce(result, Integer::sum);

        return result;
    }
}
