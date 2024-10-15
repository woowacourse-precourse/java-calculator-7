package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String inputText = Console.readLine();
        List<Integer> values = Arrays.stream(inputText.split("[,:]"))
                .map(Integer::parseInt).toList();
    }
}
