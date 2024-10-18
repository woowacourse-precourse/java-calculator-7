package calculator;

import java.io.Console;
import java.util.Scanner;


public class Application {
    static String input;

    private static AdderScanner adderScanner;
    private static Adder adder;
    private static Printer printer;

    static void Input()  {

        //프로그램 실행시 문자열 데이터를 입력받아 String input에 저장한다.


        //gradle을 이용한 test 환경에서 지원하지 않아 주석처리 하였다.
        /*
        Console console = System.console();
        if(console == null) {
            System.out.println("콘솔을 지원하지 않는 환경입니다.");
            throw new Error();
            //System.exit(1);
        }
        input=console.readLine("덧셈할 문자열을 입력해 주세요.");

         */

        Scanner scanner=new Scanner(System.in);
        System.out.println("덧셈할 문자열을 입력해 주세요:");
        input=scanner.nextLine();

    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        //문자열 데이터의 숫자를 분리
        try {
            Input();
            adderScanner = new AdderScanner(input);

        } catch (IllegalArgumentException e) {
            //문자열을 분리할 때 잘못된 문자가 들어가면 예외 처리 한다.
            System.err.println(e.getMessage());
            throw e;
        }

        // 분리된 숫자 데이터를 모두 더함
        adder=new Adder(adderScanner);

        // 모두 더한 값을 출력
        printer=new Printer(adder);

        //결과값 출력
        printer.PrintOutput();

    }
}
