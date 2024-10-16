package calculator;

import java.util.ArrayList;
import java.util.List;

public class InputParser {

    public void getCustomParser(InputString inputString) {
        String separator = null;
        String input = inputString.getInput();
        if (input.startsWith("//")) {
            int indexOfNewline = input.indexOf("\n");
            separator = input.substring(2, indexOfNewline);
        }
        inputString.setSeparator(separator);
    }

    public void getIntegerList(InputString inputString){
        String input = inputString.getInput();
        if (input.startsWith("//")) {
            input = input.substring(2);
        }
        String[] parsedOperand = input.split(inputString.getSeparator());
        for(int i=0;i<parsedOperand.length;i++){
            inputString.addOperand((Integer.parseInt(parsedOperand[i])));
        }
    }

}
