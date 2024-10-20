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
        String result = "";
        int sum = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (Character.isDigit(c)) {
                result += input.charAt(i);
                if (i != input.length() - 1 && Character.isDigit(input.charAt(i + 1))) {
                    result += input.charAt(i + 1);
                    i++;
                    if(i != input.length() - 1){
                        continue;
                    }
                }
                sum += Integer.parseInt(result);
                result = "";
            }else{
                if(result.isEmpty()){
                    result = "0";
                }
                sum += Integer.parseInt(result);
                result = "";
            }
        }
        return sum;
    }
}
