package calculator;

import java.util.Arrays;
import java.util.List;

public class Calculator {
    private String[] splitNumbers;
    private int sum;

    public int getSum(String parsedUserInput, List<Character> delimiter){
        makeSplitNumbers(parsedUserInput, delimiter);
//        for(String number : splitNumbers){
//            sum += Integer.parseInt(number);
//        }

        return sum;
    }

    private void makeSplitNumbers(String parsedUserInput, List<Character> delimiter){
        StringBuilder sb = new StringBuilder();
        this.sum = 0;

        for(int i=0;i<parsedUserInput.length();i++){
            if(!delimiter.contains(parsedUserInput.charAt(i))){
                sb.append(parsedUserInput.charAt(i));
            }else{
                if(sb.length()==0) continue;
                sum += Integer.parseInt(sb.toString());
                sb.delete(0, sb.length());
            }
        }
    }
}
