package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {


    public static void main(String[] args) {
		Positive positive = StringCalculator.input();
		positive.printResult();
    }
}
