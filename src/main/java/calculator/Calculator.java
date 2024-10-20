package calculator;

import java.util.regex.Pattern;

public class Calculator {
    private String userInput;
    private String delimiter;
    private static final Pattern defaultPattern = Pattern.compile("([1-9][0-9]*([,:][1-9][0-9]*)*)?");
    private static final Pattern customPattern = Pattern.compile("//(.)\\\\n([1-9][0-9]*(\\1[1-9][0-9]*)*)?");

    public void readUserInput(){
        userInput = camp.nextstep.edu.missionutils.Console.readLine();
    }

    public void detectDelimiter() throws IllegalArgumentException{
        boolean isDefaultDelimiter = defaultPattern.matcher(userInput).matches();
        boolean isCustomDelimiter = customPattern.matcher(userInput).matches();
        if(isDefaultDelimiter)
            delimiter = "[,|:]";
        else if(isCustomDelimiter)
            delimiter = ""+userInput.charAt(2);
        else
            throw new IllegalArgumentException("ERROR: invalid input");
    }

    public int sumUserInput(){
        int result = 0;
        String numberWithDelimiter = userInput.replaceAll("//.\\\\n", "");
        for(String number : numberWithDelimiter.split(delimiter))
            result += Integer.parseInt(number);
        return result;
    }

    public void runCalculator(){
        try{
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            this.readUserInput();
            this.detectDelimiter();
            int result = this.sumUserInput();
            System.out.println("결과 : " + result);
        }
        catch(IllegalArgumentException e){

        }
    }
}
