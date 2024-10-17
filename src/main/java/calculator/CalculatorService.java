package calculator;

import camp.nextstep.edu.missionutils.Console;

public class CalculatorService {
    private final String startString = "덧셈할 문자열을 입력해 주세요.";
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

    public String transSeperator() {
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
        transedString = transSeperator();
        numList = getNumList();
        result = calculateList();
    }
}
