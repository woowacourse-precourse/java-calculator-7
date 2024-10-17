package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static List<String> separators = new ArrayList<>(Arrays.asList(",", ":"));

    public static void main(String[] args) {
        String input = readLine();
        if (isCustomSeparator(input)) {
            try {
                input = extractCustomSeparator(input, separators);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }
        System.out.println(separators);

        int[] numbers = extractNumbers(input, separators);
        int sumValue = sum(numbers);

        System.out.println(sumValue);
    }

    public static int sum(int[] numbers) {
        return Arrays.stream(numbers).sum();
    }

    public static int[] extractNumbers(String input, List<String> separators) {
        String separatorsRegex = String.join("|", separators);
        System.out.println(input);
        System.out.println(Arrays.toString(input.split(separatorsRegex)));
        return Arrays.stream(input.split(separatorsRegex)).mapToInt(Integer::parseInt).toArray();
    }

    public static boolean isCustomSeparator(String input) {
        return input.startsWith("//");
    }

    public static String extractCustomSeparator(String input, List<String> separators) {
        Matcher matcher = Pattern.compile("//(.*?)\\\\n(.*)").matcher(input);

        if (matcher.find()) {
            String customSeparator = matcher.group(1);  // 커스텀 구분자
            String extractNumber = matcher.group(2);  // 나머지 문자열

            if (Objects.equals(customSeparator, ".")) {
                separators.add("\\.");
            } else {
                separators.add(customSeparator);
            }

            return extractNumber;
        } else {
            throw new IllegalArgumentException("커스텀 구분자를 찾을 수 없습니다.");
        }
    }
}
