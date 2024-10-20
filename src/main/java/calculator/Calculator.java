package calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Calculator {

    private int result;

    public Calculator(String input){
        parseInput(input); // 숫자 추출 및 합산을 메서드 호출
    }


    private void parseInput(String input){

        List<String> delimiters = new ArrayList<>();
        String basicDelimiter = ",|;"; // 기본 구분자 2가지
        String onlyNumbers = input; // 숫자 구분

        int customDelimiterStart = input.indexOf("//");
        int customDlimiterEnd = input.indexOf("\n");

        if (customDelimiterStart != -1 && customDlimiterEnd != -1 && customDlimiterEnd > customDelimiterStart){
            basicDelimiter = input.substring(customDelimiterStart + 2, customDlimiterEnd);
            onlyNumbers = input.substring(customDlimiterEnd+1);
        }

        splitAndSum(basicDelimiter, onlyNumbers);
    }

    private void splitAndSum(String basicDelimiter, String onlyNumbers){
        String[] splitNumbers = onlyNumbers.split(Pattern.quote(basicDelimiter));

        for (String num : splitNumbers){
            if (!num.isEmpty()){
                result += Integer.parseInt(num);
            }
        }
    }


    public int getresult() {
        return result;
    }

}
