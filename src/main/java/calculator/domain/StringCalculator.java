package calculator.domain;

import calculator.Input;
import calculator.domain.delimiter_input.DelimiterInput;
import calculator.domain.delimiter_input.DelimiterInputFactory;
import calculator.parser.Parser;
import java.util.List;

/**
 * StringCalculator 클래스는 문자열을 파싱하여 덧셈 계산을 수행하는 역할을 합니다.
 */
public class StringCalculator {
    private final Parser parser;

    /**
     * StringCalculator 생성자입니다. Parser 객체를 받아서 초기화합니다.
     *
     * @param parser 문자열을 파싱하는 Parser 객체
     */
    public StringCalculator(Parser parser) {
        this.parser = parser;
    }

    /**
     * 입력된 문자열이 비어 있지 않으면 덧셈 계산을 수행하고, 비어 있으면 0을 반환합니다.
     *
     * @param input 계산할 문자열을 포함하는 Input 객체
     * @return 계산 결과를 담고 있는 CalcResult 객체
     */
    public CalcResult add(Input input) {
        if (input.isEmpty()) {
            return new CalcResult(0);  // 빈 문자열일 경우 0을 반환
        }

        return calculateSum(input);  // 입력값에 대한 덧셈 계산 수행
    }

    /**
     * 입력된 문자열을 구분자에 따라 분리하고, 각 숫자를 더한 결과를 반환합니다.
     *
     * @param input 계산할 문자열을 포함하는 Input 객체
     * @return 덧셈 결과를 담은 CalcResult 객체
     */
    private CalcResult calculateSum(Input input) {
        DelimiterInput delimiterInput = DelimiterInputFactory.createDelimiterInput(input);
        List<String> tokens = parser.parse(delimiterInput).getTokens();

        // 각 토큰을 정수로 변환한 후 합산하여 CalcResult 객체에 담아 반환
        return new CalcResult(tokens.stream()
                .mapToInt(Integer::parseInt)
                .sum());
    }
}
