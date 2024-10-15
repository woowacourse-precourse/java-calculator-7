package calculator.model.inputValue;

import java.util.ArrayList;

public class InputValue {
    ArrayList<Integer> positiveIntegers;
    String delimiter = ",|:";
    String customDelimiter;

    public InputValue(String inputValue){
        checkCustomSeparator(inputValue);
    }

    private void checkCustomSeparator(String uncheckedInput){
        if (uncheckedInput.startsWith("//")){
            int indexofDelimiter = uncheckedInput.indexOf("\n");
            customDelimiter = uncheckedInput.substring(2,indexofDelimiter);
            delimiter = delimiter.concat("|").concat(customDelimiter);
        }

        System.out.println("customSeparator is " + customDelimiter);
        System.out.println("All delimiter is = " + delimiter);
    }

}
