package calculator.parser;

import calculator.validation.Validator;

import java.util.ArrayList;
import java.util.List;

import static calculator.validation.Validator.validationNegative;
import static calculator.validation.Validator.validationSeparator;

public class StringParser {

    String getSeparator(String input) {
        String separator = "";

        if(input.startsWith("//")){
            int index = input.indexOf("\\n");
            separator += input.substring(2, index);
            validationSeparator(separator);
        }

        separator += "|,|:";

        return separator;
    }


    public int extractionNumber(String input){
        List<Integer> numbers = new ArrayList<>();
        String[] strings = input.split(getSeparator(input));

        for(String s : strings){
            StringBuilder num = new StringBuilder();

            for(int i = 0; i < s.length(); i++){
                if(Character.isDigit(s.charAt(i))){
                    num.append(s.charAt(i));
                }
            }

            if(!num.isEmpty()){
                numbers.add(Integer.parseInt(String.valueOf(num)));
            }
        }

        validationNegative(numbers);

        return numbers.stream()
                .mapToInt(Integer::intValue)
                .sum();
    }

}
