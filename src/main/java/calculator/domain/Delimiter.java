package calculator.domain;

public class Delimiter {
    private final String symbol;

    public Delimiter(String symbol) {
        validateNotNullOrEmpty(symbol);
        this.symbol = symbol;
    }

    private void validateNotNullOrEmpty(String symbol) {
        if(symbol == null || symbol.isBlank()){
            throw new IllegalArgumentException("[ERROR] 구분자가 빈 문자열일 수 없습니다.");
        }
    }

}
