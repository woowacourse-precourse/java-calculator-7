package calculator.service;

import calculator.model.Operand;

public interface ExtractorService {

    /**
     * 주어진 문자열에서 delimiter, expression을 추출하여 Operand 객체를 반환합니다.
     *
     * @param input 추출할 문자열
     * @return delimiter, expression을 가진 객체
     */
    Operand extract(String input);
}
