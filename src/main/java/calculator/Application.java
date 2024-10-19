package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        int result = 10;

        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        // 엔터, 공백 입력
        if (input.isBlank()) {
            result = 0;
        }

        //쉼표, 콜론을 사용하여 숫자 분리
        if (input.contains(",") || input.contains(":")) {
            String[] numbers = input.split("[,:]");
            for (String number : numbers) {
                System.out.println(number);
            }
        }

        //커스텀 구분자 처리           ;\n1;2;3
        if (input.startsWith("//")) {
            int idx = input.indexOf("\\n");
            String customDelimiter = input.substring(2, idx); // 구분자 추출
            String str = input.substring(idx + 2); // \n 뒷부분 추출
            String[] numbers = str.split(customDelimiter); // 커스텀 구분자로 분리
            for (String number : numbers) {
                System.out.println(number);
            }
        }
        System.out.println("Input : " + result);

    }

}
