package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    /**
     * 커스텀 구분자 처리를 위한 이스케이프 문자와 특수문자를 담은 문자열
     */
    static final String special_letters = "+-*/%=><'\"\\";

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int result = 0;
        String identifier = ",|:"; // 구분자를 모아놓은 문자열
        System.out.println("덧셈할 문자열을 입력해 주세요.");

        String str = Console.readLine();
        if (str.equals("")) { // 빈 문자열인 경우
            System.out.println("결과 : 0");
        } else {
            if (str.startsWith("//")) { // 커스텀 구분자인 경우
                int lastIndex = str.indexOf("\\n");

                if (lastIndex == -1) {
                    throw new IllegalArgumentException();
                }

                String custom = str.substring(2, lastIndex);

                for (char c : custom.toCharArray()) {
                    if (special_letters.contains(c + "")) {
                        identifier += "|\\" + c;
                    } else {
                        identifier += "|" + c;
                    }
                }
                str = str.substring(lastIndex + 2);
            }
            String[] numbers = str.split(identifier);
            for (String s : numbers) {
                int num = Integer.parseInt(s);
                if (num < 0) {
                    throw new IllegalArgumentException();
                }
                result += Integer.parseInt(s);
            }
            System.out.println("결과 : " + result);
        }

    }
}
