package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        List<Integer> listNumber = new ArrayList<>();

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        String default_Delimiters = ",|:";
        String[] numbers = input.split(default_Delimiters);

        for (String number : numbers) {
            listNumber.add(Integer.parseInt(number));
        }

        int sum = listNumber.stream().mapToInt(i -> i).sum();

        System.out.println("sum = " + sum);
    }
}
