package calculator.service.domain;

import java.util.ArrayList;
import java.util.List;

public class NumberHandler {
    private final List<Number> numberList;

    public NumberHandler() {
        numberList = new ArrayList<>();
    }

    public void addNumber(Double number) {
        numberList.add(new Number(number));
    }

    public String calculatePlus() {
        Number answer = new Number(0);
        for(Number each : numberList){
            answer = answer.add(each);
        }

        return answer.toString();
    }
}
