package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    private static final String INPUT_GUIDE = "덧셈할 문자열을 입력해 주세요.";
    private static final String OUTPUT_RESULT = "결과 : ";

    public static void main(String[] args) {
        // 입력
        System.out.println(INPUT_GUIDE);
        String input = Console.readLine();

        // 숫자 추출
        String[] split = input.split("[,:]");
        int result = 0;
        for (String strNum : split) {
            result += Integer.parseInt(strNum);
        }

        // 출력
        System.out.println(OUTPUT_RESULT + result);

        // scanner 닫기
        Console.close();
    }
}
