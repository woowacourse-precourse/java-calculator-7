package calculator;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        ArrayList<String> parser = new ArrayList<String>(List.of(",", ":"));

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        if(input.equals("")){
            System.out.println("결과 : 0");
            return;
        }

        if (input.startsWith("//")) {
            int limitIndex = input.indexOf("\\n");
            if (limitIndex != -1) {
                String customParser = input.substring(2, limitIndex);
                parser.add(customParser);
                input = input.substring(limitIndex + 2);
            } else {
                throw new IllegalArgumentException();
            }
        }

        String delimiters = String.join("|", parser);
        String[] numbers = input.split(delimiters);

        int sum = 0;

        for (String number : numbers) {
            if (!number.isEmpty()) {
                try {
                    int num = Integer.parseInt(number);
                    if (num < 0) {
                        throw new IllegalArgumentException();
                    }
                    sum += num;
                } catch (NumberFormatException e) {
                    throw new IllegalArgumentException();
                }
            }
        }
        System.out.println("결과 : " + sum);
    }
}
