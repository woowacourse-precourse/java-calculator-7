package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        String input = Console.readLine();
        System.out.println("답 : " + calculate(input));
    }

    private static int calculate(String input) {
        if (input == null || input.trim().isEmpty()) {
            return 0;
        }

        List<String> storage = new ArrayList<>();

        String[] numbers = input.split("[,:]");
        for (String number : numbers) {
            storage.add(number.trim());
        }

        int sum = 0;

        for (String num : storage) {
            if (!num.isEmpty()) {
                sum += Integer.parseInt(num);
            }
        }

        return sum;
    }
}
