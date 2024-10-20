package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static final String DEFAULT_DELIMITER = "[,:]";
    public static final String LEFT_CUSTOM_DELIMITER = "//";
    public static final String RIGHT_CUSTOM_DELIMITER = "\\n";
    public static final String ILLEGAL_EXCEPTION_MESSAGE = "잘못된 값입니다.";
    public static void main(String[] args) {
        Application app = new Application();
        String input = app.userInputManager();
        int result = app.inputSeparator(input);
        app.outputManager(result);
    }
    public String userInputManager() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }
    public void outputManager(int result) {
        System.out.println("결과 : " + result);
    }
    public int inputSeparator(String userInput) {
        if (userInput == null || userInput.trim().isEmpty()) {
            return 0;
        }
        String numbers = userInput.trim();
        // 커스텀 구분자 존재 확인 및 처리
        if (numbers.startsWith(LEFT_CUSTOM_DELIMITER)) {
            int newLineIndex = numbers.indexOf(RIGHT_CUSTOM_DELIMITER);
            if (newLineIndex == -1) {
                throw new IllegalArgumentException(ILLEGAL_EXCEPTION_MESSAGE);
            }
            String customDelimiter = numbers.substring(2, newLineIndex);
            String[] delimiters = customDelimiter.split("");
            numbers = numbers.substring(newLineIndex + 2);
            // 구분자 반복문 이용해서 ","로 대체
            for (String delim : delimiters) {
                numbers = numbers.replace(delim, ",");
            }
        }
        // 쉼표(",") 또는 콜론(":")을 기준으로 문자열 나눔
        String[] nums = numbers.split(DEFAULT_DELIMITER);
        return parseAndCalculate(nums);
    }
    public int parseAndCalculate(String[] nums) {
        int sum = 0;
        // 각 문자열 숫자로 변환 후 합산
        for (String num : nums) {
            num = num.trim();
            int value;
            try {
                value = Integer.parseInt(num);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(ILLEGAL_EXCEPTION_MESSAGE);
            }
            if (value <= 0) {
                throw new IllegalArgumentException(ILLEGAL_EXCEPTION_MESSAGE);
            }
            sum += value;
        }
        return sum;
    }
}