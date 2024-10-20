package calculator;

import adder.Adder;
import camp.nextstep.edu.missionutils.Console;
import parser.Parser;
import separator.Separator;

public class Application {
    public static void main(String[] args) {

        Adder adder = new Adder();
        Separator separator = new Separator();
        Parser parser = new Parser();

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        separator.saveSeparator(input);
        String stringToCalculate = parser.parseStringToCalculate(input);
        int result = adder.add(stringToCalculate);

        System.out.println("결과 : " + result);

    }
}
