package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        String separator = ",|:";
        int sum = 0;
        Application app = new Application();

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = readLine();

        String[] separatedInput = input.split(separator);
        for (String num : separatedInput) {
            sum += app.stringToInt(num);
        }
        System.out.println("결과 : " + sum);
    }
    private int stringToInt(String num) {
        if (num.isBlank()) {
            return 0;
        }
        return Integer.parseInt(num);
    }
}
