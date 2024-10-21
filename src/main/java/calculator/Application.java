package calculator;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("덧셈할 문자열을 입력해 주세요.");

        // 각종 flag
        Boolean hasCustomDivider = false;
        String divider = null;
        Integer result = 0;

        // 입력기능 - getInput() 차후 리팩토링
        String input_str = camp.nextstep.edu.missionutils.Console.readLine().trim();

        // 구분자 지정기능 - decideDivider() 차후 리팩토링
        String delimiter = ",|:"; // 기본 구분자
        String numbers = input_str;
        int newLineIndex = 0;

        if (input_str.startsWith("//")) {
            newLineIndex = input_str.indexOf("\\n"); // *문제의 코드*
//            System.out.println("newlineindex : " + newLineIndex);

            if (newLineIndex != -1) {
                divider = input_str.substring(2, newLineIndex);
                numbers = input_str.substring(newLineIndex + 1);
//                System.out.println("커스텀 구분자로 설정합니다: " + divider);
                hasCustomDivider = true;
            } else {
//                System.out.println("커스텀 구분자 형식이 잘못되었습니다. 기본 구분자를 사용합니다.");
            }
        } else {
//            System.out.println("기본 구분자로 설정합니다");
        }
        try {
            if (hasCustomDivider) {
                String[] temp_numbers = (input_str.substring(newLineIndex + 2)).split(divider);
                validateInput(temp_numbers);
                result += calculateSum(temp_numbers);
            } else {
                String[] temp_numbers = numbers.split(delimiter);
                validateInput(temp_numbers);
                result += calculateSum(temp_numbers);
            }
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("오류: " + e.getMessage());
            throw e; // 예외를 다시 던져서 테스트에서 감지할 수 있게 함
        }

        // 결과출력
        System.out.println("결과 : " + result);

    }

    public static int calculateSum(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(str -> {
                    try {
                        return Integer.parseInt(str.trim());
                    } catch (NumberFormatException e) {
//                        System.out.println("유효하지 않은 숫자입니다. 무시합니다: " + str);
//                        throw new NumberFormatException(e.getMessage());
                        return 0; // 유효하지 않은 숫자는 0으로 처리
                    }
                })
                .sum();
    }

    public static void validateInput(String[] numbers) {
        for (String str : numbers) {
            try {
                int num = Integer.parseInt(str.trim());
                if (num <= 0) {
                    throw new IllegalArgumentException("음수 또는 0은 허용되지 않습니다: " + num);
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("유효하지 않은 숫자입니다: " + str);
            }
        }

    }
}

