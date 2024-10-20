package calculator.service;

import calculator.domain.Delimiters;
import calculator.dto.Query;

public class DelimiterResolver {

    /**
     * @param query 커스텀 구분자로 검증된 문자열 또는 null
     * @return header에 맞는 구분자 {@link Delimiters}
     */
    public static Delimiters extractDelimiter(Query query) {
        Delimiters delimiters = new Delimiters();
        String header = query.header();
        if (header == null) {
            return delimiters;
        }
        delimiters.setCustomDelimiter(header.charAt(2));
        return delimiters;
    }
}
