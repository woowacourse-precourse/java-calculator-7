package calculator.model;

import calculator.dto.ExpressionDTO;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Pattern;

public class StringParser<T> implements Parser<T> {

    private final ExpressionDTO expressionDTO;

    public StringParser(ExpressionDTO expression) {
        this.expressionDTO = expression;
    }

    @Override
    public boolean checkIncorrectGrammar() {
        return Pattern.compile(expressionDTO.getIncorrectDelimiter())
                .matcher(expressionDTO.getExpression())
                .find();
    }

    @Override
    public List<T> parse(Function<String, T> typeToChange) {
        if (checkIncorrectGrammar()) {
            throw new IllegalArgumentException(expressionDTO.getExpression() + ": 문법에 어긋난 표현식입니다.");
        }
        return makeTokens().stream()
                .map(s -> changeNumberType(s, typeToChange))
                .toList();
    }

    private List<String> makeTokens() {
        String input = expressionDTO.getExpression();
        if (input.isEmpty()) {
            return Collections.emptyList();
        }
        return Arrays.stream(input.split(expressionDTO.getDelimiter()))
                .filter(token -> !token.isEmpty())  // 구분자가 서로 붙어 있는 경우에도 숫자 추출 가능(문자열 토큰이 ""이면 0으로 취급)
                .toList();
    }

    private T changeNumberType(String token, Function<String, T> typeToChange) {
        if (token.startsWith(".") || token.endsWith(".")) {
            throw new IllegalArgumentException(String.format("%s : 소수점의 위치가 적절하지 않습니다.", token));
        }
        try {
            return typeToChange.apply(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("%s : 소수점은 1개만 사용 가능합니다", token), e.fillInStackTrace());
        }
    }
}
