package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
    System.out.println("덧셈할 문자열을 입력해 주세요.");
    String input = Console.readLine();
        try {
        splitAndSum(input);
    } catch (IllegalArgumentException e) {
        System.out.println(e.getMessage()); // 예외 발생 시 메시지 출력
    }
}

    public static void splitAndSum(String input) {
        if (input.isEmpty()) {
            System.out.println("결과: 0");
            return;
        }
        String[] strArr = input.split(",|:");
        int sum = 0;
        for (String str : strArr) {
            sum += Integer.parseInt(str);
        }
        System.out.println("결과: " + sum);
    }


}
