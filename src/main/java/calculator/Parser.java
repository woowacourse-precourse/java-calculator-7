package calculator;

public class Parser {
    String SEPERATOR = ";";
    String input;

    Parser(String input) {
        this.input = input;
    }
    void replace() {
        input = input.replaceAll("[^0-9a-zA-Z]+", SEPERATOR);
    }
    String[] split() {
        return input.split(SEPERATOR);
    }
}
