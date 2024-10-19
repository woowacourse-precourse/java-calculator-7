package calculator;

public class Calculator {
    private static final String COMMA = ",";
    private static final String COLON = ":";

    public int calcString(String input){
        if(input.isEmpty()){
            return 0;
        }

        if(input.startsWith("//")){
            return 0;
        }else {
            return calcWithDefault(input);
        }
    }

    private int calcWithDefault(String input){
        String[] numbers = input.split(COMMA + "|" + COLON);
        return calcSum(numbers);
    }

    private int calcSum(String[] numbers){
        int result = 0;

        for(String num : numbers){
            result += Integer.parseInt(num);
        }

        return result;
    }
}
