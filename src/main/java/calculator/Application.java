package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = Console.readLine();
        /*
        System.out.println("입력값 : " + input);
        if (input.contains("\n")) {
            System.out.println("개행문자가 포함되어 있습니다.");
        } else {
            System.out.println("개행문자가 포함되어 있지 않습니다.");
        }

        input = input.replace("\\n", "\n");
        if (input.contains("\n")) {
            System.out.println("개행문자가 포함되어 있습니다.");
            System.out.println("결과 : " + input);
            System.out.println(input.indexOf("\n"));
        } else {
            System.out.println("개행문자가 포함되어 있지 않습니다.");
        } */
            StringAddCalculator stringAddCalculator = new StringAddCalculator();
            int result = stringAddCalculator.Calculator(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
