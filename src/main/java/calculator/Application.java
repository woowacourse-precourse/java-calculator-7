package calculator;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        String customDivision = "";

        // 커스텀 구분자 구하기
        if (input.startsWith("//")) {
            input = input.substring(2);

            if (input.contains("\\n")) {
                for (int i = 1; i < input.length() - 2; i++) {
                    if (input.substring(i, i+2).equals("\\n")) {
                        customDivision = input.substring(0, i);
                        input = input.substring(i+2);
                        break;
                    }
                }
            }

            else {
                throw new IllegalArgumentException();
            }
        }

        // 구분자로 문자열 나누기
        input = input.replace(":", ",");
        input = input.replace(customDivision, ",");

        String[] split = input.split(",");

        // 합 구하기
        int result = 0;
        for (String s : split) {
            try {
                result += Integer.parseInt(s);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }

        System.out.println("결과 : " + result);

    }
}
