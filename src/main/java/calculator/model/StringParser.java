package calculator.model;

import calculator.dto.ExpressionDTO;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Pattern;

public class StringParser<T> implements Parser<T> {

    private final ExpressionDTO expressionDTO;

    public StringParser(String input) {
        this.expressionDTO = new ExpressionDTO(input);
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
                .map(s -> changeNumberTypeOrThrowException(s, typeToChange))
                .toList();
    }

    public List<String> makeTokens() {
        String input = expressionDTO.getExpression();
        if (input.isEmpty()) {
            return Collections.emptyList();
        }
        return Arrays.stream(input.split(expressionDTO.getDelimiter()))
                .filter(token -> !token.isEmpty())  // 구분자가 서로 붙어 있는 경우에도 숫자 추출 가능
                .toList();
    }

    private T changeNumberTypeOrThrowException(String token, Function<String, T> typeToChange) {
        try {
            return typeToChange.apply(token);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("%s : 숫자 자료형으로 변환할 수 없는 문자열입니다.", token));
        }
    }
}
