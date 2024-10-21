package calculator;

import java.util.ArrayList;
import java.util.List;

public class Division {
    private final List<String> word = new ArrayList<>();

    public Division() {
        word.add(":");
        word.add(",");
    }

    public void add(String customWord) {
        word.add(customWord);
    }

    public String regularExpression() {
        StringBuilder regularWord = new StringBuilder();
        for (int i = 0; i < word.size(); i++) {
            regularWord.append(word.get(i));
            if (i != word.size() - 1) {
                regularWord.append("|");
            }
        }
        regularWord.append("\\\\");
        return String.valueOf(regularWord);
    }
}
