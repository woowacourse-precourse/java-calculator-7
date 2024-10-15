package calculator.model.inputValue;

import java.util.ArrayList;

public class InputValue {
    ArrayList<Integer> positiveIntegers;
    String delimiter = ",|:";
    String customDelimiter;

    String uncheckedInput;

    public InputValue(String inputValue){
        uncheckedInput = inputValue;
        checkCustomSeparator();
        extractNumber();

//        System.out.println(positiveIntegers.toString());
    }

    private void checkCustomSeparator(){
        if (uncheckedInput.startsWith("//")){
            int indexOfDelimiter = uncheckedInput.indexOf("\n");
            if (indexOfDelimiter == -1) {
                throw new IllegalArgumentException("Wrong format");
            }
            customDelimiter = uncheckedInput.substring(2,indexOfDelimiter);
            delimiter = delimiter.concat("|").concat(customDelimiter);
            uncheckedInput = uncheckedInput.substring(indexOfDelimiter+1);
        }

        System.out.println("customSeparator is " + customDelimiter);
        System.out.println("All delimiter is = " + delimiter);
    }

    private void extractNumber(){
        positiveIntegers = new ArrayList<>();
        String[] numbers = uncheckedInput.split(delimiter);

        for(String number : numbers) {
            if (Integer.parseInt(number) < 0) {
                throw new IllegalArgumentException("The number is negative");
            }
        }


    }


}
