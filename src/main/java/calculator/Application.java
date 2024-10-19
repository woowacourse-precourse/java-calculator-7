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

            // 각 숫자의 합 계산
            int sum = 0;
            for (String token : tokens) {
                sum += Integer.parseInt(token.trim()); // 문자열을 정수로 변환하여 합산
            }

            return sum;
        }

        // 정규식 특수문자 처리용 메소드
        private static String escapeSpecialCharacters(String delimiter) {
            return delimiter.replaceAll("([\\[\\]{}()*+?^$\\\\|.])", "\\\\$1");
        }
    }
}
