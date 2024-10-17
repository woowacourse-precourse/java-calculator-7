package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String calcFormula = readLine();
        String customSeparator = extractCustomSeparator(calcFormula);
        List<Long> numbers = extractNumber(calcFormula, customSeparator);
        long sum = calcNumbers(numbers);
        System.out.print("결과 : " + sum);
    }

    public static String extractCustomSeparator(String calcFormula) {
        String regex = "/{2}.\\\\n";

        int index;
        for (index = 0; index < calcFormula.length(); index++) {
            char c = calcFormula.charAt(index);
            if (c - '0' >= 0 && c - '0' <= 9) {
                break;
            }
        }

        if (index == 0) {
            return "";
        }
        if (index % 5 != 0) {
            throw new IllegalArgumentException("커스텀 구분자 지정 규칙이 틀렸습니다.");
        }

        String substring = calcFormula.substring(0, index);

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(substring);

        StringBuilder customSeparator = new StringBuilder();

        while (matcher.find()) {
            customSeparator.append(matcher.group().charAt(2));
        }

        if (customSeparator.length() != (index / 5)) {
            throw new IllegalArgumentException("커스텀 구분자 지정 규칙이 틀렸습니다.");
        }

        return customSeparator.toString();
    }

    public static List<Long> extractNumber(String calcFormula, String customSeparator) {
        String substring = calcFormula.substring(customSeparator.length() * 5);

        try {
            return Arrays.stream(substring.split("[" + customSeparator + ":,]"))
                    .map(Long::parseLong)
                    .filter(n -> {
                        if (checkNegativeNumber(n)) {
                            throw new IllegalArgumentException("음수는 입력으로 들어오지 못합니다.");
                        }
                        return true;
                    })
                    .toList();
        } catch (NumberFormatException e) {
            String message = e.getMessage();
            String errorInput = message.substring(message.indexOf(':') + 3, message.length() - 1);

            for (int i = 0; i < errorInput.length(); i++) {
                char c = errorInput.charAt(i);
                if (c - '0' < 0 || c - '0' > 9) {
                    throw new IllegalArgumentException("구분자 이외의 문자가 수식에 포함되있습니다.");
                }
            }

            throw new IllegalArgumentException("입력값이 long 범위를 넘어갔습니다.");
        }
    }

    public static boolean checkNegativeNumber(long number) {
        return number < 0;
    }

    public static long calcNumbers(List<Long> numbers) {
        long sum = 0L;
        long maxValue = Long.MAX_VALUE;

        for (long number : numbers) {
            if (maxValue - number < 0) {
                throw new IllegalArgumentException("결과값이 long 범위를 넘어갔습니다.");
            } else {
                sum += number;
                maxValue -= number;
            }
        }

        return sum;
    }
}
