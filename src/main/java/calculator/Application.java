package calculator;

import camp.nextstep.edu.missionutils.Console;

public class Application {

    public static void main(String[] args) {

        Separator separator = new Separator();
//        입력받기.
        String input = getInput();

//        //으로 시작하는 경우 커스텀 구분자 추출하기.
        if (input.startsWith("//")) {
            input = separator.extractCustomSeparatorFrom(input);
        }
    }

    public static String getInput() {
        System.out.println("덧셈할 문자열을 입력해 주세요. ");
        return Console.readLine();
    }
    }
}
