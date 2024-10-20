package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    private static final String delimiter = "[,:]";
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String numbers = Console.readLine();
        if (numbers.isEmpty()) {
            System.out.println("결과: 0");
            return;
        }
        List<String> split = List.of(numbers.split(delimiter));
        System.out.println("결과: " + split.stream().mapToInt(Integer::parseInt).sum());
    }
}
