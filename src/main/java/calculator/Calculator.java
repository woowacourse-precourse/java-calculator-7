package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {

    String delimiter = ",|:";

    public void run() {
        String input = getInput();

        String[] delimitedInput = delimitString(input);
        int sumOfInput = sumOfList(delimitedInput);

        System.out.println("결과 : " + sumOfInput);
    }

    public String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        return Console.readLine();
    }

    public String[] delimitString(String input) {
        return input.split(delimiter);
    }

    public int sumOfList(String[] input) {
        int total = 0;
        for (String s : input) {
            total += Integer.parseInt(s);
        }
        return total;
    }
}
