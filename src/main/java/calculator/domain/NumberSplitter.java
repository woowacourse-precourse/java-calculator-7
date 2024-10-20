package calculator.domain;

import java.util.List;
import java.util.Set;

public class NumberSplitter {

    public List<String> split(String numberPart, Set<Character> delimiters) {
        String replaceNumberPart = replaceDelimiters(numberPart, delimiters);

        return List.of(replaceNumberPart.split(" "));
    }

    private String replaceDelimiters(String numberPart, Set<Character> delimiters) {
        for (char delimiter : delimiters) {
            numberPart = numberPart.replace(delimiter, ' ');
        }
        return numberPart;
    }
}
