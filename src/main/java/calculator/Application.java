package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        while (true) {
            System.out.println("문자열을 입력하시오(예: //;\\n1;2;3) : ");
            String input = Console.readLine().trim();
            try {
                int result = Calculator.add(input);
                System.out.println("결과: " + result);
                break;  // 유효한 입력이 들어오면 루프 종료
            } catch (IllegalArgumentException e) {
                System.err.println("입력 오류: " + e.getMessage());
                break;
            } catch (Exception e) {
                System.err.println("예외 발생: " + e.getMessage());
                break;
            }
        }
    }
}