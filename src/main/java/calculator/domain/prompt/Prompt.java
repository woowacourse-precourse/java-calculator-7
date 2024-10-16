package calculator.domain.prompt;

import java.util.ArrayList;
import java.util.List;

public class Prompt {

    private static final char COMMA = ',';
    private static final char COLON = ':';

    public List<String> separate(String inputData) {
        List<String> separatedData = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (char word: inputData.toCharArray()) {
            if (word == COMMA || word == COLON) {
                separatedData.add(stringBuilder.toString());
                stringBuilder.setLength(0);
                continue;
            }
            stringBuilder.append(word);
        }
        separatedData.add(stringBuilder.toString());

        return separatedData;
    }

}
