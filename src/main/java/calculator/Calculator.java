package calculator;

public class Calculator {

    public int calculate(String input) {
        // 입력이 비어있을 경우 0을 반환
        if (input == null || input.isEmpty()) {
            return 0;
        }

        int sum = 0;  // 합계를 저장할 변수
        int startIndex = 0; // 문자열에서 실제 숫자가 시작하는 인덱스
        char customDelimiter = 0; // 커스텀 구분자

        // 커스텀 구분자가 있는 경우 처리
        if (input.startsWith("//") && input.charAt(3) == '\\' && input.charAt(4) == 'n') {
            customDelimiter = input.charAt(2); // 커스텀 구분자를 저장
            startIndex = 5;  // "//;\n" 부분 이후부터 숫자가 시작됨
        }

        StringBuilder number = new StringBuilder(); // 숫자를 저장할 임시 변수

        // 커스텀 구분자 또는 기본 구분자(쉼표, 콜론)를 기준으로 문자열을 분리하여 숫자를 추출
        for (int i = startIndex; i < input.length(); i++) {
            char currentChar = input.charAt(i);

            // 구분자(쉼표, 콜론, 커스텀 구분자)를 만나면 숫자를 더함
            if (currentChar == ',' || currentChar == ':' || currentChar == customDelimiter) {
                try {
                    sum += Integer.parseInt(number.toString()); // 숫자로 변환해서 합계에 더하기
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("잘못된 입력값입니다. 숫자가 아닌 값이 포함되었습니다: " + number.toString());
                }
                number.setLength(0); // 숫자 저장을 위한 변수 초기화
            } else {
                // 숫자가 아닌 문자가 포함된 경우 예외 처리
                if (!Character.isDigit(currentChar)) {
                    throw new IllegalArgumentException("숫자가 아닌 값이 입력되었습니다: " + currentChar);
                }
                number.append(currentChar); // 숫자를 임시 변수에 저장
            }
        }

        // 마지막 남은 숫자를 처리
        if (number.length() > 0) {
            try {
                sum += Integer.parseInt(number.toString());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("잘못된 입력값입니다. 숫자가 아닌 값이 포함되었습니다: " + number.toString());
            }
        }

        return sum; // 최종 합계를 반환
    }
}
