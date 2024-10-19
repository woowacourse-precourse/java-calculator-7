package calculator;

import java.util.regex.Pattern;

public class StringCalculator {
    // 사용자 입력에서 \n을 실제 줄바꿈 문자로 변환

    /**
     * 입력 문자열에서 커스텀 구분자를 추출하고 숫자를 분리하여 합산하는 메서드
     * @param input 사용자 입력 문자열
     * @return 숫자들의 합
     */
    public int calculate(String input) {
        // 입력 값 디버깅
        input = input.replace("\\n", "\n");

        // 커스텀 구분자 처리
        if (input.startsWith("//")) {
            return sumWithCustomDelimiter(input, findDelimiter(input));
        } else if (input.isEmpty()) {
            return 0;
        } else {
            // 기본 구분자(쉼표와 콜론)로 처리
            return sumWithDefaultDelimiter(input);
        }
    }

    /**
     * 입력 문자열에서 "//"와 "\n" 사이에 있는 구분자를 추출하는 메서드
     * @param input 사용자 입력 문자열
     * @return 구분자 문자열
     */
    private String findDelimiter(String input) {
        // "\n"이 있는 위치 찾기
        int delimiterEndIndex = input.indexOf("\n");

        // "\n"이 없으면 예외 처리
        if (delimiterEndIndex == -1) {
            throw new IllegalArgumentException("잘못된 입력 형식입니다. //구분자\\n 형식을 사용하세요.");
        }

        // "//"와 "\n" 사이의 구분자 추출
        String customDelimiter = input.substring(2, delimiterEndIndex);

        return customDelimiter;
    }

    /**
     * 주어진 구분자를 사용해 문자열을 분리하고, 숫자들의 합을 계산하는 메서드
     * @param input 사용자 입력 문자열
     * @param customDelimiter 추출한 구분자
     * @return 숫자들의 합
     */
    private int sumWithCustomDelimiter(String input, String customDelimiter) {
        // "\n" 이후의 숫자 부분 추출
        int delimiterEndIndex = input.indexOf("\n");
        String numberPart = input.substring(delimiterEndIndex + 1).trim();

        // 디버깅용: 숫자 부분 출력
//        System.out.println("Number part: " + numberPart);

        // 구분자를 기준으로 숫자 분리
        String[] numbers = numberPart.split(Pattern.quote(customDelimiter));

        return sum(numbers);
    }

    /**
     * 기본 구분자(쉼표, 콜론)를 사용하여 숫자를 합산하는 메서드
     * @param input 사용자 입력 문자열
     * @return 숫자들의 합
     */
    private int sumWithDefaultDelimiter(String input) {
        String[] numbers = input.split("[,:]");
        return sum(numbers);
    }

    /**
     * 숫자 배열을 받아 합산하는 메서드
     * @param numbers 문자열로 된 숫자 배열
     * @return 숫자들의 합
     */
    private int sum(String[] numbers) {
        int total = 0;

        for (String number : numbers) {
            if (number.trim().isEmpty()) {
                throw new IllegalArgumentException("잘못된 숫자 형식이 포함되어 있습니다.");
            }
            try {
                int parsedNumber = Integer.parseInt(number.trim());

                // 음수 발견 시 즉시 예외 발생
                if (parsedNumber < 0) {
                    throw new IllegalArgumentException("음수는 허용되지 않습니다: " + parsedNumber);
                }

                total += parsedNumber;

            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 숫자 형식이 포함되어 있습니다.");
            }
        }

        return total;
    }

}