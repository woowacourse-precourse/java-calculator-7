package calculator.provider;

import java.util.ArrayList;
import java.util.List;

public class BufferedSplitter {

    private final List<Character> delimiters;
    private final List<String> storage;
    private final StringBuffer buffer;

    public BufferedSplitter(List<Character> delimiters) {
        this.delimiters = delimiters;
        storage = new ArrayList<>();
        buffer = new StringBuffer();
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
        String token = buffer.substring(0);
        storage.add(token);
        clearBuffer();
    }

    private void clearBuffer() {
        buffer.setLength(0);
    }

    private boolean isDelimiter(Character character) {
        return delimiters.contains(character);
    }

    public List<String> getTokens() {
        flush();
        return storage;
    }
}
