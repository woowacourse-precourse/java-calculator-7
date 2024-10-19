package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Application {

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputString = Console.readLine();

        try {
            int result = calculateSum(inputString);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    // 문자열에서 합계를 계산하는 함수
    public static int calculateSum(String input) {
        if (isEmptyInput(input)) {
            return 0;
        }

        String delimiter = getDelimiter(input);
        String numbers = getNumbersString(input, delimiter);
        String[] numberArray = numbers.split(delimiter);

        return sumNumbers(numberArray);
    }

    // 입력이 빈 문자열인지 확인
    public static boolean isEmptyInput(String input) {
        return input == null || input.isEmpty();
    }

    // 입력 문자열에서 커스텀 구분자를 추출하는 함수
    public static String getDelimiter(String input) {
        Pattern customDelimiterPattern = Pattern.compile("//(.)\\\\n(.*)");
        Matcher matcher = customDelimiterPattern.matcher(input);

        if (matcher.matches()) {
            return Pattern.quote(matcher.group(1)); // 커스텀 구분자 반환
        }

        return ",|:"; // 기본 구분자
    }

    // 커스텀 구분자가 있는 경우 숫자 문자열을 추출
    public static String getNumbersString(String input, String delimiter) {
        if (input.startsWith("//")) {
            return input.split("\\\\n", 2)[1]; // 커스텀 구분자 이후의 숫자 문자열
        }
        return input;
    }

    // 문자열 배열에서 합을 계산하는 함수
    public static int sumNumbers(String[] numberArray) {
        int total = 0;
        for (String numberStr : numberArray) {
            int number = parseNumber(numberStr.trim());
            if (number < 0) {
                throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
            }
            total += number;
        }
        return total;
    }

    // 문자열을 숫자로 변환하는 함수 (형식 오류 처리)
    public static int parseNumber(String numberStr) {
        try {
            return Integer.parseInt(numberStr);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 숫자 형식이 포함되어 있습니다: " + numberStr);
        }
    }
}
