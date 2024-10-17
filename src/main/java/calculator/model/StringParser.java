package calculator.model;

import calculator.dto.ExpressionDTO;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Pattern;

public class StringParser<E> implements Parser<E> {

    private final ExpressionDTO expressionDTO;

    public StringParser(ExpressionDTO expressionDto) {
        this.expressionDTO = expressionDto;
    }

    @Override
    public boolean checkIncorrectGrammar() {
        return Pattern.compile(expressionDTO.getIncorrectPattern())
                .matcher(expressionDTO.getExpression())
                .find();
    }

    @Override
    public List<E> parse(Function<String, E> valueType) {
        if (checkIncorrectGrammar()) {
            throw new IllegalArgumentException(String.format("%s : 문법에 어긋나는 표현식입니다.", expressionDTO.getExpression()));
        }
        return makeTokens().stream()
                .map(s -> changeNumberTypeOrThrowException(s, valueType))
                .toList();
    }

    private List<String> makeTokens() {
        String input = expressionDTO.getExpression();
        if (input.isEmpty()) {
            return Collections.emptyList();
        }
        return Arrays.stream(input.split(expressionDTO.getDelimiter()))
                .filter(token -> !token.isEmpty())  // 구분자가 나란히 있는 경우에도 숫자 추출 가능
                .toList();
    }

    private E changeNumberTypeOrThrowException(String token, Function<String, E> how) {
        try {
            return how.apply(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("%s : 정수형이나 실수형으로 변환할 수 없는 문자열입니다.", token));
        }
    }
}
