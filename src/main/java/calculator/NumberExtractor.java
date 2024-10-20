package calculator;

import java.util.ArrayList;

public class NumberExtractor {
    private final ArrayList<Integer> numArr;
    private final DelimiterParser delimiterParser;

    public NumberExtractor(DelimiterParser delimiterParser) {
        this.delimiterParser = delimiterParser;
        numArr = new ArrayList<>();
    }

    public ArrayList<Integer> extractNumbers(String input) {
        // 숫자 추출 및 구분자 처리
        StringBuilder curNum = new StringBuilder();
        int letterIndex = delimiterParser.getParseIndex();

        while (letterIndex < input.length()) {
            char currentChar = input.charAt(letterIndex);

            if (isDigit(currentChar)) {
                appendDigit(curNum, currentChar);
            } else if (isDelimiter(currentChar)) {
                addNumberIfPresent(curNum);
            } else {
                throw new IllegalArgumentException("잘못된 구분자가 포함되었습니다: " + currentChar);
            }
            letterIndex++;
        }

        addNumberIfPresent(curNum);  // 마지막 숫자 처리
        return numArr;
    }

    // 숫자인지 확인하는 메서드
    private boolean isDigit(char character) {
        return Character.isDigit(character);
    }

    // 구분자인지 확인하는 메서드
    private boolean isDelimiter(char character) {
        String currentDelimiter = String.valueOf(character);
        return delimiterParser.getDelimiters().contains(currentDelimiter);
    }

    // 숫자를 덧붙이는 메서드
    private void appendDigit(StringBuilder curNum, char currentChar) {
        curNum.append(currentChar);
    }

    // 숫자를 추가하고 초기화하는 메서드
    private void addNumberIfPresent(StringBuilder curNum) {
        if (curNum.length() > 0) {
            numArr.add(Integer.parseInt(curNum.toString()));
            curNum.setLength(0);  // 숫자 초기화
        }
    }

    public ArrayList<Integer> getNumbers() {
        return numArr;
    }
}
