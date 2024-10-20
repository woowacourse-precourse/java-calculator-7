package calculator;


import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        String delimiter;
        String numbers;

        if (isCustomDelimiterPattern(input)) {
            delimiter = getCustomDelimiter(input);
            numbers = getNumbersAfterDelimiter(input);

            if (!isValidCustomPattern(numbers, delimiter)) {
                throw new IllegalArgumentException("잘못된 입력입니다. 커스텀 구분자와 숫자만 포함되어야 합니다.");
            }
        }else if (isValidDefaultPattern(input)) {
            delimiter = ",|:";
            numbers = input;

        }else {

            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        if (isEmptyString(numbers)) {
            return;
        }

        validateContinuousDelimiters(numbers, delimiter);

        String[] tokens = numbers.split(delimiter);
        long sum = calculateSum(tokens);

        System.out.println("결과 : " + sum);


    }
    private static boolean isCustomDelimiterPattern(String input) {
        Pattern pattern = Pattern.compile("//(.)\\\\n.*");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }


    private static String getCustomDelimiter(String input) {
        Pattern pattern = Pattern.compile("//(.)\\\\n.*");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            String delimiter = matcher.group(1);
            if (delimiter.matches("[0-9]")) {
                throw new IllegalArgumentException("숫자는 구분자로 사용할 수 없습니다.");
            }
            return delimiter;
        }

        throw new IllegalArgumentException("올바른 커스텀 구분자가 없습니다.");
    }

    private static String getNumbersAfterDelimiter(String input) {
        Pattern pattern = Pattern.compile("//.\\\\n(.*)");
        Matcher matcher = pattern.matcher(input);
        if (matcher.find()) {
            return matcher.group(1);
        }
        return "";
    }


    private static boolean isValidCustomPattern(String numbers, String delimiter) {
        String regex = "^[0-9" + Pattern.quote(delimiter) + "]*$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(numbers);
        return matcher.matches();
    }
    private static boolean isValidDefaultPattern(String input) {
        Pattern pattern = Pattern.compile("^[0-9,:]*$");
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    private static void validateContinuousDelimiters(String numbers, String delimiter) {
        if (!delimiter.equals(",|:")) {
            if (numbers.contains(delimiter + delimiter)) {
                throw new IllegalArgumentException("커스텀 구분자가 연속될 수 없습니다: " + delimiter);
            }
        } else {
            if (numbers.contains(",,") || numbers.contains("::")) {
                 throw new IllegalArgumentException("연속된 쉼표(,) 또는 콜론(:)은 허용되지 않습니다.");
            }
        }
    }

    private static boolean isEmptyString(String numbers) {
        if (numbers.isEmpty()) {
            System.out.println("결과 : 0");
            return true;
        }
        return false;
    }
    private static long calculateSum(String[] tokens) {
        long sum = 0;

        for (String token : tokens) {
            long number = parseNumber(token);
            checkOverflow(sum, number);
            sum += number;
        }

        return sum;
    }

    private static long parseNumber(String token) {
        try {
            return Long.parseLong(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력 값이 long의 범위를 초과합니다: " + token);
        }
    }

    private static void checkOverflow(long sum, long number) {
        if (sum > Long.MAX_VALUE - number) {
            throw new IllegalArgumentException("덧셈 결과가 long의 범위를 초과합니다.");
        }
    }


}