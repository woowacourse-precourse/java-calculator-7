package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        String inputString = readLine();
        Parser parser = new Parser();
        parser.parse(inputString);

        int sum = Calculator.sum(parser.getNums());
        System.out.println("결과 : " + sum);
    }

}
