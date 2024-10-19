package calculator.Interface;

public interface Parser {
    void setInput(String input);
    void parseCustomSeparator();
    String[] getTokens();
    String createTokenSeparator();
}
