package calculator;

import java.math.BigInteger;

public class StringFacadeService {
    private final StringCalculator stringCalculator;

    public StringFacadeService() {
        this.stringCalculator = new StringCalculator();
    }

    // 메서드의 실행 순서가 중요하므로 Facade 패턴을 적용.
    public BigInteger addNumbersFromInput(String input) {
        String[] delimiterAndNumbers = stringCalculator.addCustomDelimiter(input);
        return stringCalculator.addString(delimiterAndNumbers);
    }
}
