package calculator;

import camp.nextstep.edu.missionutils.Console;

public class CaculatorMachine {

    public void run() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String userInput = Console.readLine();
        
    }

    public static int calculate(String userInput) {

        // 입력 문자열이 공백인 경우
        if (userInput == null || userInput.isEmpty()) {
            return 0;
        }
        // 구분자 선언
        String defaultDelimiter = ",|:";
        String customDelimiter = "";

        // 커스텀 구분자일 경우
        if (userInput.startsWith("//")) {
            // "//"가 2번 이상 존재하는 경우
            if (userInput.indexOf("//", 2) != -1) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }

            int delimiterEndIndex = userInput.indexOf("\\n");
            // "//"만 존재하는 경우
            if (delimiterEndIndex == -1) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }
            // "\n"이 2번 이상 존재하는 경우
            if (userInput.indexOf("\\n", delimiterEndIndex + 1) != -1) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }

            customDelimiter = userInput.substring(2, delimiterEndIndex);
            // 커스텀 구분자가 1개가 아닌 경우
            if (customDelimiter.length() != 1) {
                throw new IllegalArgumentException("잘못된 입력입니다.");
            }

            defaultDelimiter = defaultDelimiter + "|" + customDelimiter;

            // 커스텀 구분자 생성하는 부분 제외한 입력 부분 추출
            userInput = userInput.substring(delimiterEndIndex + 2);

        }

        // 구분자로 시작하거나 끝나는 경우
        if (userInput.startsWith(defaultDelimiter) || userInput.endsWith(defaultDelimiter)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        // 구분자가 연속으로 나오는 경우 예외 처리
        if (userInput.contains(",,") || userInput.contains("::") || userInput.contains(",:") || userInput.contains(
                ":,")) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }
        // 커스텀 구분자가 연속으로 나오는 경우 예외 처리
        if (!customDelimiter.isEmpty() && userInput.contains(customDelimiter + customDelimiter)) {
            throw new IllegalArgumentException("잘못된 입력입니다.");
        }

        // 구분자를 기준으로 문자열 분리
        if (userInput.contains(defaultDelimiter)) {
            String[] numbers = userInput.split(defaultDelimiter);
            // 숫자의 합을 저장할 변수
            int sum = 0;
            for (String number : numbers) {
                // 숫자 중간에 공백이 존재하는 경우
                if (number.contains(" ")) {
                    throw new IllegalArgumentException("잘못된 입력입니다.");
                }

                try {
                    int num = Integer.parseInt(number);
                    // 숫자가 음수일 경우
                    if (num < 0) {
                        throw new IllegalArgumentException("잘못된 입력입니다.");
                    }
                    sum += num;
                    // 숫자가 아닐 경우
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException("잘못된 입력입니다.");
                }
            }
            return sum;
        } else {
            // 커스텀 구분자 선언은 존재하나, 사용하지 않은 경우
            return Integer.parseInt(userInput);
        }


    }

}
