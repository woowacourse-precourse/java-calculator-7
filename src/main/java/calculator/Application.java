package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static final String INPUT_GUIDE = "덧셈할 문자열을 입력해 주세요.";
    private static final String OUTPUT_RESULT = "결과 : ";

    public static void main(String[] args) {
        // 입력
        System.out.println(INPUT_GUIDE);
        String input = Console.readLine();

        // 출력
        System.out.println(OUTPUT_RESULT + input);

        // scanner 닫기
        Console.close();
    }
}
