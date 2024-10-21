package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputStr = Console.readLine();

        try {
            displayResult(isNull(inputStr) ? 0 : sumNum(splitInput(inputStr)));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            Console.close();
        }
    }

    // 입력 문자열을 처리하고 합산 결과 반환
    private static String[] splitInput(String inputStr) {
        if (inputStr.startsWith("//")) {
            String delimiter = inputStr.substring(2, inputStr.indexOf("\\n"));
            inputStr = inputStr.substring(inputStr.indexOf("\\n") + 2);
            return splitString(inputStr, delimiter);
        }
        return splitString(inputStr, ",|:");
    }

    // 분리된 문자열 합산
    private static int sumNum(String[] numbers) {
        return Arrays.stream(numbers).mapToInt(num -> {
            try {
                int intNum = Integer.parseInt(num);
                if (intNum < 0) {
                    throw new IllegalArgumentException();
                }
                return intNum;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }).sum();
    }


    // 문자열을 구분자로 분리하고 빈 문자열을 무시
    private static String[] splitString(String inputStr, String delimiter) {
        return Arrays.stream(inputStr.split(delimiter))
                .filter(s -> !isNull(s)) // 빈 문자열 무시
                .toArray(String[]::new);
    }

    // 결과 출력
    private static void displayResult(int result) {
        System.out.println("결과: " + result);
    }

    // 문자열이 null 또는 빈 문자열인지 확인
    private static boolean isNull(String s) {
        return s == null || s.isEmpty();
    }
}
