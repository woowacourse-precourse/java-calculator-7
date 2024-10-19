package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class Number {
    private final List<Integer> numberList;

    public Number(String[] numberArray) {
        this.numberList = new ArrayList<>();
        validateNumberArray(numberArray);
    }

    // 값을 검증하는 메서드
    private void validateNumberArray(String[] array) {
        for (String str : array) {
            if (!isNumeric(str)) {
                throw new IllegalArgumentException("기본 구분자와 커스텀 구분자 외의 문자가 입력되었습니다.");
            }

            int number = Integer.parseInt(str);
            if (number < 0) {
                throw new IllegalArgumentException("양수를 입력해주세요.");
            }
            addNumber(number);
        }
    }

    // 숫자인지 확인
    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
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
