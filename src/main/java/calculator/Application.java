package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = readLine();

        if (input == null || input.isEmpty()) {
            System.out.println("결과 : " + 0);
            return;
        }

        try {
            String[] numbers = new StringHandler().split(input, ",|:");
            Calculator calculator = new Calculator();
            int result = 0;
            for (String number : numbers) {
                int num = Integer.parseInt(number);
                if (num < 0) {
                    throw new IllegalArgumentException("잘못된 입력 형식입니다.");
                }
                result = calculator.add(result, num);
            }
            System.out.println("결과 : " + result);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}
