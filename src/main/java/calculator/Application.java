package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String data = Console.readLine();
        Result result = Validator.validate(data);

        if (!result.isCorrect) {
            raiseException(result.message, data);
        }

        System.out.println(data);
    }


    private static void raiseException(String message, String str) {
        throw new IllegalArgumentException(message + "\n" + "현재 입력값 : " + str);
    }
}
