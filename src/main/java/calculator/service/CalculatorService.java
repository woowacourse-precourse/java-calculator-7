package calculator.service;

import java.math.BigInteger;
import java.util.ArrayList;

public class CalculatorService {

    //TODO: 입력에 대한 문자열 처리, 계산 등을 진행하는 클래스

    public BigInteger calcInput(String input) {

        BigInteger result = BigInteger.ZERO;

        result = result.add(parseBigInteger(input));

        return result;
    }

    private BigInteger parseBigInteger(String input) {

        try {
            return new BigInteger(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("지정된 구분자 이외의 문자가 발견되었습니다.");
        }
    }
}
