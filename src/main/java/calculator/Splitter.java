package calculator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Splitter {

    private final HashSet<Character> separators = new HashSet<>();

    public Splitter() {
        separators.add(',');
        separators.add(':');
    }

    public List<String> split(String target) {

        List<String> tokens = new ArrayList<>();
        String token = "";

        for (char ch : target.toCharArray()) {
            if (separators.contains(ch)) {
                tokens.add(token);
                token = "";
            }
            else
                token += ch;
        }
        tokens.add(token);

        return tokens;
    }
}
