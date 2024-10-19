package calculator.tokenizer;

public interface Tokenizer {

    TokenResponse parse(String input);

    void setDelimiter(String delimiter);
}
