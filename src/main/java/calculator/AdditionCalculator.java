package calculator;

import static calculator.constant.DelimiterConst.DEFAULT_DELIMITER_COLON;
import static calculator.constant.DelimiterConst.DEFAULT_DELIMITER_COMMA;
import static calculator.util.CalculatorUtil.printAdditionCalculatorStartGuideMessage;
import static calculator.util.CalculatorUtil.printOutputGuideMessage;

import calculator.util.UserUtil;
import java.util.ArrayList;
import java.util.List;

public class AdditionCalculator {
    private UserUtil userUtil;
    private List<Character> additionDelimiters = new ArrayList<>();
    private List<Integer> additionNumbers = new ArrayList<>();
    private String inputString;

    public AdditionCalculator() {
        // 덧셈용 계산기에 기본 구분자를 등록한다.
        this.inputString = null;
        this.userUtil = new UserUtil();
        additionDelimiters.add(DEFAULT_DELIMITER_COMMA);
        additionDelimiters.add(DEFAULT_DELIMITER_COLON);
    }

    public void runAdditionCalculator() {
        printAdditionCalculatorStartGuideMessage();
        inputString = userUtil.inputString();
        parseInput();
        printOutputGuideMessage(addNumbers());
    }

    private void parseInput() {
        int index = 0;
        while (index < inputString.length()) {
            char currentChar = inputString.charAt(index);

            // Custom delimiter 설정
            if (currentChar == '/' && index + 1 < inputString.length() && inputString.charAt(index + 1) == '/') {
                if (index + 4 < inputString.length() && inputString.substring(index + 3, index + 5).equals("\\n")) {
                    additionDelimiters.add(inputString.charAt(index + 2));
                    index += 5;
                    continue;
                }
            }

            if (isDelimiter(currentChar)) {
                index++;
            } else if (Character.isDigit(currentChar) || currentChar == '-') {
                StringBuilder number = new StringBuilder();
                while (index < inputString.length() && !isDelimiter(inputString.charAt(index))) {
                    number.append(inputString.charAt(index++));
                }
                int num = Integer.parseInt(number.toString());
                if (num < 0) {
                    throw new IllegalArgumentException("잘못된 입력입니다.");
                }
                additionNumbers.add(num);
            } else {
                index++;
            }
        }
    }

    // 등록된 구분자인가요?
    private boolean isDelimiter(char character) {
        return additionDelimiters.contains(character);
    }

    // 배열에 있는 모든 값들의 합을 구한다
    public int addNumbers() {
        int result = 0;
        for (int number : additionNumbers) {
            result += number;
        }
        return result;
    }
}
