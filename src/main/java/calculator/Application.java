package calculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int result = 0;

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = camp.nextstep.edu.missionutils.Console.readLine();

        // 기능 1: basic separator
        if (!input.isEmpty()) {
            String[] input_array = input.split(",|:");

            for (String operand: input_array) {
                result += Integer.parseInt(operand);
            }

            System.out.println("결과 : " + result);
        }
    }
}
