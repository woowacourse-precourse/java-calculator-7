package calculator.number;

import java.util.List;

public class Number {

    private String userInput;

    private final List<String> stringList;

    public Number(String userInput) {
        this.userInput = userInput;
        stringList = Division.getStringList(userInput);
    }

    public int getResult() {
        //기능구현
        return 0;
    }

}
