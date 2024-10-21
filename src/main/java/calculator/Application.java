package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        Division division = new Division();
        Input input = new Input();
        Calculator calculator = new Calculator();

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        if (input.isCustomDivision()) {
            String customDivision = input.findCustomDivision();
            division.add(customDivision);
        }
        String inputWord = input.numbers();
        calculator.run(inputWord, division);

        System.out.println("결과 : " + calculator.result());
    }
}
