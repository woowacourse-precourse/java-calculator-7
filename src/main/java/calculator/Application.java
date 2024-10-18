package calculator;

import camp.nextstep.edu.missionutils.Console;
import java.util.Scanner;


public class Application {
    static String input;

    private static AdderScanner adderScanner;
    private static Adder adder;
    private static Printer printer;

    static void Input()  {

        //프로그램 실행시 문자열 데이터를 입력받아 String input에 저장한다.

        System.out.println("덧셈할 문자열을 입력해 주세요:");
        input=Console.readLine();

    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            Input();

            //문자열 데이터의 숫자를 분리
            adderScanner = new AdderScanner(input);

            // 분리된 숫자 데이터를 모두 더함
            adder=new Adder(adderScanner);

        } catch (IllegalArgumentException e) {
            //문자열을 분리할 때 잘못된 문자가 들어가면 예외 처리 한다.
            System.err.println(e.getMessage());
            throw e;
        } catch (Adder.OverflowException e) {
            //총 합이 오버플로루 날 경우 예외처리
            System.err.println(e.getMessage());
            throw e;
        }

        // 모두 더한 값을 출력
        printer=new Printer(adder);

        //결과값 출력
        printer.PrintOutput();

    }
}
