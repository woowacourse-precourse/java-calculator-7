package calculator.view;

import camp.nextstep.edu.missionutils.Console;

// 사용자 입력을 처리
public class InputView {

    public static String userInput() {
        System.out.println("기본 구분자 : 쉼표(,) 또는 콜론(:)");
        System.out.println("커스텀 구분자 지정 가능, '//'와 '\\n' 사이 위치하는 기호");
        System.out.println("위의 조건에 맞춰 더하고자 하는 수와 구분자를 포함하는 문자열을 입력해주세요. : ");
        return Console.readLine();
    }

}
