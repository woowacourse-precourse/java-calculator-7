package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        // 1. 사용자로부터 입력을 받는 기능
        String input = Console.readLine();
        System.out.println("입력받은 문자열: " + input);

        // 2. 입력된 문자열을 파싱하는 기능
        String delimiter = ",|:";
        String numbers = input;

        // 커스텀 구분자 확인
        if (input.startsWith("//")) {
            int delimiterIndex = input.indexOf("\n");
            if (delimiterIndex != -1) {
                delimiter = input.substring(2, delimiterIndex);
                numbers = input.substring(delimiterIndex + 1);
            }
        }

        System.out.println("사용된 구분자: " + delimiter);
        System.out.println("파싱할 숫자 문자열: " + numbers);

        // TODO: 나머지 기능 구현
    }
}