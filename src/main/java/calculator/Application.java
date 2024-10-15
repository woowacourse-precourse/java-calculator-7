package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

import calculator.View.ResultView;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String input = readLine();
        try{
            int result = StringAddCalculator.calculate(input);
            ResultView.printResult(result);
        } catch (IllegalArgumentException e){
            System.out.println("에러: " + e.getMessage());
        }
    }
}
