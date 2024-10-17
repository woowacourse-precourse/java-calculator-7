package calculator;

import java.util.ArrayList;
import java.util.List;

public class NumberParser {

    public List<Integer> parseNumbers(String numbers, String delimiters){
        String[] tokens = numbers.split("[" + delimiters + "]");
        List<Integer> numberList = new ArrayList<>();

        for(String token : tokens){
            if(!token.isEmpty()){
                int number = Validator.validate(token);
                numberList.add(number);
            }
        }
        return numberList;
    }
}
