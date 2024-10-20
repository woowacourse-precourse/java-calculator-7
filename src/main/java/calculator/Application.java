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

        //3. 커스텀 구분자가 있는지 확인
        if (userInput.startsWith("//")) {
            int delimiterIndex = userInput.indexOf("\n");
            if (delimiterIndex != -1) {
                // 커스텀 구분자 추출
                delimiter = userInput.substring(2, delimiterIndex);
                // 문자열에서 커스텀 구분자 부분 제거
                userInput = userInput.substring(delimiterIndex + 1);
            }
        }

        // 4. 쉼표 또는 콜론을 구분자로 숫자 분리
        String[] numbers = userInput.split(delimiter);

        // 5. 분리된 숫자들을 더하기
        for (String number : numbers) {
            result += Integer.parseInt(number.trim());
        }

        System.out.println("결과 : " + result);
    }
}
