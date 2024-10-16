package calculator.domain.model;

import java.util.List;

/**
 * 전처리된 입력값을 담는 클래스
 * unparsedNumber : parse 되기전의 숫자 문자열 (ex. 1;2;3)
 *
 * @param unparsedNumber
 * @param delimiters
 */
public record PreprocessedInput(String unparsedNumber, List<Character> delimiters) {}
