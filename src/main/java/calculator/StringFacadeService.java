package calculator;

import java.math.BigInteger;

/**
 * 메서드의 실행 순서가 중요하므로 Facade 패턴을 적용했다. 반드시 커스텀 구분자를 먼저 추가하고 문자열 파싱을 진행해야 한다.
 */
public class StringFacadeService {
    private final StringCalculator stringCalculator;

    public StringFacadeService() {
        this.stringCalculator = new StringCalculator();
    }

    public BigInteger addNumbersFromInput(String input) {
        String[] delimitersAndNumbers = stringCalculator.addCustomDelimiter(input); // 커스텀 구분자 추가하기
        return stringCalculator.addString(delimitersAndNumbers); // 구분자로 문자열 덧셈하기
    }
}
