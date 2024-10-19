package calculator.Model;

import calculator.Interface.Calculator;

public class CalculatorModel implements Calculator {

    @Override
    public String calculateSum(String[] tokens){


        String sum = "0";
        for(String token : tokens){
            if(token == null || token.isEmpty()){
                continue;
            }
            sum = addStrings(sum, token);
        }
        return sum;
    }

    private String addStrings(String num1, String num2){
        StringBuilder result = new StringBuilder();

        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        while(i >= 0 || j >= 0 || carry > 0){

            int digit1 = ( i >= 0 ) ? num1.charAt(i) - '0' : 0;
            int digit2 = ( j >= 0 ) ? num2.charAt(j) - '0' : 0;

            int sum = digit1 + digit2 + carry;

            carry = sum/10;
            result.append(sum % 10);

            i--;
            j--;
        }

        return result.reverse().toString();
    }

}
