package calculator.domain;

import java.util.List;

public class AddCalculation {

    private final List<Integer> numberList;

    public AddCalculation(String userInput) {
        List<String> stringList = Division.getStringList(userInput);
        numberList = IntegerListMaker.getNumberList(stringList);
    }

    public int calculation() {
        return ResultMaker.sum(numberList);
    }

}
