package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String inputText = Console.readLine();
        List<Integer> values = Arrays.stream(inputText.split("[,:]"))
                .map(Integer::parseInt).toList();
        Integer sum = 0;

        for (Integer value : values)
            sum += value;

        System.out.println(sum);
    }
}
