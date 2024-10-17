package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorService {
    private final String startString = "덧셈할 문자열을 입력해 주세요.";
    private final Pattern pattern = Pattern.compile("//(\\D)+\\\\n");
    private String inputString;
    private String transedString;
    private final String endString = "결과 : ";
    private int result;
    private String[] numList;
    public void printStartString(){
        System.out.println(startString);
    }

    public String setInputString(){
        inputString = Console.readLine();
        return inputString;
    }

    public String transCustomSeperator(Matcher matcher){
        String customMatcher = matcher.group();
        String customSeperator = customMatcher.substring(2, customMatcher.length()-2);
        String expression = inputString.substring(customMatcher.length(), inputString.length());
        transedString = expression.replaceAll(customSeperator,",").replaceAll(":", ",");
        return transedString;
    }

    public String transBasicSeperator() {
        transedString = inputString.replaceAll(":",",");
        return transedString;
    }

    public String[] getNumList(){
        return transedString.split(",");
    }

    public int calculateList() {
        for (String i : numList) {
            result += Integer.parseInt(i);
        }
        return result;
    }

    public void printResult(){
        System.out.println(endString+result);
        Console.close();
    }

    public void calculate(String inputString){
        Matcher matcher = pattern.matcher(inputString);
        if(matcher.find()){
            transedString = transCustomSeperator(matcher);
        }else{
            transedString = transBasicSeperator();
        }
        numList = getNumList();
        result = calculateList();
    }
}
