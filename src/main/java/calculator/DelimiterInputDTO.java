package calculator;

import java.util.List;

public class DelimiterInputDTO {

    List<Character> delimiter;
    String input;

    public DelimiterInputDTO(String input) {
        this.input = input;
    }

    public List<Character> getDelimiter() {
        return delimiter;
    }

    public void setDelimiter(List<Character> delimiter) {
        this.delimiter = delimiter;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

}
