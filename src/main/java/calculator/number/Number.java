package calculator.number;

import java.util.List;

public class Number {

    private String userInput;

    public Number(String userInput) {
        this.userInput = userInput;
    }

    public int getResult() {
        List<Integer> numbers = NumberDivision.getNumber(userInput);
        return ResultMaker.getResult(numbers);
    }

}
