package calculator.model;

import java.util.ArrayList;
import java.util.List;

//숫자 리스트에 대한 클래스
public class PositiveNumbers {

    private List<Integer> numbers = new ArrayList<>();


    public List<Integer> getNumbers() {
        return numbers;
    }

    public void addNumber(int number) {

        checkPositive(number);
        numbers.add(number);
    }

    private void checkPositive(int number) {

        if (number <= 0) {
            throw new IllegalArgumentException();
        }

    }


}
