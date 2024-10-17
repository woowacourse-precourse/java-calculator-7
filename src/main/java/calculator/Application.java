package calculator;

import calculator.service.InputService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputService inputService = new InputService();

        // 기능 0 : 사용자가 덧셈할 문자열을 입력한다.
//        inputService.enterInput();

        // 기능 1 : 문자열 앞부분에 커스텀 구분자가 있는지 확인한다.
        if (inputService.isCustomDelimiter()) {
            System.out.println(inputService.getCustomDelimiter());
        } else {
            System.out.println("커스텀 구분자가 없습니다.");
        }
    }
}
