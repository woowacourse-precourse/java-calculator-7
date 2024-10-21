package calculator.domain.adder;

import calculator.domain.parser.InputParser.ParsedInput;
import java.math.BigDecimal;

public class NumberAdder {

    /**
     * 주어진 {@link ParsedInput}에서 숫자 토큰들을 추출해 모두 더한 후 결과를 반환합니다.
     *
     * @param parsedInput 숫자 토큰들을 포함하는 {@link ParsedInput} 객체
     * @return 계산된 결과를 문자열 형태로 반환
     */
    public String adder(ParsedInput parsedInput) {
        BigDecimal result = BigDecimal.ZERO;
        for (String numberToken : parsedInput.numbersToken()) {
            BigDecimal num = new BigDecimal(numberToken);
            result = result.add(num);
        }

        return result.toPlainString();
    }

}
