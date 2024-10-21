package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {

            Parsing parsing = new Parsing();
            Calculator calculator = new Calculator();

            System.out.println("덧셈할 문자열을 입력해 주세요.");
            String input = readLine();

            int[] numbers = parsing.parseInput(input);

            //계산
            int result = calculator.add(numbers);

            System.out.println("결과 : " + result);


    }
}
