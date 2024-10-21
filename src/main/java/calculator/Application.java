package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputStr = Console.readLine();

        try {
            displayResult(isNullOrEmpty(inputStr) ? 0 : sumNum(splitInput(inputStr)));
        } catch (IllegalArgumentException e) {
            System.out.println("에러: " + e.getMessage());
        } finally {
            Console.close();
        }
    }

    // 입력 문자열을 처리하고 구분자에 따라 분리
    private static String[] splitInput(String inputStr) {
        if (inputStr.startsWith("//")) {
            if (!inputStr.contains("\\n")) {
                throw new IllegalArgumentException("구분자 형식이 올바르지 않습니다.");
            }
            String delimiter = inputStr.substring(2, inputStr.indexOf("\\n"));
            inputStr = inputStr.substring(inputStr.indexOf("\\n") + 2); // 숫자 부분 추출
            return splitString(inputStr, delimiter);
        }
        return splitString(inputStr, ",|:"); // 기본 구분자
    }

    // 문자열을 구분자로 분리하고 빈 값은 무시
    private static String[] splitString(String inputStr, String delimiter) {
        return Arrays.stream(inputStr.split(delimiter))
                .filter(s -> !isNullOrEmpty(s)) // 빈 문자열 무시
                .toArray(String[]::new);
    }

    // 분리된 문자열을 합산
    private static int sumNum(String[] numbers) {
        return Arrays.stream(numbers).mapToInt(num -> {
            try {
                int intNum = Integer.parseInt(num);
                if (intNum < 0) {
                    throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + num);
                }
                return intNum;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("유효하지 않은 값이 포함되어 있습니다: " + num);
            }
        }).sum();
    }

    // 결과 출력
    private static void displayResult(int result) {
        System.out.println("결과: " + result);
    }

    // 문자열이 null 또는 빈 문자열인지 확인
    private static boolean isNullOrEmpty(String s) {
        return s == null || s.isEmpty();
    }
}
