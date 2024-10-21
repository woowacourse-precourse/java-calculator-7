package calculator.util.converter;

import java.util.List;

public class LongConvertible implements NumberConvertible<Long> {

    @Override
    public List<Long> convertStringToNumber(final List<String> splitByRegex) {
        try {
            return splitByRegex.stream()
                    .filter(str -> str.length() > 0)
                    .map(Long::parseLong)
                    .map(this::getPositiveNumber)
                    .toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수 범위를 벗어난 수 또는 구분자를 제외한 문자열을 입력할 수 없습니다.");
        }
    }

    private Long getPositiveNumber(final Long number) {
        if (number <= 0) {
            throw new IllegalArgumentException("양수가 아닙니다.");
        }
        return number;
    }

}
