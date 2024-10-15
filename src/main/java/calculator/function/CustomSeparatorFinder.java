package calculator.function;

import java.util.Optional;

public class CustomSeparatorFinder {
    private String inputString;

    public CustomSeparatorFinder(String inputString) {
        this.inputString = inputString;
    }

    public Optional<Character> execute(){
        if(inputString.length() < 5) return Optional.empty();
        if(inputString.charAt(0) != '/') return Optional.empty();
        if(inputString.charAt(1) != '/') return Optional.empty();
        if(inputString.charAt(3) != '\\') return Optional.empty();
        if(inputString.charAt(4) != 'n') return Optional.empty();
        return Optional.of(inputString.charAt(2));
    }
}
