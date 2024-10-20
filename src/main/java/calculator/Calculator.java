package calculator;

public class Calculator {
    public static int add(String input) {
        if (input == null || input.equals("")) {
            return 0; // 입력이 null이거나 빈 문자열이면 0 반환
        }

        input = input.replace("\\n", "\n"); // 입력 문자열에서 "\n"을 실제 개행 문자로 변환

        String[] numbers = splitInput(input); // 문자열을 분리하여 배열로 저장
        int sum = 0;

        for (String numStr : numbers) {
            int num = toPositiveNumber(numStr); // 문자열을 숫자로 변환
            sum += num; // 합계 계산
        }

        return sum; // 총합 반환
    }

    private static String[] splitInput(String input) {
        String delimiter = ",|:"; // 기본 구분자

        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\n");
            if (delimiterIndex == -1) {
                throw new IllegalArgumentException("구분자 지정이 올바르지 않습니다.");
            }
            delimiter = input.substring(2, delimiterIndex); // 커스텀 구분자 추출
            input = input.substring(delimiterIndex + 1); // 숫자 부분 추출
        }

        return input.split(delimiter); // 구분자로 문자열 분리
    }

    private static int toPositiveNumber(String str) { // 양수로 변환
        int number;
        try {
            number = Integer.parseInt(str); // 문자열을 정수로 변환
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자 형식이 올바르지 않습니다."); // 숫자가 아닐 경우 예외 발생
        }

        if (number < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다."); // 음수일 경우 예외 발생
        }

        return number; // 양수로 반환
    }
}
