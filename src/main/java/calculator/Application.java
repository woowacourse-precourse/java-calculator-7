package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 사용자로부터 문자열을 입력받음
        System.out.print("덧셈할 문자열을 입력해 주세요 : ");
        String input = Console.readLine();
        System.out.println("입력한 문자열: " + input);
    }

    public static int add(int... numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }
}
