package calculator;

public class Calculator {

    private String delimiter = ",|:";

    public int add(String input){
        int sum = 0;

        if(input.isEmpty()){
            return sum;
        }
        boolean isNewDelimiter = checkNewDelimiter(input);

        String[] numbers;
        if(isNewDelimiter){
            delimiter = Character.toString(input.charAt(2));
            input = input.substring(5);
            numbers = input.split(delimiter);
        }else{
            numbers = input.split(delimiter);
        }


        for(String number : numbers){
            sum += Integer.parseInt(number);
        }
        return sum;
    }

    private boolean checkNewDelimiter(String input){
        return input.startsWith("//");
    }
}
