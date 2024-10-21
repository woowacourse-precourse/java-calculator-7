package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String readLine = Console.readLine();
        // 문자열을 입력하면 정수 연산 결과를 출력
        Calculator calculator = new Calculator(readLine);
        int calculating = calculator.calculating();
        Frontend frontend = new Frontend(calculating);
        frontend.printResult();
    }
}
