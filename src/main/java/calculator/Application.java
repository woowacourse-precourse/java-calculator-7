package calculator;


import camp.nextstep.edu.missionutils.Console;

import java.util.NoSuchElementException;

public class Application {

    private final Calculator calculator;

    public Application() {

        this.calculator  = new Calculator();
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Application app = new Application();
        app.run();
    }

    public void run() {

        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = null;
        try{
            input = Console.readLine();
        }catch(NoSuchElementException e){
            System.out.println("결과 : 0");
            return;
        }


        int output = calculator.calculate(input);
        System.out.println("결과 : " + output);

    }
}
