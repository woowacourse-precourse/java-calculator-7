package calculator.domain.calculator;

import java.util.ArrayList;
import java.util.List;

// Calculator 에서 prompt 입력받는 식으로 진행하기
public class Prompt {

    private static final char DELIMITER_COMMA = ',';
    private static final char DELIMETER_COLON = ':';

    public List<String> separate(String inputData) {
        List<String> separatedData = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (char word: inputData.toCharArray()) {
            if (word == DELIMITER_COMMA || word == DELIMETER_COLON) {
                separatedData.add(stringBuilder.toString());
                stringBuilder.setLength(0);
                continue;
            }
            stringBuilder.append(word);
        }
        separatedData.add(stringBuilder.toString());

        return separatedData;
    }

    public List<String> separate(String inputData, char customDelimiter) {
        List<String> separatedData = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();

        for (char word: inputData.toCharArray()) {
            if (word == DELIMITER_COMMA || word == DELIMETER_COLON || word == customDelimiter) {
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
