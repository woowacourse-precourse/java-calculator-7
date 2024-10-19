package calculator.model;

import java.util.List;

public class Calculator {

    private final String inputString;
    private final String splitString = "[:,]";

    public Calculator(String inputString){
        this.inputString = inputString;
    }

    public List<String> splitList(){
        String[] splitedStringArray = inputString.split(splitString);
        List<String> splitedList = List.of(splitedStringArray);

        return splitedList;
    }
}
