package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 1. 사용자 입력 받기
        String userInput = getUserInput();

        // 2. 빈 입력 처리
        if (userInput == null || userInput.trim().isEmpty()) {
            printResult(0); // 빈 입력 시 0 출력
            return;
        }

        // 3. 커스텀 구분자가 있는지 확인하고 처리
        userInput = userInput.replace("\\n", "\n");
        String delimiter = extractCustomDelimiter(userInput);
        if (userInput.startsWith("//")) {
            // 문자열에서 커스텀 구분자 부분 제거
            userInput = userInput.substring(userInput.indexOf("\n") + 1);
        }

        // 4. 구분자 기준으로 숫자 분리
        String[] numbers = userInput.split(delimiter);

        // 5. 분리된 숫자들의 합 계산
        int result = sumNumbers(numbers);

        // 6. 결과 출력
        printResult(result);
    }

    // 1. 사용자 입력을 처리하는 메서드
    private static String getUserInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    // 3. 커스텀 구분자를 추출하는 메서드
    private static String extractCustomDelimiter(String input) {
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\n");
            if (delimiterIndex == -1 || delimiterIndex == 2) {
                throw new IllegalArgumentException("잘못된 입력입니다. 구분자가 비어있거나 \\n이 필요합니다.");
            }
            return input.substring(2, delimiterIndex); // 커스텀 구분자 반환
        }
        return "[,:]"; // 기본 구분자 반환
    }


    // 5. 숫자들을 더하는 메서드
    private static int sumNumbers(String[] numbers) {
        int result = 0;
        for (String number : numbers) {
            String trimmedNumber = number.trim();

            // 숫자가 아닌 경우 예외 발생
            if (!isNumeric(trimmedNumber)) {
                throw new IllegalArgumentException("유효하지 않은 숫자: " + number);
            }

            int parsedNumber = Integer.parseInt(trimmedNumber);

            // 음수 예외 처리
            if (parsedNumber < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다: " + number);
            }

            result += parsedNumber;
        }
        return result;
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

    // 6. 결과를 출력하는 메서드
    private static void printResult(int result) {
        System.out.println("결과 : " + result);
    }
}
