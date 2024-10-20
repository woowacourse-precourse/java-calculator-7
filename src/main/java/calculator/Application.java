package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        String input1;
        String[] tokens;
        String regex;
        ArrayList<Integer> numbers = new ArrayList<>();
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        input1 = Console.readLine();
        if (input1.substring(0, 2).equals("//")) {
            if (input1.indexOf("\\n") != -1) {
                regex = '[' + input1.substring(2, input1.indexOf("\\n")) + ']';
                input1 = input1.substring(input1.indexOf("\\n") + 2, input1.length());
            } else {
                return;
            }
        } else {
            regex = "[,:]";
        }
        tokens = input1.split(regex);

        for (String token : tokens) {
            try {
                numbers.add(Integer.parseInt(token));
                if (Integer.parseInt(token) < 0) {
                    throw new IllegalArgumentException();
                }
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }

        int sum = 0;
        for (int i : numbers) {
            sum += i;
        }

        System.out.println("결과 : " + sum);

    }
}
