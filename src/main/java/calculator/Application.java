package calculator;

import camp.nextstep.edu.missionutils.Console;

/**
 * java-calculator 메인 클래스입니다.
 */
public class Application {
    /**
     * 문자열을 입력받아 계산하여 정답을 출력합니다.
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("덧셈할 문자열을 입력하세요.");

        String input = Console.readLine();

        System.out.println("결과 : " + Calculator.calculate(input));

    }


}
