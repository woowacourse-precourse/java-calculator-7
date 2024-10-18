package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = Console.readLine();

        StringConvertFactory stringConvertFactory = new StringConvertFactory();
        String[] strings = stringConvertFactory.parseString(input);

        if (strings.length == 1) {
            System.out.println(strings[0]);
            return;
        }
    }
}
