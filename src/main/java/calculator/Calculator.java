package calculator;

public class Calculator {
    private static final String COMMA = ",";
    private static final String COLON = ":";

    public int calcString(String input){
        if(input.isEmpty()){
            return 0;
        }

        String[] numbers = input.split(COMMA + "|" + COLON);
        int result = 0;

        for(String num : numbers){
            result += Integer.parseInt(num);
        }

        return result;
    }
}
