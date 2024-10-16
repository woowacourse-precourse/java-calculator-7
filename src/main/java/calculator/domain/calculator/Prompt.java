package calculator.domain.calculator;

import java.util.ArrayList;
import java.util.List;

// Calculator 에서 prompt 입력받는 식으로 진행하기
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
