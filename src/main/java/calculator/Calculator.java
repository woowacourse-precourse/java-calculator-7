package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Calculator {

    public void run() {
        System.out.println("덧셈할 문자열을 입력해주세요");
        String input_str = Console.readLine();

        String delimiter = ",|:";

        String[] result = CustomDelimeterParser.parse(input_str, delimiter);
        input_str = result[0];
        delimiter = result[1];

        List<Integer> nums = NumberExtractor.extractNums(input_str,delimiter);

        int sum = nums.stream().mapToInt(Integer::intValue).sum();
        System.out.println("결과 : "+sum);
    }
}
