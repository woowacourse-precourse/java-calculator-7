package calculator.domain;

import java.util.ArrayList;
import java.util.List;

public class NumberStorage {
    private final List<Double> numberList = new ArrayList<Double>();

    public void addNumber(String num, Delimiter delimiter){
        InputParser.checkAllowedDelimiters(num, delimiter);
        checkDecimalNumber(num);
        numberList.add(Double.valueOf(num));
    }

    private void checkDecimalNumber(String num){
        if(num.charAt(0) == '.' || num.charAt(num.length()-1) == '.'){
            throw new IllegalArgumentException();
        }
    }
}
