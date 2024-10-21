package calculator.domain.delimiter;

/**
 * 주어진 문자열(InputtedString)에서 양수와 다른 양수를 나누는
 * 기준이 되는 문자인 구분자를 정의한 인터페이스
 */
public interface Delimiter {

    String getSymbol();
}
