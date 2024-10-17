package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        List<Integer> intNumber = new ArrayList<>();

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        String cuttingMark = ",|:";

        String[] numbers = input.split(cuttingMark);

        for (String number : numbers) {
            intNumber.add(Integer.parseInt(number));
        }

        int sum = 0;
        for (int i = 0; i < intNumber.size(); i++) {
            sum += intNumber.get(i);
        }

        System.out.println("결과 : " + sum);
    }
}
