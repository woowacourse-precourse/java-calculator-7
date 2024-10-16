package calculator.service;

import calculator.model.CalculatorLogic;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CalculatorService {
    private static final Pattern DANGLING_PATTERN = Pattern.compile( "[?*+()\\[\\]{}]"); //구분자 사용시 오류 발생 문자 확인 정규식
    private final CalculatorLogic calculatorLogic = new CalculatorLogic();

    public int calculate(String input) {
        Scanner sc = new Scanner(input);
        try {
            //validation에서 input에 대한 검증 코드 추가 - validation이 에러 throw 하면 하위 코드 실행 없이 controller로 에러 throw
            String delimiter = calculatorLogic.extractDelimiter(sc.nextLine());
            Matcher matcher = DANGLING_PATTERN.matcher(delimiter);
            if (matcher.find()) {
                delimiter = "\\" + delimiter; //dangling 오류 발생 문자 처리
            }

            if (sc.hasNext()) {
                return calculatorLogic.calculate(calculatorLogic.extractNumbers(sc.nextLine(), delimiter));
            }
            return calculatorLogic.calculate(calculatorLogic.extractNumbers(input, delimiter));

        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage(), e);
        }
    }
}
