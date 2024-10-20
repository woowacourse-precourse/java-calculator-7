package calculator.model;

import java.util.Arrays;
import java.util.List;

public class InputText {
    private final Delimiter delimiter;
    private final PlainText plainText;

    public InputText(String delimiter, String text) {
        this.delimiter = new Delimiter(delimiter);
        this.plainText = new PlainText(text);
        validateAfterInitialize(this.delimiter, this.plainText);
    }

    public List<Integer> tokenize() {
        return Arrays.stream(plainText.getValue().split(delimiter.getValue()))
                .filter(string -> !string.isEmpty())
                .map(Integer::parseInt)
                .toList();
    }

    private void validateAfterInitialize(Delimiter delimiter, PlainText plainText) {
        if (plainText.hasCharExcluding(delimiter)) {
            throw new IllegalArgumentException("구분자와 동일하지 않은 문자는 지원하지 않습니다.");
        }
    }
}