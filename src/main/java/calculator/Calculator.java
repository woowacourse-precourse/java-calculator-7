package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {
    public void run() {
        String input = getInput();
        String[] splitted = split(input);
        int result = add(splitted);

        System.out.println("결과 : " + result);
    } 

    private String getInput() {
        String input = "";

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        input = Console.readLine();

        return input;
    }

    private String[] split(String input) {
        String delimeter = ":|,";
        String[] splitted = input.split(delimeter);

        return splitted;
    }

    private int add(String[] splitted) {
        int total = 0;

        for (int i = 0; i < splitted.length; ++i) {
            total += Integer.parseInt(splitted[i]);
        }

        return total;
    }
}
