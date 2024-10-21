package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = Console.readLine(); // 사용자 입력 받기

            int result = add(input); // 결과 계산
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            throw e;
        }

    }

    public static int add(String input) {
        try {
            validateInput(input); // 입력 유효성 검사

            if(input.isEmpty()){
                return 0; //빈 문자열 처리
            }
            String delimiter = ",|:"; // 기본 구분자: 쉼표(,)와 콜론(:)
            String numbers = input;

            // 커스텀 구분자 처리
            if (input.startsWith("//")) {
                input = input.replace("\\n", "\n");
                String[] parts = input.split("\n", 2);
                delimiter = extractDelimiter(parts); // 구분자 추출
                numbers = parts[1]; // 숫자 부분 추출
            }
            return sumNumbers(numbers, delimiter); // 합산 결과 반환
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

    private static void validateInput(String input) {
        try {
            if (input == null) {
                throw new IllegalArgumentException("입력은 null이 될 수 없습니다."); // null 입력 처리
            }
        } catch (IllegalArgumentException e) {
            throw e; // 예외를 상위로 던짐
        }
    }

    private static String extractDelimiter(String[] parts) {
        try {
            if (isDelimiterFormatCorrect(parts)) {
                throw new IllegalArgumentException("올바르지 않은 커스텀 구분자 형식입니다.");
            }
            return parts[0].substring(2); // "//" 이후의 구분자 추출
        } catch (IllegalArgumentException e) {
            throw e; // 예외를 상위로 던짐
        }
    }


    private static boolean isDelimiterFormatCorrect(String[] parts) {
        return parts.length < 2 || parts[0].length() < 3; // 유효하지 않은 경우 true 반환
    }

    private static int sumNumbers(String numbers, String delimiter) {
        try {
            String[] tokens = numbers.split(delimiter);
            int sum = 0;

            for (String token : tokens) {
                if (!token.isEmpty()) {
                    int number = parseIntOrThrow(token.trim());
                    if (number < 0) {
                        throw new IllegalArgumentException("음수는 입력할 수 없습니다: " + number);
                    }
                    sum += number;
                }
            }
            return sum; // 최종 합산 결과 반환
        } catch (IllegalArgumentException e) {
            throw e; // 예외를 상위로 던짐
        }
    }

    private static int parseIntOrThrow(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("잘못된 숫자 형식입니다: " + value); // 잘못된 형식 처리
        }
    }
}
