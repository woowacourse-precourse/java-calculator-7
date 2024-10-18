package calculator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputData {
    private final String input;

    public InputData(String input) {
        this.input = input;
    }

    public void validate(String input){
        Matcher endMatcher = getMatcher(".*[0-9]$");
        Matcher startMatcher = getMatcher("^[0-9](.*)");

        if(!endMatcher.matches()){
            throw new IllegalArgumentException("[ERROR][F0001] 마지막 입력값은 숫자여야 합니다.");
        }

        if(!isDelimiter() && !startMatcher.matches()){
            throw new IllegalArgumentException("[ERROR][F0002] 커스텀 구분자가 없는 경우 시작 입력값은 숫자여야 합니다.");
        }
    }

    public boolean isDelimiter(){
        Matcher delimiterMatcher = getMatcher("^//(.*)\\\\n(.*)");

        return delimiterMatcher.matches();
    }

    public String convertDelimiterPart(){
        Matcher delimiterMatcher = getMatcher("^//(.*)\\\\n(.*)");
        String delimiter = "";

        if(delimiterMatcher.matches()){
            delimiter = delimiterMatcher.group(1);
        }
        return delimiter;
    }

    public String convertCalculatorPart() {
        Matcher calculatorMatcher = getMatcher("^//(.*)\\\\n(.*)");
        String calculator = "";

        if(calculatorMatcher.matches()){
            calculator = calculatorMatcher.group(2);
        }
        return calculator;
    }

    private Matcher getMatcher(String regex){
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(input);
    }
}
