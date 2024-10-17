package calculator.domain;

import camp.nextstep.edu.missionutils.Console;

public class Calculator {

    private Input input;

    public void start() {
        //추후에 이 기능은 다른 객체에서 실행 해야할까?
        System.out.println("덧셈할 문자열을 입력해주세요.");
        input = new Input(Console.readLine());
        if (input.isDefaultInput()) {
            //true 면 기본 구분자 기능 실행
            //false 면 커스텀 구분자 기능 실행
        }
    }



}
