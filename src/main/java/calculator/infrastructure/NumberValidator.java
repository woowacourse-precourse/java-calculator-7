package calculator.infrastructure;

import calculator.domain.Number;
import java.util.ArrayList;
import java.util.List;

public class NumberValidator {
    /*
     * 구분자를 기준으로 잘라진 문자열을 숫자 리스트로 만들어 반환합니다.
     * 이때 각각의 잘라진 문자열이 올바른 숫자 형식인지 검증합니다.
     */
    public List<Number> makeNumberList(String[] splitStrBySeparators) {
        List<Number> numberList = new ArrayList<>();
        for (String splitStr : splitStrBySeparators) {
            numberList.add(new Number(splitStr));
        }
        return numberList;
    }
}
