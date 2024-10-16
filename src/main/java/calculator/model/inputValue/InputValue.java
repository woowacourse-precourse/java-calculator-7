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
    }

    private void checkCustomSeparator(){
        if (uncheckedInput.startsWith("//")){
            int indexOfDelimiter = uncheckedInput.indexOf("n");
            if (indexOfDelimiter == -1) {
                throw new IllegalArgumentException("Wrong format");
            }
            customDelimiter = uncheckedInput.substring(2,indexOfDelimiter-1);
            delimiter = delimiter.concat("|").concat(customDelimiter);
            uncheckedInput = uncheckedInput.substring(indexOfDelimiter+1);
        }
    }

    private void extractNumber(){
        positiveIntegers = new ArrayList<>();
        String[] numbers = uncheckedInput.split(delimiter);

        for(String number : numbers) {
            if (Integer.parseInt(number) < 0) {
                throw new IllegalArgumentException("The number is negative");
            }
        }

        try{
            for(String number : numbers) {
                positiveIntegers.add(Integer.parseInt(number));
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("There is Wrong Delimiter");
        }
    }

    public String calculateSum() {
        int sum = 0;
        for (int number : positiveIntegers){
            sum += number;
        }
        return Integer.toString(sum);
    }
}
