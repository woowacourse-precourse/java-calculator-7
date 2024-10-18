package calculator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputData {
    private final String input;

    public InputData(String input) {
        this.input = input;
    }

    public void validate(String input){
        // TODO : 입력값으로 Delimiter 객체와 Calculator 객체를 생성하는지 검증한다.
        // TODO : 기존의 구현은 각각의 객체에서 규칙에 맞게 검증하는 코드를 작성한다.
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
