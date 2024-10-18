package calculator.tokenizer;

import java.util.ArrayList;
import java.util.List;

public class PrefixBasedSplitter {

    private static final List<Character> DEFAULT_DELIMITERS = List.of(',', ':');

    public List<String> split(String inputString) {
        CustomizedString customizedString = new CustomizedString(inputString);
        List<Character> delimiters = getDelimiters(customizedString);
        StringTokenizer stringTokenizer = new StringTokenizer(customizedString.getOnlyString(), delimiters);
        return stringTokenizer.getTokens();
    }

    private List<Character> getDelimiters(CustomizedString customizedString) {
        if (!customizedString.hasCustomDelimiter()) {
            return DEFAULT_DELIMITERS;
        }
        Character customDelimiter = customizedString.getCustomDelimiter();
        if (isAlreadyInvolved(customDelimiter)) {
            return DEFAULT_DELIMITERS;
        }
        ArrayList<Character> delimitersWithCustom = new ArrayList<>(DEFAULT_DELIMITERS);
        delimitersWithCustom.add(customDelimiter);
        return delimitersWithCustom;
    }

    private boolean isAlreadyInvolved(Character customDelimiter) {
        return DEFAULT_DELIMITERS.contains(customDelimiter);
    }

}
