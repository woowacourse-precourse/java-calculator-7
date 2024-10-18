package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        String str;

        if (args.length > 0) { // 주어지는 인자가 있을 경우
            str = args[0];
        } else { // 주어지는 인자가 없을 경우 직접 입력
            str = Console.readLine();
        }

        Calculator calculator = new Calculator(str);
        int calc = calculator.calc();

        System.out.println("결과 : " + calc);

    }
}

