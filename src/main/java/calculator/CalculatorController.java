package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorController {
    private final String startString = "덧셈할 문자열을 입력해 주세요.";
    private int result = 0;
    private final String endString = "결과 : ";
    public void run(){
        System.out.println(startString);
        String inputString = Console.readLine();
        String[] numList;
        inputString = inputString.replaceAll(":",",");
        numList = inputString.split(",");
        for(String i : numList){
            result += Integer.parseInt(i);
        }
        System.out.println(endString+result);
        Console.close();
    }
}
