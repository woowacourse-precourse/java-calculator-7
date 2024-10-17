package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Calculator {
    static String input = "";
    static List<String> separators = new ArrayList<>(Arrays.asList(",", ":"));

    Calculator() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        input = Console.readLine();
    }


    public void calculate() {
        findCustomSeparator();
        System.out.println("결과 : " + sum());
    }

    /**
     * findCustomSeparator(): 커스텀 구분자를 찾아 seperators 리스트에 추가한다.
     */
    private void findCustomSeparator() {
        if (input.startsWith("//")) {
            int separatorEndIndex = input.indexOf("\\n");
            String customSeparator = input.substring(2, separatorEndIndex);

            separators.add(customSeparator);
            input = input.substring(separatorEndIndex + 2);
        }
    }

    /**
     * sum(): 구분자를 이용해 문자열 분리 후 숫자들 합계 리턴
     *
     * @return : 합계
     */
    private Integer sum() {
        String[] numbers = input.split(separators.toString());

        try {
            return Arrays.stream(numbers)
                    .mapToInt(Integer::parseInt)
                    .sum();
        } catch (Exception e) {
            throw new IllegalArgumentException();
        }
    }
}
