package calculator.model;

import java.util.ArrayList;
import java.util.List;

//숫자 리스트에 대한 클래스
public class PositiveNumbers implements Numbers {

    private List<Integer> numbers = new ArrayList<>();


    @Override
    public List<Integer> getNumbers() {
        return numbers;
    }

    @Override
    public void addNumber(int number) {

        checkPositive(number);
        numbers.add(number);
    }

    private void checkPositive(int number) {

        if (number <= 0) {
            throw new IllegalArgumentException("양수만 입력이 가능합니다");
        }

    }


}
