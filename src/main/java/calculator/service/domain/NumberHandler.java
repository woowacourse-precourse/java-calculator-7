package calculator.service.domain;

import java.util.ArrayList;
import java.util.List;

public class NumberHandler {
    private final List<Number> numberList;

    public NumberHandler() {
        numberList = new ArrayList<>();
    }

    public void addNumber(Double number) {
        if (number < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
        numberList.add(new Number(number));
    }

    public String calculatePlus() {
        Number answer = new Number(0);
        for (Number each : numberList) {
            answer = answer.add(each);
        }

        return answer.toString();
    }
}
