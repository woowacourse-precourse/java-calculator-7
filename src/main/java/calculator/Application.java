package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String input = Console.readLine();
        int sum = 0;
        boolean customized = false;
        char custom = ',';

        if (input.charAt(0) == '/' && input.charAt(1) == '/' && input.charAt(3) == '\\' && input.charAt(4) == 'n') {
            customized = true;
            custom = input.charAt(2);
            input = input.substring(5, input.length());
        }

        for (byte value : input.getBytes()) {
            if (value >= '0' && value <= '9') {
                sum += value - '0';
            } else if (customized && value != (byte) custom) {
                throw new IllegalArgumentException();
            } else if (!customized && (value != ',' && value != ':')) {
                throw new IllegalArgumentException();
            }
        }

        System.out.println("결과 : " + sum);

        Console.close();
    }
}
