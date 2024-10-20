package calculator.service.parser;

import calculator.domain.Delimiters;
import calculator.domain.Numbers;
import calculator.dto.Query;
import calculator.service.DelimiterResolver;

/**
 * {@link Query}을 {@link Numbers}  로 분해
 */
public class NumbersParser implements Parser<Query, Numbers> {

    /**
     * @param input 숫자와 구분자가 포함된 문자열
     * @return {@link Numbers}
     * @throws IllegalArgumentException
     */
    @Override
    public Numbers parser(Query input) throws IllegalArgumentException {
        Delimiters delimiters = DelimiterResolver.extractDelimiter(input);
        String body = input.body();
        return convertStringToNumbers(body, delimiters);
    }

    private Numbers convertStringToNumbers(String body, Delimiters delimiters) {
        try {
            String pattern = delimiters.toRegexPattern();
            String[] split = body.split(pattern);// 구분자를 정규식으로 변환 후 이를 기준으로 문자열 분해
            return Numbers.from(split);// 분해된 문자열 숫자들을 Numbers로 변환
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("invalid delimiter: there's no matching delimiter in body ->" + body);
        }
    }
}
