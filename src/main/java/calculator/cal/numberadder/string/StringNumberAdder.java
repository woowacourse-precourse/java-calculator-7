package calculator.cal.numberadder.string;

import calculator.cal.numberadder.NumberAdder;
import java.util.List;

public class StringNumberAdder implements NumberAdder {

    private final StringParser stringParser = new StringParser();
    private final CustomSeparatorParser customSeparatorParser = new CustomSeparatorParser();

    @Override
    public int addProcess(String inputString) {
        int sum = 0;

        //커스텀 구분자 추출
        String[] separatorAndInputString = customSeparatorParser.separatorParse(inputString);
        String separator = separatorAndInputString[0];
        inputString = separatorAndInputString[1];

        //숫자 추출 후 더하기
        try {
            List<Integer> numbers = stringParser.parseBySeparator(inputString, separator);
            for (Integer number : numbers) {
                sum = Math.addExact(number, sum);
            }
            return sum;
        } catch (NumberFormatException | ArithmeticException e) {
            throw new IllegalArgumentException("너무 큰 숫자를 입력했습니다.");
        }
    }
}
