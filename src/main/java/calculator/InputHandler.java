package calculator;

import camp.nextstep.edu.missionutils.Console;

public class InputHandler {
    public String calculateSumFromInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        validateInput(input);
        return input;
    }

    public void validateInput(String input) {
        if (input.startsWith("//") && input.contains("\\n")) {
            // 1. 커스텀 구분자 추출
            int delimiterEndIndex = input.indexOf("\\n");
            String customDelimiter = input.substring(2, delimiterEndIndex);  // 커스텀 구분자 추출
            String numbers = input.substring(delimiterEndIndex + 2);  // 숫자 부분 추출

            // 2. 커스텀 구분자와 기본 구분자 콤마(,)와 콜론(:)을 모두 허용
            String validDelimitersPattern = "[0-9" + customDelimiter + ",:]+";

            // 3. 잘못된 구분자가 포함된 경우 예외 발생
            if (!numbers.matches(validDelimitersPattern)) {
                throw new IllegalArgumentException("잘못된 구분자가 포함되어 있습니다: " + numbers);
            }
        } else {
            // 커스텀 구분자가 없을 경우 기존 로직 (콤마와 콜론만 허용)
            if (!input.matches("[0-9,:]+")) {
                throw new IllegalArgumentException("잘못된 구분자가 포함되어 있습니다: " + input);
            }
        }
    }
}
