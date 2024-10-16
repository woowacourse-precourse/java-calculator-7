package calculator;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = readLine();
        int answer = 0;
        String[] strings = input.split(",|:");

        for (String str : strings) {
            answer += Integer.parseInt(str);
        }
        System.out.printf("결과 : %d", answer);
    }
}
