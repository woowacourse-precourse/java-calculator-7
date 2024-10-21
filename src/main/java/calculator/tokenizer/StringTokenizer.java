package calculator.tokenizer;

import java.util.ArrayList;
import java.util.List;

public class StringTokenizer {

    private final List<Character> delimiters;
    private final String string;
    private final List<String> storage;
    private final StringBuffer buffer;

    public StringTokenizer(String input, List<Character> delimiters) {
        this.delimiters = delimiters;
        this.string = input;
        this.storage = new ArrayList<>();
        this.buffer = new StringBuffer();
    }

    public List<String> getTokens() {
        char[] charArray = string.toCharArray();
        for (Character character : charArray) {
            appendIfNotDelimiter(character);
        }
        flush();
        return storage;
    }

    public void appendIfNotDelimiter(Character character) {
        if (isDelimiter(character)) {
            flush();
            return;
        }
        buffer.append(character);
    }

    private void flush() {
        if (buffer.isEmpty()) {
            return;
        }
        String token = buffer.toString();
        storage.add(token);
        clearBuffer();
    }

    private void clearBuffer() {
        buffer.setLength(0);
    }

    private boolean isDelimiter(Character character) {
        return delimiters.contains(character);
    }

}
