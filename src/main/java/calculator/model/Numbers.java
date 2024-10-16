package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private List<String> numbers;

    public Numbers() {
        this.numbers = new ArrayList<>();
    }


    public List<String> getNumbers() {
        return numbers;
    }

    public void addNumber(String number){
        numbers.add(number);
    }
}
