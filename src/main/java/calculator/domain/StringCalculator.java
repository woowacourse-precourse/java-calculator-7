package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    private List<Integer> numbers = new ArrayList<>();
    private final String[] delimeter = new String[]{",", ":"};

    public StringCalculator(String input) {
        this.numbers = split(input);
    }

    public int calculate() {
        int result = 0;
        return result;
    }

    public List<Integer> split(String input){
        List<Integer> numberList = new ArrayList<>();

        return numberList;
    }
}
