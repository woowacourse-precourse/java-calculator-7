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

                System.out.println("\\n 포함됨");
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

        System.out.println("customDivision : " + customDivision);
        System.out.println("input : " + input);

    }
}
