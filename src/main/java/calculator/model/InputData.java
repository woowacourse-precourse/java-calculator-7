package calculator.model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputData {
    private final String input;

    public InputData(String input) {
        this.input = input;
    }

    public void validate(String input){
        Pattern pattern = Pattern.compile(".*[0-9]$");
        Matcher matcher = pattern.matcher(input);

        if(!matcher.matches()){
            throw new IllegalArgumentException();
        }
    }
}
