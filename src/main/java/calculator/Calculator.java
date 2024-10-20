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

}
