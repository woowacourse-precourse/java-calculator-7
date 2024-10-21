package calculator.domain.delimiter;

public class ReadyMadeDelimiter implements Delimiter {

    private final String symbol;

    public ReadyMadeDelimiter(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String getSymbol() {
        return symbol;
    }
}