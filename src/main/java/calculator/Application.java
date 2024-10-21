package calculator;

import camp.nextstep.edu.missionutils.Console;
public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        //기본 구분자 등록
        Parser.setSeparator();

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        System.out.println("결과 : " +Parser.parseAndCalculate(Console.readLine()));

    }


}
