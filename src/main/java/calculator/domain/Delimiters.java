package calculator.domain;

import java.util.HashSet;
import java.util.Set;

public class Delimiters {

    private static final String regex = "^//[^0-9]\\\\n.*";
    private final Set<Character> delimiters;

    public Delimiters(Set<Character> initDelimiters) {
        this.delimiters = new HashSet<>(initDelimiters);
    }

    public void addDelimiter(char delimiter) {
        delimiters.add(delimiter);
    }

    public Boolean isDelimiter(char delimiter) {
        return delimiters.contains(delimiter);
    }

    public String extractCustomDelimiter(String userInput) {
        if(userInput.startsWith("/")){
            if(!userInput.matches(regex)){
                throw new IllegalArgumentException("잘못된 형식입니다.");
            }
            this.addDelimiter(userInput.charAt(2));
            return userInput.substring(5);
        }

        return userInput;
    }
}
