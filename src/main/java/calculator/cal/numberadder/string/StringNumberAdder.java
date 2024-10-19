package calculator.cal.numberadder.string;

import calculator.cal.numberadder.NumberAdder;
import java.util.List;

public class StringNumberAdder implements NumberAdder {

    private final StringParser stringParser = new StringParser();

    @Override
    public int addProcess(String inputString) {
        String separator = ",|:";
        int sum = 0;

        //숫자 추출 후 더하기
        List<Integer> numbers = stringParser.parseBySeparator(inputString, separator);
        for (Integer number : numbers) {
            sum += number;
        }
        return sum;
    }
}
