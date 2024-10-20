package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {

        Calculator cal = new Calculator();

        String str = Console.readLine();  // 사용자가 콘솔에 입력한 값 읽기
        Validate.check(str); // 입력 값 검증

        System.out.println("결과 : " + cal.Calculation(str));
    }
}
