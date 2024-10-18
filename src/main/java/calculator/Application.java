package calculator;

import calculator.domain.UserInput;
import calculator.service.InputReceiverService;
import calculator.service.ParserService;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        //값을 입력받아 UserInput 형태로 돌려주는 InputReceiverService 초기화
        InputReceiverService inputReceiver = new InputReceiverService();
        ParserService parserService = new ParserService();

        try {
            UserInput userInput = inputReceiver.getUserInput();
            parserService.checkUserInputEmpty(userInput);

        } catch (IllegalArgumentException e) {
            System.out.println("입력하신 값에 오류가 있습니다. 다시 입력해 주세요.");
        }
    }
}
