package calculator.number;

import java.util.List;

public class Number {

    private String userInput;

    private final List<Integer> numberList;

    public Number(String userInput) {
        this.userInput = userInput;
        List<String> stringList = Division.getStringList(userInput);
        numberList = IntegerListMaker.getNumberList(stringList);
    }

    public int getResult() {
        return ResultMaker.getResult(numberList);
    }

}
