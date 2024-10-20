package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String data = Console.readLine();
        int result = calculate(data);
        System.out.println("결과 : " + result);
    }


    public static int calculate(String data) {
        if (data.isEmpty()) {
            return 0;
        }

        String[] numbers;

        if (data.contains(",")){
            numbers = data.split(",");
        } else if (data.contains(":")) {
            numbers = data.split(":");
        } else {
            throw new IllegalArgumentException("구분자 존재하지 않습니다.");
        }

        int sum = 0;

        for (String number : numbers) {
            sum += Integer.parseInt(number);
        }
        return sum;

    }
}
