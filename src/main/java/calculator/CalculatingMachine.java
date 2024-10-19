package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;

public class CalculatingMachine {
    private final FormulaParsing formulaParsing = FormulaParsing.getInstance();

    public void CalculatingFormula() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String calcFormula = readLine();

        String customSeparator = formulaParsing.extractCustomSeparator(calcFormula);
        List<Long> numbers = formulaParsing.extractNumber(calcFormula, customSeparator);

        System.out.print("결과 : " + calcNumbers(numbers));
    }

    private long calcNumbers(List<Long> numbers) {
        long maxValue = Long.MAX_VALUE;
        long sum = 0L;

        for (long number : numbers) {
            if (maxValue - number < 0) {
                throw new IllegalArgumentException("결과값이 long 범위를 넘어갔습니다.");
            } else {
                sum += number;
                maxValue -= number;
            }
        }

        return sum;
    }
}
