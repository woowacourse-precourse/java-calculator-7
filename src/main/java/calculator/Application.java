package calculator;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        String stringValue  = InputString.input();
        // 커스텀 문자열 지정 방법 확인
        StringValueDivide.divide(stringValue); // 커스텀 구분자 선언 부분과 계산식 부분 으로 나눔
        String customDelimiterAssign = StringValueDivide.getCustomDelimiterAssign(); // 커스텀 구분자 선언 부분
        String expression = StringValueDivide.getExpression(); // 계산식 부분
        List<String> customDelimiterList = CustomDelimiter.getCustomDelimiterList(customDelimiterAssign); // 커스텀 구분자 리스트 받아오기
        List<Integer> numberList = Expression.getNumberList(expression); // 숫자 추출하기 (일단, 구분자 상관없이)
    }
}
