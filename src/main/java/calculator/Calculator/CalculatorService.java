package calculator.Calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CalculatorService {
    List<String> separatorList = new ArrayList<>();
    List<String> numberList = new ArrayList<>();

    public void calculateSum(String formula, String customSeparator) {
        // 구분자 설정
        separatorList.add(",");
        separatorList.add(":");

        // 커스텀 구분자 존재시 추가 구분자 설정
        if (customSeparator != null)
            separatorList.add(customSeparator);

        // 구분자로 문자열 분리
        separatorFormula(formula);
    }

    public void separatorFormula(String formula) {
        // separatorList의 구분자를 |로 연결해 정규 표현식 생성
        String separatorRegex = String.join("|", separatorList);

        // 문자열을 구분자들로 분리
        String[] numbers = formula.split(separatorRegex);

        numberList.addAll(Arrays.asList(numbers));
    }
}
