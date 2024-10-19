package calculator.model;

import java.util.ArrayList;
import java.util.List;

public class Calculator {

    private final String inputString;
    private final String splitString = "[:,]";
    private final Character userDefinedChar = '/';
    private final int zeroNumber = 0;
    private final int indexOfOne = 1;
    private final int indexOfTwo = 2;
    private final int indexOfThree = 3;
    private final int beginningIndex = 4;

    public Calculator(String inputString){
        this.inputString = inputString;
    }

    public List<String> splitList(String selectedSplitString){
        if(userDefined()){
            String stringList = inputString.substring(beginningIndex);
            stringList.split(selectedSplitString);

            return List.of(stringList);
        }

        String[] stringArray = inputString.split(selectedSplitString);
        List<String> stringList = List.of(stringArray);

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
        int sum = zeroNumber;

        for(int number : integerList){
            sum += number;
        }

        return sum;
    }

    public String selectSplitString(){
        if(userDefined()){
            String userDefineString = inputString.substring(indexOfTwo, indexOfThree);
            return userDefineString;
        }

        return splitString;
    }

    private boolean userDefined(){
        if(inputString.charAt(indexOfOne) == userDefinedChar){
            return true;
        }

        return false;
    }

}
