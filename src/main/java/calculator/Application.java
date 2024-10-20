package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static int stringCalc(String str) {
        // 문자열이 비어있거나 null이면 0을 출력
        if (str == null || str.isEmpty()) {
            return 0;
        }

        // 기본 구분자를 ",:"d으로 정함
        String separator = "[,:]";
        String[] numbers = str.split(separator);

        // 숫자 합계 출력
        int result = 0;
        for (String number : numbers) {
            result += Integer.parseInt(number);
        }
        return result;
    }

    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("덧셈할 문자열 : ");
        String str = Console.readLine();

        // 덧셈 결과 출력
        int answer = stringCalc(str);
        System.out.println("결과 : " + answer);
    }
}
