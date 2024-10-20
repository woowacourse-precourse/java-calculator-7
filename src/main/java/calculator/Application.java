package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String delimiter = "[,:]"; // 기본 구분자 설정
        int result = 0;

        // 1. 사용자 입력 받기
        String userInput = Console.readLine();

        // 2. 빈 입력인 경우 0 출력
        if (userInput == null || userInput.trim().isEmpty()) {
            System.out.println("결과 : 0");
            return;
        }

        // 3. 커스텀 구분자가 있는지 확인
        if (userInput.startsWith("//")) {
            int delimiterIndex = userInput.indexOf("\n");
            if (delimiterIndex == -1) {
                // \n이 없으면 잘못된 입력이므로 예외 발생
                throw new IllegalArgumentException("잘못된 입력입니다. 구분자 선언 후 \\n이 필요합니다.");
            }
            // 커스텀 구분자 추출
            delimiter = userInput.substring(2, delimiterIndex);
            if (delimiter.isEmpty()) {
                // 구분자가 비어 있으면 예외 발생
                throw new IllegalArgumentException("구분자가 비어 있습니다.");
            }
            // 문자열에서 커스텀 구분자 부분 제거
            userInput = userInput.substring(delimiterIndex + 1);
        }

        // 4. 구분자 기준으로 숫자 분리
        String[] numbers = userInput.split(delimiter);

        // 5. 분리된 숫자들을 더하기
        for (String number : numbers) {
            String trimmedNumber = number.trim();

            // 숫자가 아닌 경우 예외 발생
            if (!isNumeric(trimmedNumber)) {
                throw new IllegalArgumentException("유효하지 않은 숫자: " + number);
            }
            result += Integer.parseInt(trimmedNumber);
        }

        // 6. 결과 출력
        System.out.println("결과 : " + result);
    }

    // 숫자인지 확인하는 메서드
    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
