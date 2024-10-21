package calculator;



public class Calculator {

    public int add(String input) throws IllegalArgumentException{
        int sum = 0;

        if(input.isEmpty()){
            return sum;
        }
        boolean CustomDelimiter = Input.isCustomDelimiter(input);

        String[] stringNumbers;

        if(CustomDelimiter){
            String customDelimiter = Input.extractDelimiter(input);
            input = Input.extractNumbers(input);
            stringNumbers = input.split(customDelimiter);
        }else{
            stringNumbers = Input.splitInputs(input, Input.DEFAULT_DELIMITER);
        }

        int[] numbers = Input.StringToNumber(stringNumbers);

        for(int number : numbers){
            sum += number;
        }

        return sum;
    }





}