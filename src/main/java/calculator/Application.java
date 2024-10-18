package calculator;

import java.io.Console;
import java.util.Scanner;


public class Application {
    static String input;
    private static AdderScanner adderScanner;
    private static Adder adder;
    private static Printer printer;

    static void Input()  {

        Scanner scanner=new Scanner(System.in);
        /*
        Console console = System.console();
       if(console == null) {
           System.out.println("콘솔을 지원하지 않는 환경입니다.");
           throw new Error();
           //System.exit(1);
       }
       input=console.readLine("덧셈할 문자열을 입력해 주세요.");

        */
       System.out.println("덧셈할 문자열을 입력해 주세요:");
       input=scanner.nextLine();
       //System.out.println("input:" +input);


    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        try {
            Input();
            adderScanner = new AdderScanner(input);
            adder=new Adder(adderScanner);
        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            throw e;
        }

        printer=new Printer(adder);

        //결과값 출력
        printer.PrintOutput();


    }
}
