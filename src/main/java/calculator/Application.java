package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        Delimiter delimiter = new Delimiter();
        NumberAdder numberAdder = new NumberAdder();

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        if (input.isEmpty()) {
            System.out.println("결과 : 0");
        } else {
            String[] numbers = delimiter.split(input);
            long result = numberAdder.add(numbers);
            System.out.println("결과 : " + result);
        }
    }
}
