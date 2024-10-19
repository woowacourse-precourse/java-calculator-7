package calculator;

import camp.nextstep.edu.missionutils.Console;

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
        // 빈 문자열 혹은 null 체크
        public static int add(String input) {
            if (input == null || input.isBlank()) {
                return 0;
            }

            // 쉼표 또는 콜론을 기준으로 문자열 분리
            String delimiter = "[,:]";
            String numbers = input;

            // 커스텀 구분자 입력 확인
            if (input.startsWith("//")) {
                int endIndexDelimiter = input.indexOf("\n");
                delimiter = input.substring(2, endIndexDelimiter);
                numbers = input.substring(endIndexDelimiter + 1);

                delimiter = escapeSpecialCharacters(delimiter);
            }

            String[] tokens = numbers.split(delimiter);

            // 각 숫자의 합을 계산
            int sum = 0;
            for (String token : tokens) {
                sum += Integer.parseInt(token.trim()); // 문자열을 정수로 변환하여 합산
            }

            return sum;
        }

        private static String escapeSpecialCharacters(String delimiter) {
            return delimiter.replaceAll("([\\[\\]{}()*+?^$\\\\|.])", "\\\\$1");
        }
    }
}
