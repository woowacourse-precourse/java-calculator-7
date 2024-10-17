package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

public class Application {

    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String data = Console.readLine();
        Result validation = Validator.validate(data);

        if (!validation.isCorrect) {
            raiseException(validation.message, data);
        }

        String[] result = Converter.convert(data);
        System.out.println(Arrays.toString(result));
    }


    private static void raiseException(String message, String str) {
        throw new IllegalArgumentException(message + "\n" + "현재 입력값 : " + str);
    }
}
