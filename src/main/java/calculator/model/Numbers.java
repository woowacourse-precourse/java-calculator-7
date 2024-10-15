package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class Numbers {
    private List<String> numbers;

    public Numbers() {
        this.numbers = new ArrayList<>();
    }

    public void addNumbers(String number){
        numbers.add(number);
    }
}
