package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    public static void main(String[] args) {
        List<String> separators = new ArrayList<>(Arrays.asList(",", ":"));
        String input = Console.readLine();

        String customSeparator = extractCustomSeparator(input);
        separators.add(customSeparator);
        validInput(input, separators);

        if (customSeparator != null) {
            input = input.substring(input.indexOf("\\n") + 2);
        }

        long result = calculate(input, separators);
        System.out.println("결과 : " + result);
    }

    private static String extractCustomSeparator(String input) {
        String customSeparator = null;
        if (input.indexOf("//") == 0 && input.indexOf("\\n") >= 3) {
            customSeparator = input.substring(2, input.indexOf("\\n"));
            validSeparator(customSeparator);
        }
        return customSeparator;
    }

    private static void validSeparator(String separator) {
        if (separator.length() > 1) {
            throw new IllegalArgumentException("구분자는 한 글자만 가능합니다.");
        }
        if (separator.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("구분자로 숫자는 입력될 수 없습니다.");
        }
    }

    private static void validInput(String input, List<String> customSeparator) {
        Pattern pattern = Pattern.compile(
                "((^//)[^0-9](\\\\n))?([0-9]*["
                        + String.join("", customSeparator)
                        + "]?[0-9])*"
        );

        Matcher m = pattern.matcher(input);
        if (!m.replaceAll("").isEmpty()) {
            throw new IllegalArgumentException("입력 형식이 잘못되었습니다.");
        }
    }

    private static long calculate(String input, List<String> separators) {
        if (input.isEmpty()) {
            return 0;
        }
        return Arrays
                .stream(input.split(String.join("|", separators))).
                mapToLong(Long::parseLong).sum();
    }
}
