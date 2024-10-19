package calculator.service;

import calculator.validation.CheckForm;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static calculator.data.keywords.DOUBLE_SLASH;

public class InputParser implements Parser {

    public Character getCustomParser(String input) {
        Character separator = null;
        if (input.startsWith(DOUBLE_SLASH.getKeyword())) {
            separator = input.charAt(2);
        }
        return separator;
    }

    public List<Integer> getIntegerList(String input, Set<Character> separators){
        if (input.startsWith(DOUBLE_SLASH.getKeyword())) {
            input = input.substring(5);
        }

        List<String> parsedOperand = new ArrayList<>();
        for (char character : input.toCharArray()) {
            if(separators.contains(character)) {
                String operand = input.substring(0, input.indexOf(character));
                parsedOperand.add(operand);
                input = input.substring(input.indexOf(character) + 1);
            }
        }
        parsedOperand.add(input);

        return typeCastingStringListToIntegerList(parsedOperand);
    }

    private List<Integer> typeCastingStringListToIntegerList(List<String> parsedOperand){
        List<Integer> integerList = new ArrayList<>();

        try{
            for(String s : parsedOperand){
                integerList.add(Integer.parseInt(s));
            }
        }catch (NumberFormatException e){
            CheckForm.throwException();
        }
        return integerList;
    }
}
