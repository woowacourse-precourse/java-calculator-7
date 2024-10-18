package calculator;
import camp.nextstep.edu.missionutils.Console;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();
        int result = add(input);
        System.out.println("결과 : " + result);
    }

    public static int add(String input) {
        if (input == null || input.isEmpty()) {
            return 0;
        }
        String delimiter = ",|:";  // 기본 구분자는 쉼표와 콜론
        input = input.replace("\\n", "\n");

        if (input.startsWith("//")) {
            int delimiterEndIndex = input.indexOf("\n");
            delimiter = input.substring(2, delimiterEndIndex);  // 커스텀 구분자 처리
            input = input.substring(delimiterEndIndex + 1);
        }

        String[] tokens = input.split(delimiter);
        int sum = 0;
        for (String token : tokens) {
            sum += Integer.parseInt(token);
        }
        return sum;
    }
}