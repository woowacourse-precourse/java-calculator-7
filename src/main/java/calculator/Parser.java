package calculator;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    public List<Integer>parseNumber(String input){
        List<Integer>numbers = new ArrayList<>();
        StringBuilder currentNumber = new StringBuilder();
        for(char ch : input.toCharArray()){
            if(Character.isDigit(ch)){
                currentNumber.append(ch);
            }
            else{
                if(!currentNumber.isEmpty()){
                    numbers.add(Integer.parseInt(currentNumber.toString()));
                    currentNumber.setLength(0);
                }
            }
        }
        if(!currentNumber.isEmpty()){
            numbers.add(Integer.parseInt(currentNumber.toString()));
        }

        return numbers;
    }



}
