package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Number {
    private final List<Integer> numberList;
    private static final String NOT_NUMERIC_ERROR = "기본 구분자와 커스텀 구분자 외의 문자가 입력되었습니다.";
    private static final String NOT_POSITIVE_NUMBER_ERROR = "양수를 입력해주세요.";

    public Number(String[] numberArray) {
        this.numberList = new ArrayList<>();
        validateNumberArray(numberArray);
    }

    // 값을 검증하는 메서드
    private void validateNumberArray(String[] array) {
        for (String str : array) {
            // 숫자가 아닐 경우
            if (!isNumeric(str)) {
                throw new IllegalArgumentException(NOT_NUMERIC_ERROR);
            }

            // 양수가 아닌 숫자가 입력된 경우
            int number = Integer.parseInt(str);
            if (number <= 0) {
                throw new IllegalArgumentException(NOT_POSITIVE_NUMBER_ERROR);
            }
            addNumber(number);
        }
    }

    // 숫자인지 확인하는 메서드
    private boolean isNumeric(String str) {
        return str.chars().allMatch(Character::isDigit);
    }


    // 숫자를 List에 추가하는 메서드
    public void addNumber(int num) {
        numberList.add(num);
    }

    // 결과를 반환하는 메서드
    public int getSum() {
        int sum = 0;
        for (int num : numberList) {
            sum += num;
        }

        return sum;
    }
}
