package calculator;

import static calculator.constant.CalculatorMessageConst.INPUT_ERROR_MESSAGE;
import static calculator.constant.DelimiterConst.DEFAULT_DELIMITER_COLON;
import static calculator.constant.DelimiterConst.DEFAULT_DELIMITER_COMMA;
import static calculator.util.CalculatorUtil.printAdditionCalculatorStartGuideMessage;
import static calculator.util.CalculatorUtil.printOutputGuideMessage;

import calculator.util.UserUtil;
import java.util.ArrayList;
import java.util.List;

public class AdditionCalculator {
    private final UserUtil userUtil;
    private final List<Character> additionDelimiters = new ArrayList<>();
    private final List<Integer> additionNumbers = new ArrayList<>();
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

        // 사용자가 입력한 값이 공백인지 판단
        if (inputString.isEmpty()) {
            additionNumbers.add(0);
            return;
        }

        // 순회용으로 index 사용
        int index = 0;
        while (index < inputString.length()) {
            if (isCheckLength(index+1) && isStartCustomDelimiter(index)) {
                if (isCheckLength(index + 4) && isLineFeed(index + 3, index + 5)) {
                    additionDelimiters.add(inputString.charAt(index + 2));
                    index += 5;
                    continue;
                }
            }

            char currentChar = inputString.charAt(index);
            // 등록된 구분자인 경우
            if (isDelimiter(currentChar)) {
                index++;
            } else if (Character.isDigit(currentChar) || currentChar == '-') {
                StringBuilder number = new StringBuilder();

                // 구분자가 아닐 때까지
                while (isCheckLength(index)&& !isDelimiter(inputString.charAt(index)) && !isStartCustomDelimiter(index)) {
                    number.append(inputString.charAt(index++));
                }

                int num = Integer.parseInt(number.toString());
                if (num < 0) {
                    throw new IllegalArgumentException(INPUT_ERROR_MESSAGE);
                }
                additionNumbers.add(num);
            } else {
                index++;
            }
        }
    }

    // 커스텀 구분자 등록 시작 부분을 판단한다
    private boolean isStartCustomDelimiter(int index) {
        if (inputString.charAt(index) == '/' && inputString.charAt(index + 1) == '/') {
            return true;
        } else return false;
    }

    // index 값이 입력 문자열 길이를 넘지 않는지 판단한다 (반복문에서 활용)
    private boolean isCheckLength(int index) {
        if (index < inputString.length()) {
            return true;
        } else return false;
    }

    // 개행 문자 여부를 판단한다
    private boolean isLineFeed(int firstIndex, int secondIndex) {
        if (inputString.substring(firstIndex, secondIndex).equals("\\n")) {
            return true;
        } else return false;
    }

    // 등록된 구분자인지 판단한다
    private boolean isDelimiter(char character) {
        return additionDelimiters.contains(character);
    }

    // 배열에 있는 모든 값들의 합을 구한다
    public int addNumbers() {
        return additionNumbers.stream().mapToInt(Integer::intValue).sum();
    }
}
