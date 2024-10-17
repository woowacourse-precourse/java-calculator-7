package calculator;



public class Calculator {

    public int add(String input) throws IllegalArgumentException{ // 런타임 예외는 따로 선언하지 않아도 되지만 명시적으로 예외 발생 가능성 명시
        int sum = 0;

        if(input.isEmpty()){
            return sum;
        }
        boolean CustomDelimiter = InputUtils.isCustomDelimiter(input);

        String[] stringNumbers;

        if(CustomDelimiter){
            String customDelimiter = InputUtils.extractDelimiter(input);
            input = InputUtils.extractNumbers(input);
            stringNumbers = input.split(customDelimiter);
        }else{
            stringNumbers = InputUtils.splitInputs(input, InputUtils.DEFAULT_DELIMITER);
        }

        int[] numbers = InputUtils.StringToNumber(stringNumbers);

        for(int number : numbers){
            sum += number;
        }

        return sum;
    }





}
