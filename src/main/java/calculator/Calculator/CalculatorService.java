package calculator.Calculator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static calculator.Message.Message.*;

public class CalculatorService {
    List<String> separatorList = new ArrayList<>();
    List<String> numberList = new ArrayList<>();
    Long sum;

    public void calculateSum(String formula, String customSeparator) {
        separatorList.clear();
        numberList.clear();
        sum = 0L;

        // 구분자 설정
        separatorList.add(",");
        separatorList.add(":");

        // 커스텀 구분자 존재시 추가 구분자 설정
        if (customSeparator != null)
            separatorList.add(customSeparator);

        // 구분자로 문자열 분리
        separatorFormula(formula);

        // 숫자 또는 구분자가 아닌 값이 입력된 경우
        if (!checkValidNumber())
            throw new IllegalArgumentException(ERROR_MESSAGE);

        // 덧셈 연산 수행
        addNumbers();
    }

    public void separatorFormula(String formula) {
        // separatorList의 구분자를 |로 연결해 정규 표현식 생성
        String separatorRegex = String.join("|", separatorList);

        // 문자열을 구분자들로 분리
        String[] numbers = formula.split(separatorRegex);

        // 숫자 리스트에 숫자 담기
        numberList.addAll(Arrays.asList(numbers));
    }

    public Boolean checkValidNumber() {
        for (String number : numberList) {
            if (number.matches(".*[^0-9].*"))
                return false;
        }
        return true;
    }

    public void addNumbers() {
        try {
            for (String number : numberList) {
                if (number.isEmpty())
                    continue;
                sum += Long.parseLong(number);

                if (sum < 0)
                    throw new Exception(OVERFLOW_SUM_MESSAGE);
            }
        }
        catch (NumberFormatException e) {
            System.out.println(OVERFLOW_NUMBER_MESSAGE);
            sum = -1L;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            sum = -1L;
        }
    }

    public Long getSum() {
        return sum;
    }
}
