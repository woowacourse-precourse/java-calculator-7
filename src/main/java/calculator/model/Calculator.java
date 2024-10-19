package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private final String inputString;
    private final String splitString = "[:,]";

    public Calculator(String inputString){
        this.inputString = inputString;
    }

    public List<String> splitList(){
        String[] splitedStringArray = inputString.split(splitString);
        List<String> stringList = List.of(splitedStringArray);

        return stringList;
    }

    public List<Integer> parseIntegerList(List<String> stringList){
        List<Integer> integerList = new ArrayList<>();

        for(String str : stringList){
            int strToInteger = Integer.parseInt(str);
            integerList.add(strToInteger);
        }

        return integerList;
    }

    public int addNumber(List<Integer> integerList){
        int sum = 0;

        for(int number : integerList){
            sum += number;
        }

        return sum;
    }
}
