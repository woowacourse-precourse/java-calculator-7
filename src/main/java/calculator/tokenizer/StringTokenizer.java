package calculator.tokenizer;

import java.util.List;

public class StringTokenizer {

    private final String input;
    private final BufferedSplitter splitter;

    public StringTokenizer(String input, List<Character> delimiters) {
        this.input = input;
        this.splitter = new BufferedSplitter(delimiters);
    }

    public List<String> getTokens() {
        char[] charArray = input.toCharArray();
        for (Character character : charArray) {
            splitter.appendIfNotDelimiter(character);
        }
        return splitter.getTokens();
    }

}
