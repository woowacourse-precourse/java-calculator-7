package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final String EXIT_COMMAND = "N";
    public static void main(String[] args) {
        Calculation calculation = new Calculation();

        while (true) {
            System.out.println("문자열 덧셈 계산기");
            System.out.print("계산하고 싶은 문자열을 입력하시오(종료를 원할시 'N'을 입력하세요): ");
            String input = Console.readLine();

            if (input.isEmpty()) {
                throw new IllegalArgumentException("문자열이 입력되지 않았습니다.");
            }

            if (input.equals(EXIT_COMMAND))
                break;

            String[] exactNumbers = calculation.filterNumbers(input);
        }
        System.out.println("지금까지 문자열 덧셈 계산기였습니다.");
    }
}
