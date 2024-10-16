package calculator;

import java.util.ArrayList;
import java.util.List;

public class InputParser {

    public void getCustomParser(InputString inputString) {
        Character separator = null;
        String input = inputString.getInput();
        if (input.startsWith("//")) {
            separator = input.charAt(2);
        }
        inputString.setSeparator(separator);
    }

    public void getIntegerList(InputString inputString){
        String input = inputString.getInput();
        if (input.startsWith("//")) {
            input = input.substring(5);
        }

        List<String> parsedOperand = new ArrayList<>();
        for (char character : input.toCharArray()) {
            if(inputString.getSeparator().contains(character)) {
                String operand = input.substring(0, input.indexOf(character));
                parsedOperand.add(operand);
                input = input.substring(input.indexOf(character) + 1);
            }
        }
        parsedOperand.add(input);

        try{
            for(String s : parsedOperand){
                inputString.addOperand((Integer.parseInt(s)));
            }
        }catch (NumberFormatException e){
            CheckForm.throwException();
        }
    }
}
