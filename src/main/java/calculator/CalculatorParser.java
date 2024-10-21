package calculator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.Arrays;

public class CalculatorParser {
    public static List<String> parser(String input) {
    if (input == null || input.trim().isEmpty()) {
        throw new IllegalArgumentException("빈 문자열은 허용되지 않습니다.");
    }

    String delimiter = ",|:";
    String numbers = input;

  // 커스텀 구분자 
    if (input.startsWith("//")) {
        int newLineIndex = input.indexOf("\\n");

        if (newLineIndex == -1) {
            throw new IllegalArgumentException("커스텀 구분자 형식이 올바르지 않습니다.");
        }
        delimiter = Pattern.quote(input.substring(2, newLineIndex));
        numbers = input.substring(newLineIndex + 2); 
     }
    return Arrays.asList(numbers.split(delimiter));
    }
}