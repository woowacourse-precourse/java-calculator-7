package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 숫자 계산기 프로그램 구현
        System.out.println("쉼표(,) 또는 콜론(:)으로 구분된 숫자를 입력하세요:");

        String input = Console.readLine();

        int result = Calculator.add(input);
        System.out.println("합계: " + result);
    }
}