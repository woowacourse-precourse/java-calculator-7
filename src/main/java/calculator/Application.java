package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        String input = Console.readLine();
        // 콘솔에 입력되는 \n은 \\n으로 인식된다.
        input = input.replace("\\n", "\n");

        StringCalculator calc = new StringCalculator(input);
        System.out.println("결과 : " + calc.doSum());
    }
}
