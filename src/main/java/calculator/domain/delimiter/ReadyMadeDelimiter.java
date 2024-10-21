package calculator.domain.delimiter;

/**
 * 구분자 중 미리 정해진 구분자를 정의한 클래스.
 */
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