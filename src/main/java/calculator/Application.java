package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        String description = "덧셈할 문자열을 입력해 주세요.";
        String result = "결과 : ";

        System.out.println(description);
        String input = Console.readLine();

        if (input.isEmpty()) {
            throw new IllegalArgumentException("Input String is empty. please check");
        }
        Calculator cal = new calculator.Calculator();
        String res = cal.doTask(input);

        result = result.concat(res);

        System.out.println(result);


    }
}
