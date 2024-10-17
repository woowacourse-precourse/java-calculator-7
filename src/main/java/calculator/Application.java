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
        Pattern pattern = Pattern.compile(regex);

        Matcher matcher = pattern.matcher(calcFormula);

        StringBuilder customSeparator = new StringBuilder();

        while (matcher.find()) {
            customSeparator.append(matcher.group().charAt(2));
        }

        return customSeparator.toString();
    }

    public static List<Long> extractNumber(String calcFormula, String customSeparator) {
        String substring = calcFormula.substring(customSeparator.length() * 5);

        try {
            return Arrays.stream(substring.split("[" + customSeparator + ":,]"))
                    .map(Long::parseLong)
                    .filter(n -> {
                        if (checkNegativeNumber(n))
                            throw new IllegalArgumentException("음수는 입력으로 들어오지 못합니다.");
                        return true;
                    })
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값이 long 범위를 넘어갔습니다.");
        }
    }

    public static boolean checkNegativeNumber(long number) {
        return number < 0;
    }

    public static long calcNumbers(List<Long> numbers) {
        return numbers.stream().reduce(0L, Long::sum);
    }
}
