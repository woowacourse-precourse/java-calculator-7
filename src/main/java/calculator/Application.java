package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static String[] extraction(String input) {

        List<String> delimiters = new ArrayList<>();

        delimiters.add(",");
        delimiters.add(":");

        if (input.startsWith("//") && input.contains("\\n")) {
            String temp = input.substring(2, input.indexOf("\\n"));
            delimiters.add(temp);
            input = input.substring(input.indexOf("\\n") + 2);
        }

        String finalDelimiters = String.join("|", delimiters);
        String[] numbers = input.split(finalDelimiters);

        return numbers;
    }
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        String[] number = extraction(input);

        for (String num : number) {
            System.out.println(num);
        }
    }
}
