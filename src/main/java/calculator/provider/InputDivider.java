package calculator.provider;

import java.util.List;

public class InputDivider {

    private final String input;
    private final BufferedSplitter splitter;

    public InputDivider(String input, List<Character> delimiters) {
        this.input = input;
        this.splitter = new BufferedSplitter(delimiters);
    }

    public List<String> divide() {
        char[] charArray = input.toCharArray();
        for (Character character : charArray) {
            splitter.appendIfNotDelimiter(character);
        }
        return splitter.getTokens();
    }

}
