package calculator.domain;

import java.util.List;

public class AddCalculation {

    private final List<Integer> numberList;

    public AddCalculation(String userInput) {
        numberList = Division.createNumberList(userInput);
    }

    public int calculation() {
        return ResultMaker.sum(numberList);
    }

}
