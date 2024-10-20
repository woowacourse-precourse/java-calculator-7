package calculator.function;

import calculator.dto.CSFResult;

import java.util.Optional;

public class CustomSeparatorFinder {
    private String inputString;

    public CustomSeparatorFinder(String inputString) {
        this.inputString = inputString;
    }

    public CSFResult execute(){
        if(inputString.length() < 5) return new CSFResult(Optional.empty(), inputString);
        if(inputString.charAt(0) != '/') return new CSFResult(Optional.empty(), inputString);
        if(inputString.charAt(1) != '/') return new CSFResult(Optional.empty(), inputString);
        if(inputString.charAt(3) != '\\') return new CSFResult(Optional.empty(), inputString);
        if(inputString.charAt(4) != 'n') return new CSFResult(Optional.empty(), inputString);
        return new CSFResult(Optional.of(inputString.charAt(2)), inputString.substring(5));
    }
}
