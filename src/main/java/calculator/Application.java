package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 숫자 계산기 프로그램 구현
        System.out.println("문자열을 입력하시오(예: //;\\n1;2;3) : ");
        String input = Console.readLine().trim();

        try {
            int result = Calculator.add(input);
            System.out.println("결과: " + result);
        } catch (IllegalArgumentException e) {
            System.err.println("입력 오류: " + e.getMessage());
            System.out.println(input);
        } catch (Exception e) {
            System.err.println("예외 발생: " + e.getMessage());
        }
    }
}