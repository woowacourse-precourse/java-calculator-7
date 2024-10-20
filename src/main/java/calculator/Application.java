package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        String input1;

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        input1 = Console.readLine();

        String[] tokens = input1.split("[,:]");
        ArrayList<Integer> numbers = new ArrayList<>();
        for (String token : tokens) {
            try {
                numbers.add(Integer.parseInt(token));
            } catch (NumberFormatException e) {
                System.out.println("숫자X " + token);
            }
        }

        int sum = 0;
        for (int i : numbers) {
            sum += i;
        }

        System.out.println(sum);
    }
}
