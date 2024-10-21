package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 입력
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        if(input.isEmpty()) throw new IllegalArgumentException("빈 문자열 입니다.");
        else try { //출력
            int result = StringCalculator.add(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
