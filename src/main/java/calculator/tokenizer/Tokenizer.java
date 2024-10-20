package calculator.tokenizer;

public interface Tokenizer {

    TokenResponse parse(String input);

    void setCustomDelimiter(String input);
}
