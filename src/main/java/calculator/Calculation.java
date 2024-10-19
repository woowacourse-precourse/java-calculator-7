package calculator;

public class Calculation {
    public static int getCalculationResult(String input){
        if(input.isEmpty()){
            return 0;
        }else{
            return stringCalculation(input);
        }
    }

    public static int stringCalculation(String input){
        int sum = 0;
        for(char c : input.toCharArray()){
            if(Character.isDigit(c)){
                sum += Integer.parseInt(Character.toString(c));
            }
        }
        return sum;
    }
}
