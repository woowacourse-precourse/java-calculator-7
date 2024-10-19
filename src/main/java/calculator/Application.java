package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Application {
    public static void main(String[] args) {
        // 사용자 입력 받는 부분
        System.out.println("더하기 진행할 문자열을 입력해주세요.");
        String input = Console.readLine();

        try {
            int result = StringAddCalculator.add(input);
            System.out.println("계산 결과: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력입니다: " + e.getMessage());
        }
    }

    public static class StringAddCalculator {
        public static int add(String input) {
            // 빈 문자열 혹은 null 체크 후 이에 해당될 경우 0 반환
            if (input == null || input.isBlank()) {
                return 0;
            }

            // 쉼표 또는 콜론을 문자열 분리 디폴트로 설정
            String delimiter = "[,:]";
            String numbers = input;

            // 커스텀 구분자 입력 확인 및 처리
            if (input.startsWith("//")) {
                int endIndexDelimiter = input.indexOf("\n");
                delimiter = input.substring(2, endIndexDelimiter);
                numbers = input.substring(endIndexDelimiter + 1);

                delimiter = escapeSpecialCharacters(delimiter);
            }

            // 구분자 기준으로 문자열 분리
            String[] tokens = numbers.split(delimiter);

            // 숫자 합 저장 변수 선언
            int sum = 0;

            // 음수 값 저장 용도 배열
            int[] negativeNumbers = new int[tokens.length];
            int negativeCount = 0;

            // 각 숫자 합산 도출
            for (String token : tokens) {
                int number = Integer.parseInt(token.trim()); // 문자열을 정수로 변환하여 합산
                // 음수일 경우 해당 배열에 추가
                if (number < 0) {
                    negativeNumbers[negativeCount++] = number;
                }
                // 1000 초과하는 숫자는 연산 대상에서 제외
                else if (number <= 1000) {
                    sum += number;
                }
            }

            // 음수가 있을 경우 예외 발생
            if (negativeCount > 0) {
                throw new IllegalArgumentException("Negative numbers are not allowed: "
                        + Arrays.toString(Arrays.copyOf(negativeNumbers, negativeCount)));
            }

            return sum;
        }

        // 정규식 특수문자 처리용 메소드
        private static String escapeSpecialCharacters(String delimiter) {
            return delimiter.replaceAll("([\\[\\]{}()*+?^$\\\\|.])", "\\\\$1");
        }
    }
}
